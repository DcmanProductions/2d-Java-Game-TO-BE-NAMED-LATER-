package com.dcman58.Game2d.entity.mob;

import java.util.List;

import com.dcman58.Game2d.Game;
import com.dcman58.Game2d.Graphics.AnimatedSprite;
import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.Graphics.SpriteSheet;
import com.dcman58.Game2d.entity.Entity;
import com.dcman58.Game2d.entity.projectile.ArrowProjectile;
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

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.player_down, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.player_up, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.player_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.player_right, 32, 32, 3);

	private AnimatedSprite animSprite = null;

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

		List<Entity> es = level.getEntities(this, 70);

		if (walking)
			animSprite.update();
		else
			animSprite.setFrame(0);
		if (fireRate > 0)
			fireRate--;
		double xa = 0, ya = 0;
		double speed = 1;
		if (input.up) {
			animSprite = up;
			ya -= speed;
		} else if (input.down) {
			animSprite = down;
			ya += speed;
		}
		if (input.left) {
			animSprite = left;
			xa -= speed;
		} else if (input.right) {
			animSprite = right;
			xa += speed;
		}
		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
		clear();
		updateShooting();
	}

	private void clear() {
		for (int i = 0; i < level.getProjectiles().size(); i++) {
			Projectile p = level.getProjectiles().get(i);
			if (p.isRemoved()) {
				level.getProjectiles().remove(i);
				System.out.println("Number of Projectiles "+ level.getProjectiles().size());
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
	
	protected void shoot(double x, double y, double dir) {
		Projectile p = new ArrowProjectile(x, y, dir);
		level.add(p);
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
			sprite = Sprite.player_right;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_right_1;
				} else {
					sprite = Sprite.player_right_2;
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
			sprite = Sprite.player_left;
			if (walking) {
				if (anim % 20 > 10) {
					sprite = Sprite.player_left_1;
				} else {
					sprite = Sprite.player_left_2;
				}
			}
		}

		flip = 1;
		sprite = animSprite.getSprite();
		screen.renderMob((int) (x - 16), (int) (y - 16), sprite, 0);
	}

}
