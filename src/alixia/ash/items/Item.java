package alixia.ash.items;

public class Item {
	private short count;
	private ItemTemplate item;

	public short getCount() {
		return count;
	}

	public Item(ItemTemplate template, short count) {
		this.count = count;
		item = template;
	}
	
	 
}
