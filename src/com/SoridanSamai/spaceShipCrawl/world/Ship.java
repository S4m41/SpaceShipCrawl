package com.SoridanSamai.spaceShipCrawl.world;

import java.util.ArrayList;


public class Ship {
    ArrayList<Deck> ship = new ArrayList<>();
    Deck active;
    
    public void addDeck(Deck d){
    	ship.add(d);
    	if(active.equals(null)){
    		active = d;
    	}
    }

	public Deck getActive() {
		return active;
	}
}
