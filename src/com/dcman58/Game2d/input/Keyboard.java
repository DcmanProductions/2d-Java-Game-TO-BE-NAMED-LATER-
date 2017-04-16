package com.dcman58.Game2d.input;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Keyboard implements KeyListener {

	private boolean[] keys = new boolean[300];

	public boolean up, down, left, right, escape, fullscreen;

	public void update() {
		up = keys[KeyEvent.VK_W];
		left = keys[KeyEvent.VK_A];
		down = keys[KeyEvent.VK_S];
		right = keys[KeyEvent.VK_D];
		escape = keys[KeyEvent.VK_ESCAPE];
		fullscreen = keys[KeyEvent.VK_F11];

		for (int i = 0; i < keys.length; i++) {
			if (keys[i]) {
				// System.out.println("Key: "+i);
			}
		}
	}

	public void keyPressed(KeyEvent e) {
		keys[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		keys[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent e) {
	}

}
