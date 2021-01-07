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
		int emptySpace = 0;
		int currentInventory = 0;

		for (int space = 0; space < warehouse.length; space++) {
			//if ( tree0 != null ) area += tree0.area();
			if (warehouse[space] == 0) {
				emptySpace++;
			}
		}

		for (int space = 0; space < warehouse.length; space++) {
			if (warehouse[space] == itemCode) {
				currentInventory++;
			}
		}

		// adding item to the warehouse, itemCode refers to what item is being added
		for (int space = 0; space < itemCount; space++) {
			if (warehouse[space] == 0) {
				warehouse[space] = itemCode;
			}
		}

		// itemCount refers to how many of those items are being added to the warehouse
		// add as many boxes of itemCode to the array as possible

		// Hints: Calculate how many numbers exist in the warehouse(array) that are equal to itemCount
		// Calculate how many empty spaces in the warehouse (with a loop)
		// Calculate how many items you can recieve, and modify the empty spaces in the array 
		return size - currentInventory - emptySpace;
	}

	public int ship(int itemCode, int itemCount) {
		// removing items from the warehouse
		// itemCode refers to what item is being removed
		// itemCount refers to how many of those items are being removed to the warehouse
		
		// Hints: Calculate how many numbers in the array match itemCode to see how many are availible to ship
		// Replace that many instances in the warehouse with 0 (empty space)
		return 0;
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