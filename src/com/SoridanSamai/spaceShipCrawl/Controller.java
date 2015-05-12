package com.SoridanSamai.spaceShipCrawl;

import java.awt.Graphics2D;

import com.SoridanSamai.spaceShipCrawl.world.Deck;
import com.SoridanSamai.spaceShipCrawl.world.Ship;
import com.SoridanSamai.spaceShipCrawl.world.Tile;
import java.awt.event.KeyEvent;

/**
 *
 * @author simlin329
 */
public class Controller {

    private final KeyboardModule km = SpaceShipCrawl.km;
    private final MouseModule mm = SpaceShipCrawl.mm;

    private int[] inputkeys = {KeyEvent.VK_W, KeyEvent.VK_A, KeyEvent.VK_S, KeyEvent.VK_D};

    private boolean shouldMove = true;
    Ship stage = new Ship();
    UI ui = new UI();

    public Controller() {
        Tile.initImages();
        Deck add = new Deck(Reference.WORLD_WIDTH, Reference.WORLD_HEIGHT);
        //  add.basicFlooring();
        add.advancedFlooring();
        add.basicPopulation();
        stage.addDeck(add);
    }

    void paint(Graphics2D g) {
        Deck d = stage.getActive();
        d.paint(g);
        ui.paint(g);
    }
    double timer = 0;

    void update(double delta) {
        ui.update(delta);
        if (shouldMove) {
            updateBoard(delta);
        } else {
            for (int key : inputkeys) {
                if (km.isPressed(key)) {
                    shouldMove = true;
                    break;
                }
            }
//            timer += (1e9 * delta / Reference.TARGET_FPS);
//            if (timer >= 1e9) {
//                shouldMove = true;
//                timer = 0;
//            }
        }

    }

    private void updateBoard(double delta) {
        Deck d = stage.getActive();
        d.updatePopulation(delta);
        shouldMove = false;
    }

}
