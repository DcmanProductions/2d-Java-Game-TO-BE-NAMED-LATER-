package com.dcman58.Game2d.level.tile;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;

public class Blue_Brick extends Tile {

	public Blue_Brick(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, sprite);
	}
	public boolean solid(){
		return true;
	}

}
