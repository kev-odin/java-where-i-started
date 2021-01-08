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
		int returnShip = 0;
		boolean acceptShip;

		for (int room = 0; room < warehouse.length; room++) {
			if (warehouse[room] == itemCode) {
				currentInventory++;
			}

			if (warehouse[room] == 0) {
				emptySpace++;
			}
		}

		if (emptySpace == 0) { // No space availible in the warehouse
			returnShip = itemCount;
			return returnShip;
		}

		if (emptySpace > 0) { // Space is availible in the warehouse, how many items can we take?
			if (currentInventory < limitPerItem) {
				itemCount = itemCount - currentInventory;

				for (int space = 0; space < itemCount; space++) {
					if (warehouse[space] == 0 && currentInventory < limitPerItem) {
						warehouse[space] = itemCode;
						emptySpace--; // Do I want to decrement from itemCount or emptySpace?
						itemCount--;
						currentInventory++;
					}
				}
				returnShip = itemCount - currentInventory;
				return returnShip;
			}
		}
		return returnShip;
	}

	public int ship(int itemCode, int itemCount) {

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