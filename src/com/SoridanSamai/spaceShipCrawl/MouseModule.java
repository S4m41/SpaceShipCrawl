package com.SoridanSamai.spaceShipCrawl;

import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class MouseModule implements MouseListener, MouseWheelListener,
		MouseMotionListener {
	private static boolean[] buttonsHeld = new boolean[4],
			buttonsPressed = new boolean[4], buttonsReleased = new boolean[4],
			wheel = new boolean[2];
	private int mouseX, mouseY;

	public MouseModule() {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) {
		final int status = e.getID(), key = e.getButton();
		if (status == MouseEvent.MOUSE_PRESSED) {
			buttonsHeld[key] = true;
			buttonsPressed[key] = true;
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		final int status = e.getID(), key = e.getButton();
		if (status == MouseEvent.MOUSE_RELEASED) {
			buttonsHeld[key] = false;
			buttonsReleased[key] = true;
		}
	}

	public void clearPressedButtons() {
		for (int i = 0; i < buttonsPressed.length; i++) {
			buttonsPressed[i] = false;
		}
	}

	public void clearReleasedButtons() {
		for (int i = 0; i < buttonsReleased.length; i++) {
			buttonsReleased[i] = false;
		}
	}

	public void cleanUp() {
		this.clearPressedButtons();
		this.clearReleasedButtons();

		// Reset mouse-wheel activations
		wheel[0] = false;
		wheel[1] = false;
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		this.mouseX = e.getX();
		this.mouseY = e.getY();
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		this.mouseX = e.getX();
		this.mouseY = e.getY();
	}

	// must remember to set both spaces of wheel[] to false in
	// implementor-class,
	// when action has been taken.
	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		if (e.getWheelRotation() < 0) {
			wheel[0] = true;
		} else {
			wheel[1] = true;
		}
	}

	public int getMouseX() {
		return this.mouseX;
	}

	public int getMouseY() {
		return this.mouseY;
	}

	public Point getMousePos() {
		return new Point(this.mouseX, this.mouseY);
	}

	public boolean[] getWheel() {
		return wheel;
	}

	public void setWheel(boolean[] wheel) {
		MouseModule.wheel = wheel;
	}

	public boolean[] getButtons() {
		return buttonsHeld;
	}

	public void setButtons(boolean[] buttons) {
		MouseModule.buttonsHeld = buttons;
	}
}


