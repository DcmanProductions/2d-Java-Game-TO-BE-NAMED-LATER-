package com.dcman58.Game2d.Graphics;

import com.dcman58.Game2d.util.Debug;

public class Font {

	public static SpriteSheet font = new SpriteSheet("/fonts/arial.png", 16);
	 private static Sprite[] characters = Sprite.split(font);

	private static String charIndex = "ABCDEFGHIJKLM" + //
			"NOPQRSTUVWXYZ" + //
			"abcdefghijklm" + //
			"nopqrstuvwxyz" + //
			"0123456789";

//	private Sprite A = new Sprite(16, 0, 0, font);
//	private Sprite B = new Sprite(16, 1, 0, font);
//	private Sprite C = new Sprite(16, 2, 0, font);
//	private Sprite D = new Sprite(16, 3, 0, font);
//	private Sprite E = new Sprite(16, 4, 0, font);
//	private Sprite F = new Sprite(16, 5, 0, font);
//	private Sprite G = new Sprite(16, 6, 0, font);
//	private Sprite H = new Sprite(16, 7, 0, font);
//	private Sprite I = new Sprite(16, 8, 0, font);
//	private Sprite J = new Sprite(16, 9, 0, font);
//	private Sprite K = new Sprite(16, 10, 0, font);
//	private Sprite L = new Sprite(16, 11, 0, font);
//	private Sprite M = new Sprite(16, 0, 0, font);
//	private Sprite N = new Sprite(16, 0, 0, font);
//	private Sprite O = new Sprite(16, 0, 0, font);
//	private Sprite P = new Sprite(16, 0, 0, font);
//	private Sprite Q = new Sprite(16, 0, 0, font);
//	private Sprite R = new Sprite(16, 0, 0, font);
//	private Sprite S = new Sprite(16, 0, 0, font);
//	private Sprite T = new Sprite(16, 0, 0, font);
//	private Sprite U = new Sprite(16, 0, 0, font);
//	private Sprite V = new Sprite(16, 0, 0, font);
//	private Sprite W = new Sprite(16, 0, 0, font);
//	private Sprite X = new Sprite(16, 0, 0, font);
//	private Sprite Y = new Sprite(16, 0, 0, font);
//	private Sprite Z = new Sprite(16, 0, 0, font);

	public Font() {
	}

	public void render(String text, Screen screen) {
		System.out.println(characters[0]);
		for (int i = 0; i < text.length(); i++) {
			char currentChar = text.charAt(i);
			int index = charIndex.indexOf(currentChar);
		}

		screen.renderSprite(50, 50, characters[0], false);
		Debug.drawRect(screen, 50, 50, 16, 16, 0xFFAA00, false);
	}

}
