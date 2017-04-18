package com.dcman58.Game2d.level;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;
	
	protected int[] tiles;
	public static Level spawn = new SpawnLevel("/textures/Levels/SpawnLevel.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();
	}

	protected void loadLevel(String path) {

	}

	protected void generateLevel() {

	}

	public void update() {

	}

	private void time() {

	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int y0 = yScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);
/*
				if (x + y * 16 < 0 || x + y * 16 >= 256) {
					Tile.voidTile.render(x, y, screen);
					continue;
				}
				tiles[x + y * 16].render(x, y, screen);*/
			}
		}

	}
	
	/*
	 * Grass  0xFF00FF00
	 * Flower  0xFFF0FF00
	 * Rock   0xFF6B6B6B
	 * Blue Flower  0xFF0081FF
	 * Rose   0xFFFF7800
	 * Tree   0xFF006B00
	 * 
	 * Hedge  0xFF008000
	 * RedBrick  0xFFFF0000
	 * Mossy_Gray_Brick 0xFF6BA76B
	 * Mossy_Red_Brick  0xFFBE0000
	 * GrayBrick  0xFF9E9E9E
	 * Water   0xFF0097FF
	 * */

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grass;
		
		if (tiles[x + y * width] == Tile.col_grass)
			return Tile.grass;
		
		if (tiles[x + y * width] == Tile.col_flower)
			return Tile.flower;
		
		if (tiles[x + y * width] == Tile.col_rock)
			return Tile.rock;
		
		if (tiles[x + y * width] == Tile.col_rose)
			return Tile.rose;
		
		if (tiles[x + y * width] == Tile.col_blue_flower)
			return Tile.blue_flower;
		
		if (tiles[x + y * width] == Tile.col_red_brick)
			return Tile.red_brick;
		
		if (tiles[x + y * width] == Tile.col_gray_brick)
			return Tile.gray_brick;
		
		if (tiles[x + y * width] == Tile.col_mossy_gray_brick)
			return Tile.mossy_gray_brick;
		
		if (tiles[x + y * width] == Tile.col_mossy_red_brick)
			return Tile.mossy_red_brick;

		if (tiles[x + y * width] == 0xFF008000)
			return Tile.hedge;

		if (tiles[x + y * width] == 0xFF0097FF)
			return Tile.water;
		
		if (tiles[x + y * width] == 0xFF003A00)
			return Tile.green_brick;
		
		return Tile.grass;

	}

}
