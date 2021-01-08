// Name: Kevin Chung (CS143 - Winter 2021)
public class Warehouse {
	private int size;
	private int limitPerItem;
	private int[] warehouse;

	public Warehouse(int size, int limitPerItem) {
		this.size = size;
		this.limitPerItem = limitPerItem;
		this.warehouse = new int[size];
	}

	public int receive(int itemCode, int itemCount) {
		int currentInventory = 0;
		int emptySpace = 0;
		int overStock = 0;
		boolean acceptShip;

		for (int room = 0; room < warehouse.length; room++) {
			if (warehouse[room] == itemCode) {
				currentInventory++;
			}

			if (warehouse[room] == 0) {
				emptySpace++;
			}
		}

		if (emptySpace == 0) {
			acceptShip = false;
			return itemCount;
		}

		if (itemCount <= limitPerItem && itemCount <= emptySpace) {
			for (int space = 0; space < itemCount; space++) {
				if (warehouse[space] == 0) {
					warehouse[space] = itemCode;
				}
			}
			return itemCount;
		}
		return overStock;
	}

	public int ship(int itemCode, int itemCount) {
		// removing items from the warehouse
		// itemCode refers to what item is being removed
		// itemCount refers to how many of those items are being removed to the
		// warehouse

		// Hints: Calculate how many numbers in the array match itemCode to see how many
		// are availible to ship
		// Replace that many instances in the warehouse with 0 (empty space)
		return 99;
	}

	public int getSize() {
		return this.size;
	}

	public int getLimitPerItem() {
		return this.limitPerItem;
	}

	public String toString() {
		String s = "Warehouse: \n";
		s += "Size: " + this.size;
		s += "\nLimit per Item: " + this.limitPerItem;
		return s;
	}
}