package com.SoridanSamai.spaceShipCrawl;

import java.applet.*;
import java.awt.*;

import eventsAndExeptions.ImageLoadingExeption;

/**
 * 
 * @author petmeu239
 */
public class Fönster extends Applet implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 5932246779196752754L;

	Controller c;

	int width = 16 * 32, height = 16 * 32;

	private boolean running = true;
	private boolean paused = false;

	@Override
	public void init() {

		c = new Controller();

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
		final int TARGET_FPS = 16;
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
