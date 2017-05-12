package com.dcman58.Game2d.util;

import com.dcman58.Game2d.Graphics.Screen;

public class Debug {

	private Debug() {
	}

	public static void drawRect(Screen screen, int x, int y, int width, int height, boolean fixed) {
		screen.drawRect(x, y, width, height, 0xff0011, fixed);
	}

	public static void drawRect(Screen screen, int x, int y, int width, int height, int col, boolean fixed) {
		screen.drawRect(x, y, width, height, col, fixed);
	}

}
