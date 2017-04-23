package com.dcman58.Game2d.entity;

import java.util.Random;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.level.Level;

public abstract class Entity {
	public int x,y;
	private boolean removed = false;
	protected Level level;
	protected Random random = new Random();
	protected Sprite sprite;
	protected Screen screen;
	
	public void update(){
		
	}
	
	public abstract void render (Screen screen);
	
	public void remove(){
		// Remove from level
		removed = true;
	}
	public boolean isRemoved(){
		return removed;
	}
	
	public void init(Level level){
		this.level = level;
	}
}
