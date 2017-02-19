package alixia.ash.items;

import java.util.LinkedList;

public final class ItemManager {

	private static ItemManager registry = new ItemManager();

	private LinkedList<ItemTemplate> items = new LinkedList<>();

	private ItemManager() {
	}

	public static int registerItem(ItemTemplate item) {
		registry.items.add(item);
		return registry.items.size();
	}

	public static Item getItem(int id, short count) {
		Item item;
		try {
			item = new Item(registry.items.get(id), count);
		} catch (IndexOutOfBoundsException e) {
		} finally {
			item = null;
		}

		return item;
	}
}
