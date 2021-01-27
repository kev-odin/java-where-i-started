// Kevin Chung

public class IAList {
	private int[] a; // Underlying array
	private int length; // Number of added elements in a
	private int header; // Start position of data

	public IAList() { // YOU WILL NEED TO ADD AT LEAST ONE NEW DATA FIELD HERE.
		a = new int[4]; // A little room to grow
		length = 0; // Start with no added elements in a
		header = 0; // YOU MAY NEED TO INITIALIZE YOUR NEW DATA FIELD(S).
	}

	public int get(int i) { // THE NEW DATA FIELD(S) MAY CHANGE THE WAY GET WORKS.
		if (i < 0 || i >= length) { // Retrieve an added element, O(1)
			throw new IndexOutOfBoundsException(i + "");
		}
		return a[i]; // Retrieve the element at position i
	}

	public int size() { // Number of added elements, O(1)
		// the data does not start are the beginning of the array
		// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SIZE WORKS.
		return length; // The number of added elements to array
	}

	public void set(int i, int x) { // Modify an existing element, O(1)
		if (i < 0 || i >= a.length) { // THE NEW DATA FIELD(S) MAY CHANGE THE WAY SET WORKS.
			throw new IndexOutOfBoundsException(i + "");
		}
		a[i] = x; // Change the existing element at position i to x
	}

	public void add(int x) { // Add an element to the end, O(n) for n
		if (length >= a.length) { // THE NEW DATA FIELD(S) MAY CHANGE THE WAY ADD WORKS.
			int[] b = new int[a.length * 2]; // Create new array of double the length
			for (int i = header; i < a.length; i++) { // Copy the elements of a to the corresponding indexes of b
				b[i] = a[i];
			}
			a = b; // Reassign a reference to b
		}
		a[length] = x; // Place x at the end of the IAList
		length++; // Increase length by 1
	}

	public void addBefore(int x) {
		int maxSize = a.length;
		if (length >= a.length || header == 0 && length == maxSize) {		// No space availible for addBefore OR at the start
			int[] b = new int[a.length * 2];	//TODO: Shift the index + 1
			header = b.length - a.length;
			for (int i = b.length - a.length; i < b.length; i++) {				// Copy my items in the array from the tail to head
				b[i] = a[i - a.length];
				header--;
			}
			length++;
			b[header] = x;
			a = b;
		} else if (length < maxSize && header == 0) {
			for (int i = a.length - 1; i > 0; i--) {
				a[i] = a[i - 1];
			}
			length++;
			a[header] = x;
		}
	}
}
