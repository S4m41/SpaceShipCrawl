package com.SoridanSamai.spaceShipCrawl.enemies;

import com.SoridanSamai.spaceShipCrawl.KeyboardModule;
import com.SoridanSamai.spaceShipCrawl.Reference;
import com.SoridanSamai.spaceShipCrawl.SpaceShipCrawl;
import com.SoridanSamai.spaceShipCrawl.Start;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;

/**
 *
 * @author simlin329
 */
public class Player extends Entity {

    @Override
    public void update(double delta) {
        KeyboardModule km = SpaceShipCrawl.km;
        if (km.isPressed('e')) {
            System.exit(0);
        }
        if (km.isPressed('a')) {
            this.pos.translate(-1, 0);
        }
        if (km.isPressed('d')) {
            this.pos.translate(1, 0);
        }
        if (km.isPressed('w')) {
            this.pos.translate(0, -1);
        }
        if (km.isPressed('s')) {
            this.pos.translate(0, 1);
        }
    }

    @Override
    public void paint(Graphics2D g) {
        g.setColor(Color.black);
        g.fillOval(pos.x * Reference.TILE_WIDTH,
                pos.y * Reference.TILE_WIDTH,
                Reference.TILE_WIDTH,
                Reference.TILE_HEIGHT);
    }

}
