package com.dcman58.Game2d.entity.mob;

import java.util.List;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.entity.Entity;
import com.dcman58.Game2d.entity.projectile.ArrowProjectile;
import com.dcman58.Game2d.entity.projectile.Projectile;
import com.dcman58.Game2d.entity.projectile.WizardProjectile;
import com.dcman58.Game2d.util.Vector2i;

public class Shooter extends Mob {

	public Shooter(int x, int y) {
		this.x = x << 4;
		this.y = y << 4;
		sprite = Sprite.bandit;
	}

	public void update() {
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
			double dir = Math.atan2(dx, dy);
			shoot(x, y, dir);
		}
	}
	
	protected void shoot(double x, double y, double dir) {
		Projectile p = new ArrowProjectile(x, y, dir);
		level.add(p);
	}
	

	public void render(Screen screen) {
		screen.renderMob(x - 16, y - 16, this);
	}

}
