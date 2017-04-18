package com.dcman58.Game2d.entity.projectile;

import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.entity.Entity;

public abstract class Projectile extends Entity {

	protected final int xOrgin, yOrgin;
	protected double angle;
	protected Sprite sprite;
	protected double nx, ny;
	protected double speed, rateOfFire, range, damage;

	public Projectile(int x, int y, double dir) {

		xOrgin = x;
		yOrgin = y;
		angle = dir;
		this.x = x;
		this.y = y;

	}

	protected void move() {

	}

}