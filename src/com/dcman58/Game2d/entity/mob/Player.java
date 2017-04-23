package com.dcman58.Game2d.entity.mob;

import com.dcman58.Game2d.Game;
import com.dcman58.Game2d.Graphics.AnimatedSprites;
import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.Graphics.SpriteSheet;
import com.dcman58.Game2d.entity.projectile.Projectile;
import com.dcman58.Game2d.entity.projectile.WizardProjectile;
import com.dcman58.Game2d.input.Keyboard;
import com.dcman58.Game2d.input.Mouse;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;

	int flip = 0;
	private int fireRate;
	Projectile p;

	private AnimatedSprites down = new AnimatedSprites(SpriteSheet.player_down, 32, 32, 3);
	private AnimatedSprites up = new AnimatedSprites(SpriteSheet.player_up, 32, 32, 3);
	private AnimatedSprites left = new AnimatedSprites(SpriteSheet.player_left, 32, 32, 3);
	private AnimatedSprites right = new AnimatedSprites(SpriteSheet.player_right, 32, 32, 3);

	private AnimatedSprites animSprite = null;

	private int anim = 0;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_front;
		animSprite = down;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_front;
		fireRate = WizardProjectile.FIRE_RATE;
		animSprite = down;
	}

	public void update() {
		if (walking)
			animSprite.update();
		else
			animSprite.setFrame(0);
		if (fireRate > 0)
			fireRate--;
		int xa = 0, ya = 0;
		if (anim < 7500)
			anim++;
		else
			anim = 0;
		if (input.up) {
			ya--;
			animSprite = up;
		}
		if (input.down) {
			ya++;
			animSprite = down;
		}
		if (input.left) {
			xa--;
			animSprite = left;
		}
		if (input.right) {
			xa++;
			animSprite = right;
		}

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		// System.out.println("Sprite Loaded: "+animSprite);
		clear();
		updateShooting();

	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) {
				level.getProjectiles().remove(i);
			}
		}
	}

	private void updateShooting() {

		if (Mouse.getButton() == 1 && fireRate <= 0) {
			double dx = Mouse.getX() - Game.getWindowWidth() / 2;
			double dy = Mouse.getY() - Game.getWindowHeight() / 2;
			double dir = Math.atan2(dy, dx);
			shoot(x, y, dir);
			fireRate = WizardProjectile.FIRE_RATE;
		}
	}

	public void render(Screen screen) {

		if (dir == Direction.UP) {
			sprite = Sprite.player_back;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_back_1;
				} else {
					sprite = Sprite.player_back_2;
				}
			}
		}
		if (dir == Direction.RIGHT) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}
		if (dir == Direction.DOWN) {
			sprite = Sprite.player_front;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_front_1;
				} else {
					sprite = Sprite.player_front_2;
				}
			}
		}
		if (dir == Direction.LEFT) {
			sprite = Sprite.player_side;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_side_1;
				} else {
					sprite = Sprite.player_side_2;
				}
			}
		}

		flip = 1;
		// sprite = animSprite.getSprite();
		screen.renderMob(x - 16, y - 16, sprite, flip);
	}

}
