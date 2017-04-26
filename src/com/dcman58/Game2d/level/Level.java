package com.dcman58.Game2d.level;

import java.util.ArrayList;
import java.util.List;

import com.dcman58.Game2d.Graphics.Screen;
import com.dcman58.Game2d.entity.Entity;
import com.dcman58.Game2d.entity.mob.Player;
import com.dcman58.Game2d.entity.particle.Particle;
import com.dcman58.Game2d.entity.projectile.Projectile;
import com.dcman58.Game2d.level.tile.Tile;

public class Level {

	protected int width, height;
	protected int[] tilesInt;

	private List<Entity> entities = new ArrayList<Entity>();
	private List<Projectile> projectiles = new ArrayList<Projectile>();
	private List<Particle> particles = new ArrayList<Particle>();
	private List<Player> players = new ArrayList<Player>();

	protected int[] tiles;
	public static Level spawn = new SpawnLevel("/textures/Levels/SpawnLevel.png");

	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tilesInt = new int[width * height];
		generateLevel();
	}

	public Level(String path) {
		loadLevel(path);
		generateLevel();

	}

	public List<Projectile> getProjectiles() {
		return projectiles;
	}

	protected void loadLevel(String path) {

	}

	public List<Player> getPlayers() {
		return players;
	}

	public Player getPlayerAt(int index) {
		return players.get(index);
	}

	public Player getClientPlayer() {
		return players.get(0);
	}

	protected void generateLevel() {

	}

	public void update() {
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).update();
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).update();
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).update();
		}
		for (int i = 0; i < players.size(); i++) {
			if (players.size() == 2 || players.size() > 2)
				players.get(i).update();
			else
				return;
		}
		remove();
	}

	private void remove() {
		for (int i = 0; i < entities.size(); i++) {
			if (entities.get(i).isRemoved())
				entities.remove(i);
		}
		for (int i = 0; i < particles.size(); i++) {
			if (particles.get(i).isRemoved())
				particles.remove(i);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			if (projectiles.get(i).isRemoved())
				projectiles.remove(i);
		}
		for (int i = 0; i < players.size(); i++) {
			if (players.get(i).isRemoved())
				players.remove(i);
		}
	}

	private void time() {

	}

	public boolean tileCollision(int x, int y, int xOffset, int yOffset, int size) {
		boolean solid = false;
		for (int c = 0; c < 4; c++) {
			int xt = (x - c % 2 * size / xOffset) / 16;
			int yt = (y - c / 2 * size / yOffset) / 16;
			if (getTile(xt, yt).solid())
				solid = true;
		}

		return solid;
	}

	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		int x0 = xScroll >> 4;
		int y0 = yScroll >> 4;
		int x1 = (xScroll + screen.width + 16) >> 4;
		int y1 = (yScroll + screen.height + 16) >> 4;

		for (int y = y0; y < y1; y++) {
			for (int x = x0; x < x1; x++) {
				getTile(x, y).render(x, y, screen);

			}
		}
		for (int i = 0; i < entities.size(); i++) {
			entities.get(i).render(screen);
		}
		for (int i = 0; i < projectiles.size(); i++) {
			projectiles.get(i).render(screen);
		}
		for (int i = 0; i < particles.size(); i++) {
			particles.get(i).render(screen);
		}
		for (int i = 0; i < players.size(); i++) {
			players.get(i).render(screen);
		}

	}

	public void add(Entity e) {
		e.init(this);
		if (e instanceof Particle) {
			particles.add((Particle) e);
		} else if (e instanceof Projectile) {
			projectiles.add((Projectile) e);
		} else {
			entities.add(e);
		}
		if (e instanceof Player) {
			players.add((Player) e);
		} else {
			entities.add(e);
		}
	}

	/*
	 * Grass 0xFF00FF00 Flower 0xFFF0FF00 Rock 0xFF6B6B6B Blue Flower 0xFF0081FF
	 * Rose 0xFFFF7800 Tree 0xFF006B00
	 * 
	 * Hedge 0xFF008000 RedBrick 0xFFFF0000 Mossy_Gray_Brick 0xFF6BA76B
	 * Mossy_Red_Brick 0xFFBE0000 GrayBrick 0xFF9E9E9E Water 0xFF0097FF
	 */

	public Tile getTile(int x, int y) {
		if (x < 0 || y < 0 || x >= width || y >= height)
			return Tile.grass;

		if (tiles[x + y * width] == Tile.col_grass)
			return Tile.grass;

		if (tiles[x + y * width] == Tile.col_flower)
			return Tile.flower;

		if (tiles[x + y * width] == Tile.col_rock)
			return Tile.rock;

		if (tiles[x + y * width] == Tile.col_rose)
			return Tile.rose;

		if (tiles[x + y * width] == Tile.col_blue_flower)
			return Tile.blue_flower;

		if (tiles[x + y * width] == Tile.col_red_brick)
			return Tile.red_brick;

		if (tiles[x + y * width] == Tile.col_gray_brick)
			return Tile.gray_brick;

		if (tiles[x + y * width] == Tile.col_mossy_gray_brick)
			return Tile.mossy_gray_brick;

		if (tiles[x + y * width] == Tile.col_mossy_red_brick)
			return Tile.mossy_red_brick;

		if (tiles[x + y * width] == Tile.col_hedge)
			return Tile.hedge;

		if (tiles[x + y * width] == Tile.col_water)
			return Tile.water;

		if (tiles[x + y * width] == Tile.col_blue_brick)
			return Tile.blue_brick;

		return Tile.grass;

	}

	public List<Entity> getEntities(Entity e, int radius) {
		List<Entity> result = new ArrayList<Entity>();
		double ex = e.getX();
		double ey = e.getY();

		for (int i = 0; i < entities.size(); i++) {
			Entity entity = entities.get(i);
			double x = entity.getX();
			double y = entity.getY();
			double dx = Math.abs(x - ex);
			double dy = Math.abs(y - ey);
			double distance = Math.sqrt((dx * dx) + (dy * dy));
			if (distance <= radius)
				result.add(entity);
		}
		return result;
	}

	public List<Player> getPlayers(Entity e, int radius) {
		List<Player> result = new ArrayList<Player>();
		double ex = e.getX();
		double ey = e.getY();
		for (int i = 0; i < players.size(); i++) {
			Player player = players.get(i);
			double x = player.getX();
			double y = player.getY();
			double dx = Math.abs(x - ex);
			double dy = Math.abs(y - ey);
			double distance = Math.sqrt((dx * dx) + (dy * dy));
			if (distance <= radius)
				result.add(player);
		}
		return result;
	}

}
