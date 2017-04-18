package com.dcman58.Game2d.entity.projectile;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;

public class WizardProjectile extends Projectile {

	public WizardProjectile(int x, int y, double dir) {
		super(x, y, dir);
		range = 300;
		speed = 4;
		damage = 20;
		rateOfFire = 15;

		sprite = Sprite.grass;
		
		nx = speed * Math.cos(angle);
		ny = speed * Math.sin(angle);
	}
	
	public void update(){
		move();
		
	}
	
	protected void move(){
		x+=nx;
		y+=ny;
	}
	
	public void render(Screen screen){
		screen.renderTile(x, y, sprite);
	}
	
	

}
