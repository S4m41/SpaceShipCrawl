package com.SoridanSamai.spaceShipCrawl.world;

import com.SoridanSamai.spaceShipCrawl.enemies.Entity;
import java.util.ArrayList;

/**
 *
 * @author simlin329
 */
public class Deck {
    Tile[][] schematic;
    ArrayList<Entity> population = new ArrayList<>();

    public Deck(int x,int y) {
        schematic = new Tile[x][y];
    }
    
    
}
