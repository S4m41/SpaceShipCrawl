package com.SoridanSamai.spaceShipCrawl;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.SoridanSamai.spaceShipCrawl.world.Deck;
import com.SoridanSamai.spaceShipCrawl.world.Ship;
import com.SoridanSamai.spaceShipCrawl.world.Tile;

import com.SoridanSamai.spaceShipCrawl.eventsAndExeptions.ImageLoadingExeption;

/**
 *
 * @author simlin329
 */
public class Controller {

    private boolean shouldMove = true;
    Ship stage = new Ship();
    UI ui = new UI();

    public Controller() {
        Tile.initImages();
        Deck add = new Deck(Reference.WORLD_WIDTH, Reference.WORLD_HEIGHT);
        add.basicFlooring();
        stage.addDeck(add);
    }

    void paint(Graphics2D g) {
        Deck d = stage.getActive();
        d.paint(g);
        ui.paint(g);
    }

    void update(double delta) {
        ui.update(delta);
        if (shouldMove) {
            updateBoard(delta);
        }
    }

    private void updateBoard(double delta) {

    }

}
