package com.dcman58.Game2d.entity.mob;

import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.entity.Entity;

public abstract class Mob extends Entity {

	protected Sprite sprite;
	protected int dir = 2;
	protected boolean moving = false;

	public void move(int xa, int ya) {
		if (xa > 0)
			dir = 1;
		if (xa < 0)
			dir = 3;
		if (ya > 0)
			dir = 2;
		if (ya < 0)
			dir = 0;

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

	public void update() {

	}

	private boolean collision(int xa, int ya) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = ((x + xa) + c % 2 * 15 - 8) / 16;
			int yt = ((y + ya) + c / 2 * 17- 3) / 16;
			if (level.getTile(xt, yt).solid())
				solid = true;
		}

		return solid;
	}

	public void render() {

	}

}
