package com.dcman58.Game2d.entity.mob;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;
	private Sprite sprite;

	public Player(Keyboard input) {
		this.input = input;
		sprite = Sprite.player_front;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
		sprite = Sprite.player_front;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (input.up)
			ya--;
		if (input.down)
			ya++;
		if (input.left)
			xa--;
		if (input.right)
			xa++;

		if (xa != 0 || ya != 0)
			move(xa, ya);
	}

	public void render(Screen screen) {
		int flip = 0;
		if (dir == 0)
			sprite = Sprite.player_back;
		if (dir == 1)
			sprite = Sprite.player_side;
		if (dir == 2)
			sprite = Sprite.player_front;
		if (dir == 3) {
			sprite = Sprite.player_side;
			flip = 1;
		}

		screen.renderPlayer(x - 16, y - 16, sprite, flip);
	}

}
