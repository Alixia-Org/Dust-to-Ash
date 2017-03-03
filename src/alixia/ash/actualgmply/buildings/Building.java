package alixia.ash.actualgmply.buildings;

import java.awt.Image;

public abstract class Building {
	private final Image texture;

	protected Building(Image texture) {
		this.texture=texture;
	}
}
