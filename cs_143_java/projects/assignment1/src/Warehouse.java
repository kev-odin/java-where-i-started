// Name: Kevin Chung (CS143 - Winter 2021)
public class Warehouse {
	private int size; // capacity of the warehouse (total number of pallets stored)
	private int limitPerItem; // limit of each item we are able to store
	private int[] warehouse;

	public Warehouse(int size, int limitPerItem) {
		// size of array should be included with the constructor method.
	}

	public int getSize() {
		return size;
	}

	public int getLimitPerItem() {
		return limitPerItem;
	}

	public int receive(int itemCode, int itemCount) {
		// adding itme to the warehouse
		// itemCode refers to what item is being added
		// itemCount refers to how many of those items are being added to the warehouse
		return 0;
	}

	public int ship(int itemCode, int itemCount) {
		// removing items from the warehouse
		// itemCode refers to what item is being removed
		// itemCount refers to how many of those items are being removed to the warehouse
		return 0;
	}
}
