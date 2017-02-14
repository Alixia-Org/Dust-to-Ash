package alixia.ash;

import java.awt.Graphics;

import javax.swing.JFrame;

public class World {
	private final Map overworld,underworld,hell,moon,ocean;
	private final Ash instance;

	public World(Ash instance) {
		overworld  = new Map(instance, Map.Type.OVERWORLD);
		underworld = new Map(instance, Map.Type.UNDERWORLD);
		
		this.instance = instance;
	}

	public Map getMap() {
		return map;
	}

	public Ash getInstance() {
		return instance;
	}

	void onTick() {
		map.onTick();
	}

	void onRender(Graphics graphics, JFrame observer) {
		map.onRender(graphics, observer);
	}

	void initialize() {
		map.initialize();
	}

	void dispose() {
		map.dispose();
	}

}
