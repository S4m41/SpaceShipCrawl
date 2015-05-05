package com.SoridanSamai.spaceShipCrawl.enemies;

import com.SoridanSamai.spaceShipCrawl.Reference;
import com.SoridanSamai.spaceShipCrawl.world.Tile;
import java.awt.*;
import java.lang.ref.ReferenceQueue;

/**
 *
 * @author simlin329
 */
public class Entity {

    Point pos, lastPos;

    public Entity() {
        this(1,1);
    }

    public Entity(int x, int y) {
        pos = new Point(x, y);
        updatelastpos();
    }

    private void updatelastpos() {
        lastPos = new Point(pos);
    }

    public Point getPosition() {
        return pos;
    }

    public void update(double delta) {
        pos.translate(1,0);
    }

    public boolean isColliding(Entity e2) {
        return this.pos.equals(e2.pos);
    }

    public void collide(Entity e2) {
        this.pos = new Point(lastPos);
    }
    public void collide(Tile t2) {
        this.pos = new Point(lastPos);
    }

    public void paint(Graphics2D g) {
        g.setColor(Color.red);
        g.fillOval(pos.x * Reference.TILE_WIDTH, pos.y * Reference.TILE_WIDTH, Reference.TILE_WIDTH, Reference.TILE_HEIGHT);
    }
}
