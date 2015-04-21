package com.SoridanSamai.spaceShipCrawl.world;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;

//import com.SoridanSamai.spaceShipCrawl.Reference;

import eventsAndExeptions.ImageLoadingExeption;

/**
 * 
 * @author simlin329
 */
public class Tile {

	private static ArrayList<BufferedImage> depiction = new ArrayList<BufferedImage>();
	public static final int FLOOR = 0;
	public static final int WALL = 1;
	public static final int TELEPORT = 2;
	private static final int[] ASSIGNED_VALUES = { 0, 1, 2 };//must be y=x
	private final int type;

	public Tile() {
		this.type = FLOOR;
	}

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
	public BufferedImage getImage(){
		return Tile.depiction.get(type);
		
	}
	public static void initImages() {
		/*
		 * for (int i = 0 ;
		 * i<ASSIGNED_VALUES.length||i<Reference.TILE_PICTURES.length ;i++) {
		 * int typeq = ASSIGNED_VALUES[i]; File picture =
		 * Reference.TILE_PICTURES[i]; try { depiction.add(typeq,
		 * ImageIO.read(picture)); } catch (Exception e) {
		 * System.err.append("ERROR LOADING IMAGES"); } }
		 */
		for (int i = 0 ; i<ASSIGNED_VALUES.length;i++) {
			BufferedImage im = new BufferedImage(32, 32, BufferedImage.TYPE_INT_RGB);
			Graphics g = im.getGraphics();
			g.setColor(new Color(25*i,10*i,0));
			g.fillRect(0, 0, 32, 32);
		}
	}
}
