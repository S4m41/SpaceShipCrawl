package com.SoridanSamai.spaceShipCrawl.enemies;

import com.SoridanSamai.spaceShipCrawl.Reference;
import com.SoridanSamai.spaceShipCrawl.world.Tile;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Point;
import java.lang.ref.ReferenceQueue;

/**
 *
 * @author simlin329
 */
public class Entity {

    Point pos, lastPos;

    public Entity() {
        pos = new Point(0, 0);
        updatelastpos();
    }

    public Entity(int x, int y) {
        pos = new Point(x, y);
        updatelastpos();
    }

    private void updatelastpos() {
        lastPos = pos;
    }

    public Point getPosition() {
        return pos;
    }

    public void update(double delta) {
        
    }

    public boolean isColliding(Entity e2) {
        return this.pos.equals(e2.pos);
    }

    public void collide(Entity e2) {
        this.pos = lastPos;
    }
    public void collide(Tile t2) {
        this.pos = lastPos;
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.red);
        g.fillOval(pos.x * Reference.TILE_WIDTH, pos.y * Reference.TILE_WIDTH, Reference.TILE_WIDTH, Reference.TILE_HEIGHT);
    }
}
