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

		for (int room = 0; room < warehouse.length; room++) {
			if (warehouse[room] == itemCode) {
				currentInventory++;
			}

			if (warehouse[room] == 0) {
				emptySpace++;
			}
		}

		if (emptySpace == 0) { // No space availible in the warehouse
			return itemCount;
		}

		if (emptySpace > 0) { // Space is availible in the warehouse, how many items can we take?

			for (int space = 0; space < warehouse.length; space++) {
				if (warehouse[space] == 0 && currentInventory < limitPerItem) {
					warehouse[space] = itemCode;
					itemCount--;
					currentInventory++;
				}
			}
		}
		return itemCount;
	}

	public int ship(int itemCode, int itemCount) {
		int currentInventory = 0;
		int deliveredBox = 0;
		boolean weHaveIt = false;

		for (int room = 0; room < warehouse.length; room++) {
			if (warehouse[room] == itemCode) {
				currentInventory++;
				weHaveIt = true;
			}
		}

		if (weHaveIt) {
			for (int room = 0; room < warehouse.length; room++) {
				if (warehouse[room] == itemCode && deliveredBox <= itemCount) {
					warehouse[room] = 0;
					deliveredBox++;
					itemCount--;
				}
			}
		}

		return deliveredBox;
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