package alixia.ash.items;

import java.awt.Image;

public class Item implements Storable {
	private short count;
	private ItemTemplate item;
	private String tooltip;

	public short getCount() {
		return count;
	}

	Item(ItemTemplate template, short count) {
		this.count = count;
		item = template;
	}

	Item(short count, ItemTemplate item, String tooltip) {
		this.count = count;
		this.item = item;
		this.setTooltip(tooltip);
	}

	public String getName() {
		return item.getName();
	}

	public Image getTexture() {
		return item.getTexture();
	}

	public String getTooltip() {
		return tooltip;
	}

	public void setTooltip(String tooltip) {
		this.tooltip = tooltip;
	}

	public void onTick() {
		item.onTick(this);
	}
	
	

}
