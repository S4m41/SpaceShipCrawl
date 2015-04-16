package spaceshipcrawl;

import java.applet.*;
import java.awt.*;

/**
 *
 * @author petmeu239
 */
public class Fönster extends Applet implements Runnable {
    Controller c = new Controller();

    int width = 16 * 32, height = 16 * 32;

    private boolean running = true;
    private boolean paused = false;

    @Override
    public void init() {
        this.setSize(width, height);
    }

    @Override
    public void paint(Graphics g) {
        c.paint(g);
    }

    public void update(double delta) {
        c.update(delta);
    }

    @Override
    public void run() {
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;
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
                //System.out.println("(FPS: " + fps + ")");
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
