package com.dcman58.Game2d.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.dcman58.Game2d.entity.mob.Bandit;
import com.dcman58.Game2d.entity.mob.Dummy;
import com.dcman58.Game2d.entity.mob.Guard;
import com.dcman58.Game2d.entity.mob.Shooter;

public class SpawnLevel extends Level {
	
	
	private int mobs = 3;

	public SpawnLevel(String path) {
		super(path);
	}

	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = width = image.getWidth();
			int h = height = image.getHeight();
			tiles = new int[w * h];

			image.getRGB(0, 0, w, h, tiles, 0, w);
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("Exception, could not load level file.  " + e.getMessage());
		}
		for (int i = 0; i < 10; i++) {
			// Spawns more than one mob
			add(new Bandit(52, 85));
		}
		add(new Dummy(52, 83));
		add(new Guard(45, 45));
		add(new Shooter(47, 53));
	}

	protected void generateLevel() {
	}
}
