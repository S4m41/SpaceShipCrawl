package com.SoridanSamai.spaceShipCrawl;

import java.awt.event.*;

public class KeyboardModule implements KeyListener {

	private static boolean[] keys = new boolean[600];

	@Override
	public void keyPressed(KeyEvent e) {
		final int status = e.getID(), key = e.getKeyCode();
		if (status == KeyEvent.KEY_PRESSED) {
			if (!keys[key]) {
				keys[key] = true;
			}
		}
		e.consume();
	}

	@Override
	public void keyReleased(KeyEvent e) {
		final int status = e.getID(), key = e.getKeyCode();
		if (status == KeyEvent.KEY_RELEASED) {
			keys[key] = false;
		}
		e.consume();
	}

	@Override
	public void keyTyped(KeyEvent e) {
		e.consume();
	}

	public boolean isPressed(int keyCode) {
		return keys[keyCode];
	}

	public boolean isPressed(char key) {
		final int keyCode = KeyEvent.getExtendedKeyCodeForChar(key);
		return keys[keyCode];
	}
}


