package alixia.ash.items;

public class Item implements Storable {
	private short count;
	private ItemTemplate item;

	public short getCount() {
		return count;
	}

	Item(ItemTemplate template, short count) {
		this.count = count;
		item = template;
	}

}
