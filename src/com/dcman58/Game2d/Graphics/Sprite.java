package com.dcman58.Game2d.Graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;

	private int width, height;

	private SpriteSheet sheet;

	// Particles
	public static Sprite particles_normal = new Sprite(3, 0xAAAAAA);

	
	//Game Tiles
	public static Sprite grass = new Sprite(16, 0, 0, SpriteSheet.tiles);
	public static Sprite flower = new Sprite(16, 2, 0, SpriteSheet.tiles);
	public static Sprite rock = new Sprite(16, 3, 0, SpriteSheet.tiles);
	public static Sprite rose = new Sprite(16, 4, 0, SpriteSheet.tiles);
	public static Sprite blue_flower = new Sprite(16, 5, 0, SpriteSheet.tiles);
	public static Sprite tree = new Sprite(32, 3, 0, SpriteSheet.tiles);
	public static Sprite red_brick = new Sprite(16, 8, 0, SpriteSheet.tiles);
	public static Sprite grey_brick = new Sprite(16, 9, 0, SpriteSheet.tiles);
	public static Sprite mossy_gray_brick = new Sprite(16, 10, 0, SpriteSheet.tiles);
	public static Sprite mossy_red_brick = new Sprite(16, 11, 0, SpriteSheet.tiles);
	public static Sprite water = new Sprite(16, 12, 0, SpriteSheet.tiles);
	public static Sprite hedge = new Sprite(16, 13, 0, SpriteSheet.tiles);
	public static Sprite blue_brick = new Sprite(16, 14, 0, SpriteSheet.tiles);

	public static Sprite voidSprite = new Sprite(16, 0x52D4FF);
	// Player Sprites
	public static Sprite player_front = new Sprite(32, 1, 1, SpriteSheet.player);
	public static Sprite player_back = new Sprite(32, 5, 1, SpriteSheet.player);
	public static Sprite player_side = new Sprite(32, 9, 1, SpriteSheet.player);

	public static Sprite player_forward_1 = new Sprite(32, 0, 1, SpriteSheet.player);
	public static Sprite player_forward_2 = new Sprite(32, 2, 1, SpriteSheet.player);

	public static Sprite player_side_1 = new Sprite(32, 8, 1, SpriteSheet.player);
	public static Sprite player_side_2 = new Sprite(32, 10, 1, SpriteSheet.player);

	public static Sprite player_back_1 = new Sprite(32, 4, 1, SpriteSheet.player);
	public static Sprite player_back_2 = new Sprite(32, 6, 1, SpriteSheet.player);

	// Projectile Sprites

	public static Sprite projetile_wizard = new Sprite(16, 0, 0, SpriteSheet.projectile_wizard);

	public Sprite(int size, int x, int y, SpriteSheet sheet) {
		SIZE = size;
		this.width = size;
		this.height = size;

		pixels = new int[size * size];
		this.x = x * size;
		this.y = y * size;
		this.sheet = sheet;
		load();
	}

	public Sprite(int width, int height, int color) {
		this.width = width;
		this.height = height;
		SIZE = -1;
		pixels = new int[width * height];
		setColor(color);
	}

	public Sprite(int size, int color) {
		SIZE = size;
		this.width = size;
		this.height = size;
		pixels = new int[SIZE * SIZE];
		setColor(color);
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	private void setColor(int color) {
		for (int i = 0; i < width * height; i++) {
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
