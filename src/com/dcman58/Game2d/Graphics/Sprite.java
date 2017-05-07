package com.dcman58.Game2d.Graphics;

public class Sprite {

	public final int SIZE;
	private int x, y;
	public int[] pixels;

	private int width, height;

	protected SpriteSheet sheet;

	// Particles
	public static Sprite particles_normal = new Sprite(3, 0xAAAAAA);
	public static Sprite particles_nourish = new Sprite(16, 0, 1, SpriteSheet.projectiles);
	public static Sprite particles_harm = new Sprite(16, 1, 1, SpriteSheet.projectiles);
	public static Sprite particles_essence = new Sprite(16, 2, 1, SpriteSheet.projectiles);
	public static Sprite particles_unstable = new Sprite(16, 3, 1, SpriteSheet.projectiles);

	// Game Tiles
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

	public static Sprite player_front = new Sprite(32, 0, 0, SpriteSheet.player);
	public static Sprite player_front_1 = new Sprite(32, 0, 1, SpriteSheet.player);
	public static Sprite player_front_2 = new Sprite(32, 0, 2, SpriteSheet.player);

	public static Sprite player_left = new Sprite(32, 3, 0, SpriteSheet.player);
	public static Sprite player_left_1 = new Sprite(32, 3, 1, SpriteSheet.player);
	public static Sprite player_left_2 = new Sprite(32, 3, 2, SpriteSheet.player);
	
	public static Sprite player_right = new Sprite(32, 1, 0, SpriteSheet.player);
	public static Sprite player_right_1 = new Sprite(32, 1, 1, SpriteSheet.player);
	public static Sprite player_right_2 = new Sprite(32, 1, 2, SpriteSheet.player);

	public static Sprite player_back = new Sprite(32, 2, 1, SpriteSheet.player);
	public static Sprite player_back_1 = new Sprite(32, 2, 0, SpriteSheet.player);
	public static Sprite player_back_2 = new Sprite(32, 2, 2, SpriteSheet.player);

	// Projectile Sprites

	public static Sprite projectile_wizard = new Sprite(16, 0, 0, SpriteSheet.projectiles);
	public static Sprite projectile_arrow = new Sprite(16, 1, 0, SpriteSheet.projectiles);
	//Potions
	public static Sprite potion_nourish = new Sprite(16, 2, 0, SpriteSheet.projectiles);
	public static Sprite potion_harm = new Sprite(16, 3, 0, SpriteSheet.projectiles);
	public static Sprite potion_essence = new Sprite(16, 4, 0, SpriteSheet.projectiles);
	public static Sprite potion_unstable = new Sprite(16, 5, 0, SpriteSheet.projectiles);

	
	//Mob Sprites
	public static Sprite dummy = new Sprite(32, 0, 0, SpriteSheet.dummy);

	public static Sprite dummy_down = new Sprite(32, 0, 0, SpriteSheet.dummy);
	public static Sprite dummy_up = new Sprite(32, 1, 0, SpriteSheet.dummy);
	public static Sprite dummy_right = new Sprite(32, 2, 0, SpriteSheet.dummy);
	public static Sprite dummy_left = new Sprite(32, 3, 0, SpriteSheet.dummy);

	public static Sprite dummy_forward_1 = new Sprite(32, 0, 1, SpriteSheet.dummy);
	public static Sprite dummy_forward_2 = new Sprite(32, 0, 2, SpriteSheet.dummy);
	
	public static Sprite dummy_right_1 = new Sprite(32, 1, 1, SpriteSheet.dummy);
	public static Sprite dummy_right_2 = new Sprite(32, 1, 2, SpriteSheet.dummy);
	
	public static Sprite dummy_left_1 = new Sprite(32, 3, 1, SpriteSheet.dummy);
	public static Sprite dummy_left_2 = new Sprite(32, 3, 2, SpriteSheet.dummy);
	
	public static Sprite dummy_back_1 = new Sprite(32, 2, 1, SpriteSheet.dummy);
	public static Sprite dummy_back_2 = new Sprite(32, 2, 2, SpriteSheet.dummy);
	
	
	

	public static Sprite bandit = new Sprite(32, 0, 0, SpriteSheet.bandit);

	public static Sprite bandit_down = new Sprite(32, 0, 0, SpriteSheet.bandit);
	public static Sprite bandit_up = new Sprite(32, 1, 0, SpriteSheet.bandit);
	public static Sprite bandit_right = new Sprite(32, 2, 0, SpriteSheet.bandit);
	public static Sprite bandit_left = new Sprite(32, 3, 0, SpriteSheet.bandit);

	public static Sprite bandit_forward_1 = new Sprite(32, 0, 1, SpriteSheet.bandit);
	public static Sprite bandit_forward_2 = new Sprite(32, 0, 2, SpriteSheet.bandit);
	
	public static Sprite bandit_right_1 = new Sprite(32, 1, 1, SpriteSheet.bandit);
	public static Sprite bandit_right_2 = new Sprite(32, 1, 2, SpriteSheet.bandit);
	
	public static Sprite bandit_left_1 = new Sprite(32, 3, 1, SpriteSheet.bandit);
	public static Sprite bandit_left_2 = new Sprite(32, 3, 2, SpriteSheet.bandit);
	
	public static Sprite bandit_back_1 = new Sprite(32, 2, 1, SpriteSheet.bandit);
	public static Sprite bandit_back_2 = new Sprite(32, 2, 2, SpriteSheet.bandit);
	

	public static Sprite guard = new Sprite(32, 0, 0, SpriteSheet.bandit);

	public static Sprite guard_down = new Sprite(32, 0, 0, SpriteSheet.guard);
	public static Sprite guard_up = new Sprite(32, 1, 0, SpriteSheet.guard);
	public static Sprite guard_right = new Sprite(32, 2, 0, SpriteSheet.guard);
	public static Sprite guard_left = new Sprite(32, 3, 0, SpriteSheet.guard);

	public static Sprite guard_forward_1 = new Sprite(32, 0, 1, SpriteSheet.guard);
	public static Sprite guard_forward_2 = new Sprite(32, 0, 2, SpriteSheet.guard);
	
	public static Sprite guard_right_1 = new Sprite(32, 1, 1, SpriteSheet.guard);
	public static Sprite guard_right_2 = new Sprite(32, 1, 2, SpriteSheet.guard);
	
	public static Sprite guard_left_1 = new Sprite(32, 3, 1, SpriteSheet.guard);
	public static Sprite guard_left_2 = new Sprite(32, 3, 2, SpriteSheet.guard);
	
	public static Sprite guard_back_1 = new Sprite(32, 2, 1, SpriteSheet.guard);
	public static Sprite guard_back_2 = new Sprite(32, 2, 2, SpriteSheet.guard);
	
	
	

	protected Sprite(SpriteSheet sheet, int width, int height) {
		if (width == height)
			SIZE = width;
		else
			SIZE = -1;
		this.sheet = sheet;
		this.width = width;
		this.height = height;

	}

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

	public Sprite(int[] pixels, int width, int height) {
		if (width == height)
			SIZE = width;
		else
			SIZE = -1;
		this.width = width;
		this.height = height;
		this.pixels = pixels;
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
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				pixels[x + y * width] = sheet.pixels[(x + this.x) + (y + this.y) * sheet.WIDTH];

			}
		}
	}
}
