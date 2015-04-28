package com.SoridanSamai.spaceShipCrawl.world;

import com.SoridanSamai.spaceShipCrawl.Reference;
import com.SoridanSamai.spaceShipCrawl.enemies.Entity;

import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author simlin329
 */
public class Deck {

    Tile[][] schematic;
    ArrayList<Entity> population = new ArrayList<>();

    public Deck(int x, int y) {
        schematic = new Tile[x][y];
        population.add(new Entity());
    }

    public void basicFlooring() {
        for (int x = 0; x < schematic.length; x++) {
            for (int y = 0; y < schematic[x].length; y++) {
                schematic[x][y] = new Tile();
            }
        }
    }

    public void advancedFlooring() {
        for (int x = 0; x < schematic.length; x++) {
            for (int y = 0; y < schematic[x].length; y++) {

                int z = (int) (Math.random() * 2);

                try {
                    schematic[x][y] = new Tile(1);
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

    public void updatePopulation(double delta) {
        for (int i = 0; i < population.size(); i++) {
            Entity e1 = population.get(i);

            int err = 0;
            boolean test;
            do {
                if (err >= 1) {
                    e1.collide(schematic[e1.getPosition().x][e1.getPosition().y]);
                }
                if (err >= 8) {
                    break;
                }
                e1.update(delta);
                try {
                    test = schematic[e1.getPosition().x][e1.getPosition().y].isPassable();
                } catch (java.lang.ArrayIndexOutOfBoundsException e) {
                    try {
                        e1.collide(new Tile(Tile.WALL));
                    } catch (Exception ex) {
                    }
                    test = false;
                }

                err++;

            } while (!(test && err < 0));

            for (int j = i + 1; j < population.size(); j++) {
                Entity e2 = population.get(j);
                if (e1.isColliding(e2)) {
                    e1.collide(e2);
                }
            }
        }
    }

}
