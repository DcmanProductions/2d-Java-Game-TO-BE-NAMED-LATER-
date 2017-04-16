package com.dcman58.Game2d.entity.mob;

import com.dcman58.Game2d.input.Keyboard;

public class Player extends Mob {

	private Keyboard input;

	public Player(Keyboard input) {
		this.input = input;
	}

	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}

	public void update() {
		int xa = 0, ya = 0;
		if (input.up)
			y--;
		if (input.down)
			y++;
		if (input.left)
			x--;
		if (input.right)
			x++;
		
		if(xa!=0||ya!=0)move(xa,ya);
	}

	public void render() {

	}

}
