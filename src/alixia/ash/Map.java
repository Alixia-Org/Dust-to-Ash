package alixia.ash;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Map {
	
	public final class Type{
		// These are basically worlds that we plan on making.
		public static final short OVERWORLD = 1;
		public static final short UNDERWORLD = 2;
		public static final short HELL = 3;
		public static final short MOON = 4;
		public static final short OCEAN = 5;
	}

	private Tile[][] tiles = new Tile[5000][20];
	private final Ash instance;
	private short type;

	void onTick() {
		for (Tile[] tileSubArr : tiles)
			for (Tile tile : tileSubArr)
				tile.onTick(instance);
	}

	void initialize() {

	}
	

	void dispose() {
		// TODO Auto-generated method stub
	}

	void onRender(Graphics graphics, JFrame observer) {

	}

	public Map(Ash instance, short mapType) {
		this.instance = instance;
		type = mapType;
	}

	public Ash getInstance() {
		return instance;
	}
}
