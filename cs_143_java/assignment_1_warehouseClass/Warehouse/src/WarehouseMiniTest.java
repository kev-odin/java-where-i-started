/**
 * Mini Test program for CS 143 Assignment 1 (Version of 9/22/2020 4:17 PM)
 * 
 * You may only use this program as a student of Martin Hock, CS 143 Fall 2020.
 * 
 * 
 * Directions: Run this program from the same project source folder as your
 * Warehouse.java file.
 */

public class WarehouseMiniTest {

	public static boolean checkReceive(Warehouse w, String name, int itemCode, int itemCount, int expected) {
		System.out.println("Warehouse " + name + " receives " + itemCount + " pallet" + (itemCount == 1 ? "" : "s")
				+ " of item " + itemCode + ".");
		int ret = w.receive(itemCode, itemCount);
		if (ret != expected) {
			System.out.println(
					name + ".receive(" + itemCode + ", " + itemCount + ") returned " + ret + " instead of " + expected);
			return false;
		}
		return true;
	}

	public static boolean checkShip(Warehouse w, String name, int itemCode, int itemCount, int expected) {
		System.out.println("Warehouse " + name + " is requested to ship " + itemCount + " pallet"
				+ (itemCount == 1 ? "" : "s") + " of item " + itemCode + ".");
		int ret = w.ship(itemCode, itemCount);
		if (ret != expected) {
			System.out.println(
					name + ".ship(" + itemCode + ", " + itemCount + ") returned " + ret + " instead of " + expected);
			return false;
		}
		return true;
	}

	public static void main(String[] args) {
		System.out.println("Please check for the full WarehouseTest on the course page!");
		System.out.println("Following scenario from assignment description.");
		Warehouse A = new Warehouse(3, 2);
		if (checkReceive(A, "A", 1, 3, 1) && checkReceive(A, "A", 2, 1, 0) && checkShip(A, "A", 1, 1, 1)
				&& checkReceive(A, "A", 1, 2, 1) && checkReceive(A, "A", 4, 1, 1) && checkShip(A, "A", 1, 2, 2)
				&& checkReceive(A, "A", 2, 2, 1)) {
			System.out.println("Awesome!");
		} else {
			System.out.println("Please fix the above and run again.");
		}

	}

}
