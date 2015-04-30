package com.SoridanSamai.spaceShipCrawl;

import javax.swing.*;

public class SpaceShipCrawl extends JFrame {

    public SpaceShipCrawl(){
        super("Space ship crawler, alfa 00.1");
        Start f = new Start();
        f.init();
        add("Center",f);
        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

        Thread t = new Thread(f);
    	//t.setDaemon(false);
    	t.start();
    }
    
    public static void main(String [] args){
        new SpaceShipCrawl();
    }

}
