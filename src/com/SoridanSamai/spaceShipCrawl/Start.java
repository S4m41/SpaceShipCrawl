package com.SoridanSamai.spaceShipCrawl;

import java.awt.*;

import javax.swing.JApplet;
import javax.swing.JPanel;

/**
 *
 * @author petmeu239
 */
public class Start extends JApplet implements Runnable {

    /**
     *
     */
    private static final long serialVersionUID = 5932246779196752754L;

    Controller c;

    int width = Reference.WIEWPORT_WIDTH * Reference.TILE_WIDTH;
    int height = Reference.WIEWPORT_HEIGHT * Reference.TILE_HEIGHT;

    private boolean running = true;
    private boolean paused = false;

    @Override
    public void init() {

        c = new Controller();
        
        //doublebuffering
        JPanel jp= new JPanel();
        jp.setDoubleBuffered(true);
        this.setContentPane(jp);
        
        this.setSize(width, height);
        this.setVisible(true);
        
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void paint(Graphics g) {

        c.paint((Graphics2D) g);
    }

    public void update(double delta) {
        c.update(delta);
    }

    @Override
    public void run() {
        long lastLoopTime = System.nanoTime();

        final long OPTIMAL_TIME = 1000000000 / Reference.TARGET_FPS;
        int fps = 0;
        int lastFpsTime = 0;

        while (running) {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double) OPTIMAL_TIME);
            lastFpsTime += updateLength;
            fps++;
            if (lastFpsTime >= 1000000000) {
                // System.out.println("(FPS: " + fps + ")");
                System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }
            if (!paused) {
                update(delta);
            }

            repaint();

            long l = (lastLoopTime + OPTIMAL_TIME);
            if (l < 0) {

            } else {
                while (System.nanoTime() - l < 0) {
                    Thread.yield();
                }

            }
        }
    }

}
