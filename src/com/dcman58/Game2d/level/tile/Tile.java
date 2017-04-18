package com.dcman58.Game2d.level.tile;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;

public class Tile {

	public int x, y;
	public Sprite sprite;

	public static Tile voidTile = new VoidTile(Sprite.voidSprite);

	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile rose = new RoseTile(Sprite.rose);
	public static Tile blue_flower = new Blue_FlowerTile(Sprite.blue_flower);

	public static Tile red_brick = new Red_Brick(Sprite.red_brick);
	public static Tile gray_brick = new Gray_Brick(Sprite.grey_brick);
	public static Tile mossy_red_brick = new Mossy_Red_Brick(Sprite.mossy_red_brick);
	public static Tile mossy_gray_brick = new Mosy_Gray_Brick(Sprite.mossy_gray_brick);
	public static Tile hedge = new Hedge(Sprite.hedge);
	public static Tile water = new Water(Sprite.water);
	public static Tile green_brick = new Green_Brick(Sprite.green_brick);
	
	public static Tile tree = new TreeTile(Sprite.tree);
	
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


	public static final int col_grass = 0xFF00FF00;
	public static final int col_flower = 0xFFF0FF00;
	public static final int col_rock = 0xFF6B6B6B;
	public static final int col_blue_flower = 0xFF0081FF;
	public static final int col_rose = 0xFFFF7800;
	
	public static final int col_red_brick = 0xFFFF0000;
	public static final int col_gray_brick = 0xFF9E9E9E;
	public static final int col_mossy_red_brick = 0xFFBE0000;
	public static final int col_mossy_gray_brick = 0xFF6BA76B;
	public static final int col_water = 0xFF0097FF;
	public static final int col_hedge = 0xFF008000;
	public static final int col_green_brick = 0xFF003A00;

	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}

	public void render(int x, int y, Screen screen) {

	}

	public boolean solid() {
		return false;
	}

}
