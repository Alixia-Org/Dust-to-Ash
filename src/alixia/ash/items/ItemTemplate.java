package alixia.ash.items;

import java.awt.Image;

public abstract class ItemTemplate {
	private String name;
	protected Image texture;

	public ItemTemplate(String name, Image texture) {
		setName(name);
		setTexture(texture);
	}

	public String getName() {
		return name;
	}

	public Image getTexture() {
		return texture;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setTexture(Image texture) {
		this.texture = texture;
	}

}
