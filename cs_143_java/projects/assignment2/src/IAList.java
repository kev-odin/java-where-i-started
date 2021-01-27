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

	public void add(int x) { // Add an element to the end, O(n) for n
		if (length + header >= a.length) { // THE NEW DATA FIELD(S) MAY CHANGE THE WAY ADD WORKS.
			int[] b = new int[a.length * 2]; // Create new array of double the length
			for (int i = header; i < a.length; i++) { // Copy the elements of a to the corresponding indexes of b
				b[i] = a[i];
			}
			a = b;
		}
		a[length + header] = x; // Place x at the end of the continuous data
		length++;
	}

	public void addBefore(int x) {
		if (length >= a.length || header == 0) { // No space availible for addBefore OR at the start
			int[] b = new int[a.length * 2]; // Double length of array a
			header = b.length - 1; // Header is starting at the end of array
			for (int i = header; i >= a.length; i--) { // Copy my items in the array from the tail to head
				b[i] = a[i - a.length];
				header--;
			}
			b[header] = x;
			length++;
			a = b;
		} else { // Room in the array to place element and data does not start at 0
			header--;
			a[header] = x;
			length++;
		}
	}

	public int get(int i) { // THE NEW DATA FIELD(S) MAY CHANGE THE WAY GET WORKS. 
		if (i < 0 || i >= length) { //(Retrieve an added element, O(1))
			throw new IndexOutOfBoundsException(i + "");
		} else {
			i = i + header;
		}
		return a[i]; // Retrieve the element at position i
	}

	public void set(int i, int x) { // THE NEW DATA FIELD(S) MAY CHANGE THE WAY SET WORKS. 
		// (Modify an existing element, O(1))
		if (i < 0 || i >= a.length) {
			throw new IndexOutOfBoundsException(i + "");
		} else {
			i = i + header;
		}
		a[i] = x;
	}

	public int size() { // THE NEW DATA FIELD(S) MAY CHANGE THE WAY SIZE WORKS.
		return length;	//(Number of added elements, O(1))
	}
}