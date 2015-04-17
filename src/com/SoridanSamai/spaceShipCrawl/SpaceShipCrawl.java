package com.SoridanSamai.spaceShipCrawl;

public class SpaceShipCrawl {

    public static void main(String [] args){
    	Fönster f = new Fönster();
    	
    	Thread t = new Thread(f);
    	//t.setDaemon(false);
    	t.start();
    }

}
