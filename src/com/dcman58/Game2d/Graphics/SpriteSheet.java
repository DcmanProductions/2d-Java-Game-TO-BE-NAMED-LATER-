package com.dcman58.Game2d.Graphics;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SpriteSheet {

	private String path;
	public final int SIZE;
	public int[] pixels;
	public final int WIDTH, HEIGHT;

	public static SpriteSheet tiles = new SpriteSheet("/textures/spritesheet.png", 256);
	public static SpriteSheet player = new SpriteSheet("/textures/entities/alchimist.png", 129);
	public static SpriteSheet projectile_wizard = new SpriteSheet("/textures/projectiles/wizardProjectile.png", 48);
	public static SpriteSheet guard = new SpriteSheet("/textures/entities/practice_guard.png", 128);
	public static SpriteSheet dummy = new SpriteSheet("/textures/entities/Dummy.png", 128);
	public static SpriteSheet bandit = new SpriteSheet("/textures/entities/bandit.png", 128);

	public static SpriteSheet player_down = new SpriteSheet(player, 0, 0, 1, 3, 32);
	public static SpriteSheet player_up = new SpriteSheet(player, 2, 0, 1, 3, 32);
	public static SpriteSheet player_left = new SpriteSheet(player, 3, 0, 1, 3, 32);
	public static SpriteSheet player_right = new SpriteSheet(player, 1, 0, 1, 3, 32);

	public static SpriteSheet dummy_down = new SpriteSheet(dummy, 0, 0, 1, 3, 32);
	public static SpriteSheet dummy_up = new SpriteSheet(dummy, 1, 0, 1, 3, 32);
	public static SpriteSheet dummy_left = new SpriteSheet(dummy, 3, 0, 1, 3, 32);
	public static SpriteSheet dummy_right = new SpriteSheet(dummy, 2, 0, 1, 3, 32);

	public static SpriteSheet bandit_down = new SpriteSheet(bandit, 0, 0, 1, 3, 32);
	public static SpriteSheet bandit_up = new SpriteSheet(bandit, 1, 0, 1, 3, 32);
	public static SpriteSheet bandit_left = new SpriteSheet(bandit, 3, 0, 1, 3, 32);
	public static SpriteSheet bandit_right = new SpriteSheet(bandit, 2, 0, 1, 3, 32);

	public static SpriteSheet guard_down = new SpriteSheet(guard, 0, 0, 1, 3, 32);
	public static SpriteSheet guard_up = new SpriteSheet(guard, 1, 0, 1, 3, 32);
	public static SpriteSheet guard_left = new SpriteSheet(guard, 3, 0, 1, 3, 32);
	public static SpriteSheet guard_right = new SpriteSheet(guard, 2, 0, 1, 3, 32);

	private Sprite[] sprites;

	public SpriteSheet(SpriteSheet sheet, int x, int y, int width, int height, int spriteSize) {
		int xx = x * spriteSize;
		int yy = y * spriteSize;
		int w = width * spriteSize;
		int h = height * spriteSize;
		if (width == height)
			SIZE = width;
		else
			SIZE = -1;
		WIDTH = w;
		HEIGHT = h;
		pixels = new int[w * h];

		for (int y0 = 0; y0 < h; y0++) {
			int yp = yy + y0;
			for (int x0 = 0; x0 < w; x0++) {
				int xp = xx + x0;
				pixels[x0 + y0 * w] = sheet.pixels[xp + yp * sheet.WIDTH];
			}
		}

		sprites = new Sprite[width * height];
		int frame = 0;

		for (int ya = 0; ya < height; ya++) {
			for (int xa = 0; xa < width; xa++) {
				int[] spritePixels = new int[spriteSize * spriteSize];
				for (int y0 = 0; y0 < spriteSize; y0++) {
					for (int x0 = 0; x0 < spriteSize; x0++) {
						spritePixels[x0 + y0 * spriteSize] = pixels[(x0 + xa * spriteSize)
								+ (y0 + ya * spriteSize) * WIDTH];
					}
				}
				Sprite sprite = new Sprite(spritePixels, spriteSize, spriteSize);
				sprites[frame++] = sprite;
			}
		}
	}

	public SpriteSheet(String path, int size) {
		this.path = path;
		this.SIZE = size;
		WIDTH = size;
		HEIGHT = size;
		pixels = new int[SIZE * SIZE];
		load();
	}

	public SpriteSheet(String path, int width, int height) {
		this.path = path;
		this.SIZE = -1;
		WIDTH = width;
		HEIGHT = height;
		pixels = new int[WIDTH * HEIGHT];
		load();
	}

	public Sprite[] getSprites() {
		return sprites;
	}

	private void load() {
		try {
			BufferedImage image = ImageIO.read(SpriteSheet.class.getResource(path));
			int w = image.getWidth();
			int h = image.getHeight();
			image.getRGB(0, 0, w, h, pixels, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
