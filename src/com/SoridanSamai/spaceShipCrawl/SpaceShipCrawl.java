package com.SoridanSamai.spaceShipCrawl;

public class SpaceShipCrawl {

    public static void main(String [] args){
    	Start f = new Start();
    	
    	Thread t = new Thread(f);
    	//t.setDaemon(false);
    	t.start();
    }

}
