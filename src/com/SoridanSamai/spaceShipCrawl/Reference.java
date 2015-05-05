package com.SoridanSamai.spaceShipCrawl;

import java.io.File;

public class Reference {

    public static final File RECOURCE_PATH = new File("./src/com/SoridanSamai/spaceShipCrawl/img");
    //IMAGEPATHS
    public static final File FLOOR_PICTURE = new File(RECOURCE_PATH, "golv1.png");
    public static final File WALL_PICTURE = new File(RECOURCE_PATH, "vägg1.png");
    public static final File TELEPORTER_PICTURE = new File(RECOURCE_PATH, "teleport1.png");
  public static final File[] TILE_PICTURES = {FLOOR_PICTURE, WALL_PICTURE, TELEPORTER_PICTURE};
    public static final File ENTITY_PICTURE = new File(RECOURCE_PATH, "mech1.png"); 
    public static final File    LEVEL_FILE=new File(RECOURCE_PATH,"level1.txt");
    
    //Values
        // World&tile size
    public static final int TILE_WIDTH = 32;
    public static final int TILE_HEIGHT = 32;
    
    public static final int WORLD_WIDTH = 48;
    public static final int WORLD_HEIGHT = 24;
    
    public static final int WIEWPORT_WIDTH = 48;
    public static final int WIEWPORT_HEIGHT = 24;
    
    
        //runtime prefs
    public static final int TARGET_FPS = 16;
    
}
