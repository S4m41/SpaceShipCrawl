package com.SoridanSamai.spaceShipCrawl;

import java.io.File;

public class Reference {
	public static final File RECOURCE_PATH = new File("./src/com/SoridanSamai/spaceShipCrawl/img"); 
	//IMAGEPATHS
	public static final File FLOOR_PICTURE = new File(RECOURCE_PATH, "golv1.png");
	public static final File WALL_PICTURE = new File(RECOURCE_PATH, "vägg1.png");
	public static final File TELEPORTER_PICTURE = new File(RECOURCE_PATH, "teleport1.png");
	public static final File[] TILE_PICTURES = {FLOOR_PICTURE,WALL_PICTURE,TELEPORTER_PICTURE};

}
