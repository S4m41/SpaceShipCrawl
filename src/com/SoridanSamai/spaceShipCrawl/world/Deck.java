package com.SoridanSamai.spaceShipCrawl.world;

import com.SoridanSamai.spaceShipCrawl.enemies.Entity;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.util.ArrayList;

/**
 * 
 * @author simlin329
 */
public class Deck {
	Tile[][] schematic;
	ArrayList<Entity> population = new ArrayList<>();

	public Deck(int x, int y) {
		schematic = new Tile[x][y];
	}

	public void basicFlooring() {
		for (Tile[] tx : schematic) {
			for (Tile ty : tx) {
				ty = new Tile();
			}
		}
	}

	public void paint(Graphics2D g) {
		for (int x = 0; x < schematic.length; x++) {
			for (int y = 0; y < schematic[x].length; y++) {
				Tile t = schematic[x][y];
				AffineTransform xform = new AffineTransform();
				
				g.drawImage(t.getImage(), xform, null);
			}
		}
	}

}
