// Kevin Chung

public class IAList {
	private int[] a; // Underlying array
	private int length; // Number of added elements in a
	// YOU WILL NEED TO ADD AT LEAST ONE NEW DATA FIELD HERE.
	public IAList() {
		length = 0; // Start with no added elements in a
		a = new int[4]; // A little room to grow
		// YOU MAY NEED TO INITIALIZE YOUR NEW DATA FIELD(S).
	}

	public int get(int i) { // Retrieve an added element, O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY GET WORKS.
		if (i < 0 || i >= length) {
			throw new IndexOutOfBoundsException(i+"");
		}
		return a[i]; // Retrieve the element at position i
	}

	public int size() { // Number of added elements, O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SIZE WORKS.
		return length; // The number of added elements
	}

	public void set(int i, int x) { // Modify an existing element, O(1)
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SET WORKS.
		if (i < 0 || i >= length) {
			throw new IndexOutOfBoundsException(i+"");
		}
		a[i] = x; // Change the existing element at position i to x
	}

	public void add(int x) { // Add an element to the end, O(n) for n
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY ADD WORKS.
		if (length >= a.length) {
			// Create new array of double the length
			int[] b = new int[a.length * 2];
			// Copy the elements of a to the corresponding indexes of b
			for (int i = 0; i < a.length; i++) {
				b[i] = a[i];
			}
			// Reassign a reference to b
			a = b;
		}
		// Place x at the end of the IAList
		a[length] = x;
		// Increase length by 1
		length = length + 1;
	}

	public void addBefore(int x) {
		/* FILL THIS IN!! */
	}
}
