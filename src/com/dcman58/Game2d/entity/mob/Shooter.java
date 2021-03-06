package com.dcman58.Game2d.entity.mob;

import java.util.List;

import com.dcman58.Game2d.Graphics.AnimatedSprite;
import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.Graphics.SpriteSheet;
import com.dcman58.Game2d.entity.Entity;
import com.dcman58.Game2d.util.Debug;
import com.dcman58.Game2d.util.Vector2i;

public class Shooter extends Mob {

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.bandit_down, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.bandit_up, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.bandit_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.bandit_right, 32, 32, 3);

	private AnimatedSprite animSprite = down;

	private int time = 0;
	private int xa = 0, ya = 0;

	private Entity rand = null;

	public Shooter(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		sprite = Sprite.bandit;
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
		shootClosest();
	}

	private void shootRandom() {
		if (time % 60 == 0) {
			List<Entity> entities = level.getEntities(this, 50);
			entities.add(level.getClientPlayer());
			if (entities.size() > 0) {
				int index = random.nextInt(entities.size());
				rand = entities.get(index);
			}
		}
		if (rand != null) {
			double dx = rand.getX() - x;
			double dy = rand.getY() - y;
			double dir = Math.atan2(dy, dx);
			if (time % 30 == 0)
				shoot(x, y, dir);
		}
	}

	private void shootClosest() {
		List<Entity> entities = level.getEntities(this, 50);
		entities.add(level.getClientPlayer());

		double min = 0;
		Entity closest = null;
		for (int i = 0; i < entities.size(); i++) {
			Entity e = entities.get(i);
			double distance = Vector2i.getDistance(new Vector2i(x, y), new Vector2i(e.getX(), e.getY()));
			if (i == 0 || distance < min) {
				min = distance;
				closest = e;
			}
		}

		if (closest != null) {
			double dx = closest.getX() - x;
			double dy = closest.getY() - y;
			double dir = Math.atan2(dy, dx);
			if (time % 30 == 0)
				shoot(x, y, dir);
		}

	}

	public void render(Screen screen) {
//		Debug.drawRect(screen, 47 * 16, 57 * 16, 40, 40, 0xff0000, true);
		sprite = animSprite.getSprite();
		screen.renderMob(x - 16, y - 16, this);
	}

}
