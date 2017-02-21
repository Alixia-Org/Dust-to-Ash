package alixia.ash.items;

import java.awt.Image;

public abstract class ItemTemplate {
	private String name;
	private String defaultTooltip;
	protected Image texture;

	protected ItemTemplate(String name, Image texture, String defaultTooltip) {
		setName(name);
		setTexture(texture);
		setDefaultTooltip(defaultTooltip);
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

	public void onTick(Storable items) {

	}

	String getDefaultTooltip() {
		return defaultTooltip;
	}

	public void setDefaultTooltip(String defaultTooltip) {
		this.defaultTooltip = defaultTooltip;
	}

}
