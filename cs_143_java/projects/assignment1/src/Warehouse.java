// Name: Kevin Chung (CS143 - Winter 2021)
public class Warehouse {
	private int size; // capacity of the warehouse (total number of pallets stored)
	private int limitPerItem; // limit of each item we are able to store
	private int[] warehouse;

	public Warehouse(int size, int limitPerItem) {
		this.size = size;
		this.limitPerItem = limitPerItem;
		this.warehouse = new int[size];
	}

	public int getSize() {
		return this.size;
	}

	public int getLimitPerItem() {
		return this.limitPerItem;
	}

	public int receive(int itemCode, int itemCount) {
		// adding item to the warehouse
		// itemCode refers to what item is being added
		// itemCount refers to how many of those items are being added to the warehouse
		// add as many boxes of itemCode to the array as possible

		// Hints: Calculate how many numbers exist in the warehouse(array) that are equal to itemCount
		// Hints: Calculate how many numbers exist in the warehouse(array) that are equal to itemCount
		// Calculate how many empty spaces in the warehouse (with a loop)
		// Calculate how many items you can recieve, and modify the empty spaces in the array 
		return 0;
	}

	public int ship(int itemCode, int itemCount) {
		// removing items from the warehouse
		// itemCode refers to what item is being removed
		// itemCount refers to how many of those items are being removed to the warehouse
		
		// Hints: Calculate how many numbers in the array match itemCode to see how many are availible to ship
		// Replace that many instances in the warehouse with 0 (empty space)
		return 0;
	}
	
	public String toString() {
		String s = "";
		s += "Warehouse \nSize: " + this.size + "\nLimit per Item: " + this.limitPerItem;
		return s;
	}
}