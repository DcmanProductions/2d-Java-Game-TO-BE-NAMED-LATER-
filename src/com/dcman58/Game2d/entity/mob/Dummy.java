package com.dcman58.Game2d.entity.mob;

import com.dcman58.Game2d.Graphics.AnimatedSprites;
import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.Graphics.SpriteSheet;

public class Dummy extends Mob {

	private AnimatedSprites down = new AnimatedSprites(SpriteSheet.dummy_down, 32, 32, 3);
	private AnimatedSprites up = new AnimatedSprites(SpriteSheet.dummy_up, 32, 32, 3);
	private AnimatedSprites left = new AnimatedSprites(SpriteSheet.dummy_left, 32, 32, 3);
	private AnimatedSprites right = new AnimatedSprites(SpriteSheet.dummy_right, 32, 32, 3);

	private int time = 0;

	private AnimatedSprites animSprite = down;
	int xa = 0;
	int ya = 0;
	private int anim = 0;

	public Dummy(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		sprite = Sprite.dummy_down;
	}

	public void update() {
		time++;
		if (time % (random.nextInt(50) + 30) == 0) {
			xa = random.nextInt(3) - 1;
			ya = random.nextInt(3) - 1;
			if (random.nextInt(2) == 0) {
				xa = 0;
				ya = 0;
			}
		}
		if (walking)
			animSprite.update();
		else
			animSprite.setFrame(0);
		if (ya < 0) {
			dir = Direction.UP;
			animSprite = up;
		} else if (ya > 0) {
			dir = Direction.DOWN;
			animSprite = down;
		}
		if (xa < 0) {
			dir = Direction.LEFT;
			animSprite = left;
		} else if (xa > 0) {
			dir = Direction.RIGHT;
			animSprite = right;
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		if (walking)
			animSprite.update();
		else
			animSprite.setFrame(0);
		if (ya < 0) {
			dir = Direction.UP;
			if (anim % 20 > 10) {
				sprite = Sprite.dummy_forward_1;
			} else {
				sprite = Sprite.dummy_forward_2;
			}
			animSprite = up;
		} else if (ya > 0) {
			dir = Direction.DOWN;
			animSprite = down;
			if (anim % 20 > 10) {
				sprite = Sprite.dummy_back_1;
			} else {
				sprite = Sprite.dummy_back_2;
			}
		}
		if (xa < 0) {
			dir = Direction.LEFT;
			animSprite = left;
			if (anim % 20 > 10) {
				sprite = Sprite.dummy_left_1;
			} else {
				sprite = Sprite.dummy_left_2;
			}
		} else if (xa < 0) {
			dir = Direction.RIGHT;
			animSprite = right;
			if (anim % 20 > 10) {
				sprite = Sprite.dummy_right_1;
			} else {
				sprite = Sprite.dummy_right_2;
			}
		}

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}

	}

	public void render(Screen screen) {
		// sprite = sprite.dummy_down;
		sprite = animSprite.getSprite();
		screen.renderMob(x, y, sprite, 0);
	}

}
