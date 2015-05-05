package com.SoridanSamai.spaceShipCrawl;

import javax.swing.*;

public class SpaceShipCrawl extends JFrame {
    public static KeyboardModule km = new KeyboardModule();
    public static MouseModule mm = new MouseModule();

    public SpaceShipCrawl(){
        super("Space ship crawler, alfa 00.1");
        
        this.addKeyListener(km);
        this.addMouseListener(mm);
        this.addMouseMotionListener(mm);
        this.addMouseWheelListener(mm);
        
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
