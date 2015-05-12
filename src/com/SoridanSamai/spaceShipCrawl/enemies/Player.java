package com.SoridanSamai.spaceShipCrawl.enemies;

import com.SoridanSamai.spaceShipCrawl.KeyboardModule;
import com.SoridanSamai.spaceShipCrawl.Reference;
import com.SoridanSamai.spaceShipCrawl.SpaceShipCrawl;
import java.awt.Color;
import java.awt.Graphics2D;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author simlin329
 */
public class Player extends Entity {

    public Player() {
        super();
    }
    public Player(int x, int y){
        super(x, y);
    }

    @Override
    protected void initImage() throws IOException {
   bim = ImageIO.read(Reference.ENTITY_PICTURE); }
    

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

//    @Override
//    public void paint(Graphics2D g) {
//        g.setColor(Color.black);
//        g.fillOval(pos.x * Reference.TILE_WIDTH,
//                pos.y * Reference.TILE_WIDTH,
//                Reference.TILE_WIDTH,
//                Reference.TILE_HEIGHT);
//    }

}
