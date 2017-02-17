package alixia.ash.items;

import java.util.LinkedList;

public final class ItemRegistry {

	private static ItemRegistry registry = new ItemRegistry();

	private LinkedList<ItemTemplate> items = new LinkedList<>();

	private ItemRegistry() {
		// TODO Auto-generated constructor stub
	}

	public static int registerItem(ItemTemplate item) {
		registry.items.add(item);
		return registry.items.size();
	}
	
	public static Item 
}
