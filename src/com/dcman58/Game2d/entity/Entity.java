package com.dcman58.Game2d.entity;

import java.util.Random;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.level.Level;

public abstract class Entity {
	protected int x, y;
	private boolean removed = false;
	protected Level level;
	protected Random random = new Random();
	protected Sprite sprite;
	protected Screen screen;

	public void update() {

	}

	public void render(Screen screen) {
//		if (sprite != null)
//			screen.renderSprite((int) x, (int) y, sprite, true);
	}

	public void remove() {
		// Remove from level
		removed = true;

//		System.out.println("Removed = " + isRemoved());
	}

	public boolean isRemoved() {
		return removed;
	}

	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public Sprite getSprite() {
		return sprite;
	}

	public void init(Level level) {
		this.level = level;
	}
}
