package com.dcman58.Game2d.entity.particle;

import java.util.ArrayList;
import java.util.List;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.Graphics.Sprite;
import com.dcman58.Game2d.entity.Entity;

public class Particle extends Entity {

	private List<Particle> particles = new ArrayList<Particle>();

	private int life;

	private int time;

	protected double xx, yy, xa, ya;

	public Particle(int x, int y, int life) {
		this.x = x;
		this.y = y;
		this.life = life + (random.nextInt(20) - 10);
		this.xx = x;
		this.yy = y;
		sprite = Sprite.particles_normal;
		this.xa = random.nextGaussian();
		this.ya = random.nextGaussian();
	}

	public Particle(int x, int y, int life, int amount) {
		this(x, y, life);
		for (int i = 0; i < amount - 1; i++) {
			particles.add(new Particle(x, y, life));
		}
		particles.add(this);
	}

	public void update() {
		time++;
		if (time >= 7400 - 10)
			time = 0;
		if (time > life)
			remove();

		this.xx += xa;
		this.yy += ya;
	}

	public void render(Screen screen) {
		screen.renderSprite((int) xx, (int) yy, sprite, true);
	}
}