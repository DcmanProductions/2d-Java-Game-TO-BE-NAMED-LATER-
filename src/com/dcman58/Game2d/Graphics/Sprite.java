package com.dcman58.Game2d.Graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;
	private SpriteSheet sheet;
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite voidSprite = new Sprite(16, 0x52D4FF);
	
	public static Sprite player_front = new Sprite(32, 1,1, SpriteSheet.player);
	public static Sprite player_back = new Sprite(32, 5,1, SpriteSheet.player);
	public static Sprite player_side = new Sprite(32, 9,1, SpriteSheet.player);
	
	//public static Sprite

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		pixels = new int[size * size];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}
	
	public Sprite(int size, int color){
		SIZE = size;
		pixels = new int[SIZE*SIZE];
		setColor(color);
	}
	
	private void setColor(int color){
		for(int i=0;i<SIZE*SIZE;i++){
			pixels[i] = color;
		}
	}

	private void load() {
		for (int y = 0; y < SIZE; y++) {
			for (int x = 0; x < SIZE; x++) {
				pixels[x + y * SIZE] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.SIZE];

			}
		}
	}
}
