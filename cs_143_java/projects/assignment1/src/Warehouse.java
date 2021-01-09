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
		if (emptySpace > 0) {
			for (int room = 0; room < warehouse.length; room++) {
				if (warehouse[room] == 0 && currentInventory < limitPerItem && itemCount > 0) {
					warehouse[room] = itemCode;
					currentInventory++;
					emptySpace--;
					itemCount--;
				}
			}
		}
		return itemCount;
	}

	public int ship(int itemCode, int itemCount) {
		int deliveredBox = 0;
		boolean weHaveIt = false;

		for (int room = 0; room < warehouse.length; room++) {
			if (warehouse[room] == itemCode) {
				weHaveIt = true;
				if (warehouse[room] == itemCode && itemCount > 0 && weHaveIt) {
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