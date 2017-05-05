package com.dcman58.Game2d.entity.mob;

import java.util.List;

import com.dcman58.Game2d.Graphics.AnimatedSprite;
import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.Graphics.SpriteSheet;
import com.dcman58.Game2d.level.Node;
import com.dcman58.Game2d.util.Vector2i;

public class Guard extends Mob {

	private AnimatedSprite down = new AnimatedSprite(SpriteSheet.guard_down, 32, 32, 3);
	private AnimatedSprite up = new AnimatedSprite(SpriteSheet.guard_up, 32, 32, 3);
	private AnimatedSprite left = new AnimatedSprite(SpriteSheet.guard_left, 32, 32, 3);
	private AnimatedSprite right = new AnimatedSprite(SpriteSheet.guard_right, 32, 32, 3);
	public AnimatedSprite animSprite = down;
	private int time;

	private double xa = 0;
	private double ya = 0;
	private double speed = 0.8;

	private List<Node> path = null;

	public Guard(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		sprite = Sprite.guard;
	}

	public void update() {
		time++;
		move();
		if (walking)
			animSprite.update();
		else
			animSprite.setFrame(0);
		if (ya < 0) {
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
		sprite = sprite.guard;
	}

	private void move() {
		xa = 0;
		ya = 0;
		int px = level.getPlayerAt(0).getX();
		int py = level.getPlayerAt(0).getY();
		Vector2i start = new Vector2i(getX() >> 4, getY() >> 4);
		Vector2i destination = new Vector2i(px >> 4, py >> 4);
		if (time % 2 == 0)
			path = level.findPath(start, destination);
		if (path != null) {
			if (path.size() > 0) {
				Vector2i vec = path.get(path.size() - 1).tile;
				if (x < vec.getX() << 4)
					xa++;
				if (x > vec.getX() << 4)
					xa--;
				if (y < vec.getY() << 4)
					ya++;
				if (y > vec.getY() << 4)
					ya--;
			}
		}

		if (xa != 0 || ya != 0) {
			move(xa, ya);
			walking = true;
		} else {
			walking = false;
		}
	}

	@Override
	public void render(Screen screen) {
		sprite = animSprite.getSprite();
		screen.renderMob((int) (x - 16), (int) (y - 16), this);
	}
}
