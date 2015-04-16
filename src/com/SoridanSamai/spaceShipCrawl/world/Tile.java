package com.SoridanSamai.spaceShipCrawl.world;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

/**
 *
 * @author simlin329
 */
public class Tile {

    private static ArrayList<BufferedImage> depiction = new ArrayList<BufferedImage>();
    public static final int FLOOR = 0;
    public static final int WALL = 1;
    public static final int TELEPORT = 2;
    private static final int[] ASSIGNED_VALUES = {0, 1, 2};
    private final int type;

    public Tile(int type) throws Exception {
        boolean isPossible = false;
        for (int i : ASSIGNED_VALUES) {
            if (i == type) {
                isPossible = true;
                break;
            }
        }
        if (isPossible) {
            this.type = type;
        } else {
            throw new Exception("ILLEGAL TYPE");
        }

    }

    public int getType() {
        return type;
    }

    public boolean isPassable() {
        return getType() == FLOOR || getType() == TELEPORT;
    }

}
