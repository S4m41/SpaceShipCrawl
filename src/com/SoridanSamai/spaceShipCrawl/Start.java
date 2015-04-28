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
    public static MouseModule mm = new MouseModule();
    public static KeyboardModule km = new KeyboardModule();

    int width = Reference.WIEWPORT_WIDTH * Reference.TILE_WIDTH;
    int height = Reference.WIEWPORT_HEIGHT * Reference.TILE_HEIGHT;

    private boolean running = true;
    private boolean paused = false;
    private Doublebuffer db;

    @Override
    public void init() {

        c = new Controller();

        //doublebuffering
        JPanel jp = new JPanel();
        jp.setDoubleBuffered(true);
        this.setContentPane(jp);

        this.addKeyListener(km);
        this.addMouseListener(mm);
        this.addMouseMotionListener(mm);
        this.addMouseWheelListener(mm);

        this.setSize(width, height);
        this.setVisible(true);
        db = new Doublebuffer() {

            @Override
            void paintstuff(Graphics buffergraphics) {
                c.paint((Graphics2D) buffergraphics);
            }

        };
        db.init(this);
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void paint(Graphics g) {
        try {
            db.paint(g);
            db.show(g);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());
        }

    }

    public void update(double delta) {
        c.update(delta);
    }

    @Override
    public void run() {
        long lastLoopTime = System.nanoTime();

        final long OPTIMAL_TIME = (long) (1e9 / Reference.TARGET_FPS);
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
                System.out.println("(FPS: " + fps + ")");
                lastFpsTime = 0;
                fps = 0;
            }
            if (!paused) {
                update(delta);
            }
            repaint();

            mm.cleanUp();

            long l = (lastLoopTime + OPTIMAL_TIME);
            if (l < 0) {

            } else {
                while (System.nanoTime() - l < 0) {
                    Thread.yield();
                }

            }
        }
    }

    private class Doublebuffer {

        Graphics buffergraphics;
        Image osi;
        Dimension dim;

        public void init(JApplet a) {
            dim = a.getSize();
            osi = createImage(dim.width, dim.height);
            buffergraphics = osi.getGraphics();
        }

        public void paint(Graphics g) {
            buffergraphics.clearRect(0, 0, dim.width, dim.width);
            buffergraphics.setColor(Color.red);
            buffergraphics.drawString("Bad Double-buffered", 10, 10);
            paintstuff(buffergraphics);
        }

        public void show(Graphics g) {
            g.drawImage(osi, 0, 0, null);
        }

        void paintstuff(Graphics buffergraphics) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    }
}
