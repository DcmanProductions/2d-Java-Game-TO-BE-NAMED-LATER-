package com.dcman58.Game2d.entity.mob;

import com.dcman58.Game2d.Graphics.AnimatedSprite;
import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.SpriteSheet;

public class Bandit extends Mob {

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.bandit_down, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.bandit_up, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.bandit_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.bandit_right, 32, 32, 3);

	public AnimatedSprite animSprite = down;

	private int xa = 0;
	private int ya = 0;

	public Bandit(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;

	}

	public void update() {
		if (walking)
			animSprite.update();
		else
			animSprite.setFrame(0);
		if (y < 0) {
			animSprite = up;
			dir = Direction.UP;
		} else if (ya > 0) {
			animSprite = down;
			dir = Direction.DOWN;
		}
		if (xa < 0) {
			animSprite = left;
			dir = Direction.LEFT;
		} else if (xa > 0) {
			animSprite = right;
			dir = Direction.RIGHT;
		}
		sprite = sprite.bandit;
	}

	@Override
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int) (x - 16), (int) (y - 16), this);
	}

}
