package com.SoridanSamai.spaceShipCrawl.enemies;

import com.SoridanSamai.spaceShipCrawl.Reference;
import com.SoridanSamai.spaceShipCrawl.world.Tile;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

/**
 *
 * @author simlin329
 */
public class Entity {

    Point pos, lastPos, target;

    BufferedImage bim;

    public Entity() {
        this(1, 1);
    }

    public Entity(int x, int y) {
        pos = new Point(x, y);
        target = new Point(pos.y, pos.x + 10);
        updatelastpos();
        try {
            initImage();
        } catch (IOException ex) {
            Logger.getLogger(Entity.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updatelastpos() {
        lastPos = new Point(pos);
    }

    public Point getPosition() {
        return pos;
    }

    public void update(double delta) {
        pos.translate(1, 0);
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
        g.fillOval(pos.x * Reference.TILE_WIDTH,
                pos.y * Reference.TILE_WIDTH,
                Reference.TILE_WIDTH,
                Reference.TILE_HEIGHT);
        int x = pos.x;
        int y = pos.y;

        AffineTransform xform = new AffineTransform();
        xform.translate(x * Reference.TILE_WIDTH, y * Reference.TILE_HEIGHT);
        g.drawImage(bim, xform, null);
    }

    protected void initImage() throws IOException {

    }

    public void setTarget(Point p) {
        target = p;
    }
}
