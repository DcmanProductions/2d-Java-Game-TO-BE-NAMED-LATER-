package com.dcman58.Game2d.entity.spawner;

import java.util.ArrayList;
import java.util.List;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.entity.Entity;
import com.dcman58.Game2d.level.Level;

public class Spawner extends Entity {
	private List<Entity> entities = new ArrayList<Entity>();

	public enum Type {
		MOB,PARTICLE
	}
	
	private Type type;

	public Spawner(int x, int y,Type type, int amount, Level level) {
		init(level);
		this.x = x;
		this.y = y;
		this.type = type;
		
	}

	@Override
	public void render(Screen screen) {
		
	}
}
