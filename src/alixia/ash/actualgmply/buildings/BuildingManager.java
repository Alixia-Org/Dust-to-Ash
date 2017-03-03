package alixia.ash.actualgmply.buildings;

import alixia.ash.Ash;
import alixia.ash.Map;

public class BuildingManager {
	private Ash instance;
	private Map map;

	public BuildingManager(Ash instance) {
		this.instance=instance;
		map=instance.getWorld().getOverworldMap();
	}
}
