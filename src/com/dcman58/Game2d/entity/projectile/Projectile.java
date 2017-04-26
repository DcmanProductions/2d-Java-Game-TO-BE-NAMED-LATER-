package com.dcman58.Game2d.entity.projectile;

import java.util.Random;

import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.entity.Entity;

public abstract class Projectile extends Entity {

	protected final double xOrgin, yOrgin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double speed, range, damage;
	protected double x, y;
	protected double distace;
	protected final Random random = new Random();

	public Projectile(double x, double y, double dir) {

		xOrgin = x;
		yOrgin = y;
		angle = dir;
		this.x = x;
		this.y = y;
	}

	public Sprite getSprite() {
		return sprite;

	}

	public int getSpriteSize() {
		return sprite.SIZE;
	}

	protected void move() {

	}

}