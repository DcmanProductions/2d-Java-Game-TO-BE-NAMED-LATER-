package com.dcman58.Game2d.entity.mob;

import java.util.ArrayList;
import java.util.List;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.entity.Entity;
import com.dcman58.Game2d.entity.projectile.Projectile;
import com.dcman58.Game2d.entity.projectile.WizardProjectile;

public abstract class Mob extends Entity {

	protected boolean moving = false;
	protected List<Projectile> projectiles = new ArrayList<Projectile>();
	protected List<Entity> entities = new ArrayList<Entity>();
	protected boolean walking = false;

	public enum Direction {
		UP, DOWN, RIGHT, LEFT
	}

	protected Direction dir;

	public void move(double xa, double ya) {
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}
		if (xa > 0) dir = Direction.RIGHT;
		if (xa < 0) dir = Direction.LEFT;
		if (ya > 0) dir = Direction.DOWN;
		if (ya < 0) dir = Direction.UP;
		
		while (xa != 0) {
			if(Math.abs(xa) > 1) {
				if (!collision(abs(xa), ya)) {
					this.x += abs(xa);
				}
				xa -= abs(xa);
			} else {
				if (!collision(abs(xa), ya)) {
					this.x += xa;
				}	
				xa = 0;
			}
		}
		
		while (ya != 0) {
			if(Math.abs(ya) > 1) {
				if (!collision(xa, abs(ya))) {
					this.y += abs(ya);
				}
				ya -= abs(ya);
			} else {
				if (!collision(xa, abs(ya))) {
					this.y += ya;
				}	
				ya = 0;
			}
		}
		
		if (xa != 0 && ya != 0) {
			move(xa, 0);
			move(0, ya);
			return;
		}

		if (!collision(xa, ya)) {
			x += xa;
			y += ya;
		}
	}

	private int abs(double value) {
		if (value < 0)
			return -1;
		return 1;
	}

	public abstract void update();

	protected void shoot(double x, double y, double dir) {
		Projectile p = new WizardProjectile(x, y, dir);
		level.add(p);
	}

	private boolean collision(double xa, double ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			double xt = ((x + xa) - c % 2 * 15) / 16;
			double yt = ((y + ya) - c / 2 * 15) / 16;
			int ix = (int) Math.ceil(xt);
			int iy = (int) Math.ceil(yt);
			if (c % 2 == 0)
				ix = (int) Math.floor(xt);
			if (c / 2 == 0)
				iy = (int) Math.floor(yt);
			if (level.getTile(ix, iy).solid())
				solid = true;
		}

		return solid;
	}

	public abstract void render(Screen screen);

}
