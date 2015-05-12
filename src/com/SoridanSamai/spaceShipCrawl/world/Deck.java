package com.SoridanSamai.spaceShipCrawl.world;

import com.SoridanSamai.spaceShipCrawl.Reference;
import com.SoridanSamai.spaceShipCrawl.enemies.Entity;
import com.SoridanSamai.spaceShipCrawl.enemies.Player;

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 *
 * @author simlin329
 */
public class Deck {

    Tile[][] schematic;
    ArrayList<Entity> population = new ArrayList<>();

    public Deck(int x, int y) {
        schematic = new Tile[x][y];
    }

    public void basicFlooring() {
        for (int x = 0; x < schematic.length; x++) {
            for (int y = 0; y < schematic[x].length; y++) {
                schematic[x][y] = new Tile();
            }
        }
    }

    public void basicPopulation() {
        population.add(new Player(19, 19));
        population.add(new Entity(20, 20));
    }

    public void advancedFlooring() {
        int level = (int) (1 + Math.random() * 2);
        byte[][] readlist = MapReader.read("level" + level + ".txt");

        for (int x = 0; x < readlist.length; x++) {
            for (int y = 0; y < readlist[x].length; y++) {
                try {
                    schematic[x][y] = new Tile(readlist[x][y]);
                } catch (Exception e) {
                }
            }
        }
    }

    public void paint(Graphics2D g) {
        for (int x = 0; x < schematic.length; x++) {
            for (int y = 0; y < schematic[x].length; y++) {
                Tile t = schematic[x][y];
                AffineTransform xform = new AffineTransform();
                xform.translate(x * Reference.TILE_WIDTH, y * Reference.TILE_HEIGHT);
                BufferedImage bim = t.getImage();
                g.drawImage(bim, xform, null);
            }
        }
        for (Entity e : population) {
            e.paint(g);
        }
    }

    private void collissions(Entity e, double delta) {
        int err = 0;
        boolean test = false;
        do {
            if (err >= 1) {
                e.collide(schematic[e.getPosition().x][e.getPosition().y]);
                if (err >= 7) {
                    break;
                }
            }

            e.update(delta);
            try {
                test = schematic[e.getPosition().x][e.getPosition().y].isPassable();
            } catch (java.lang.ArrayIndexOutOfBoundsException e1) {
                try {
                    e.collide(new Tile(Tile.WALL));
                } catch (Exception ex) {
                }
                test = false;
            }

            err++;

        } while (!test);
    }

    public boolean isPassable(int x, int y) {
        return schematic[x][y].isPassable();
    }

    public void updatePopulation(double delta) {
        for (int i = 0; i < population.size(); i++) {
            Entity e1 = population.get(i);

            collissions(e1, delta);

            if (e1 instanceof Player) {
//                ta position
                Point F = new Point(e1.getPosition());
                set.add(F);
                floodfill(set);
//                floodfill
                //                  i floodfill
                //                  denna ruta
                //                  rutorna brevid
                //                      om rutorna brevid=passable
                //                          lägg till punkt
                //                          för varje tillagd punkt
                //                                floodfill
            }

            for (int j = i + 1; j < population.size(); j++) {
                Entity e2 = population.get(j);

                if (e1.isColliding(e2)) {
                    e1.collide(e2);
                }
            }
            e1.updatelastpos();
        }
    }
    HashSet<Point> set = new HashSet();

    private void floodfill(HashSet<Point> set) {
        for (Point p : set) {
            if (set.isEmpty() || !isPassable(p.x, p.y)) {
            } else{
                HashSet<Point> nextSet=new HashSet();
                
                if( isPassable(p.x-1, p.y)){
                    nextSet.add(new Point(p.x-1,p.y));
                }
                if( isPassable(p.x-1, p.y-1)){
                    nextSet.add(new Point(p.x-1,p.y-1));
                }
                if( isPassable(p.x, p.y-1)){
                    nextSet.add(new Point(p.x,p.y-1));
                }
                if( isPassable(p.x+1, p.y-1)){
                    nextSet.add(new Point(p.x+1,p.y-1));
                }
                  if( isPassable(p.x+1, p.y)){
                    nextSet.add(new Point(p.x+1,p.y));
                }
                if( isPassable(p.x+1, p.y+1)){
                    nextSet.add(new Point(p.x+1,p.y+1));
                }
                if( isPassable(p.x, p.y+1)){
                    nextSet.add(new Point(p.x,p.y+1));
                }
                if( isPassable(p.x-1, p.y+1)){
                    nextSet.add(new Point(p.x-1,p.y+1));
                }
                for(Point lsdkfs : nextSet){
                    for(Entity e: population){
                        if(e.getPosition().equals(lsdkfs)){
                            e.setTarget(p);
                        }
                    }
                }
                set.clear();
                floodfill(nextSet);
                nextSet.clear();
            }
        }
    }
}
