// Kevin Chung

public class IAList {
	private int[] a; 										// Underlying array
	private int length; 									// Number of added elements in a
	private int shift;										// Shifted position of when data starts

	public IAList() {										// YOU WILL NEED TO ADD AT LEAST ONE NEW DATA FIELD HERE.
		a = new int[4]; 									// A little room to grow
		length = 0; 										// Start with no added elements in a
		shift = 0;											// YOU MAY NEED TO INITIALIZE YOUR NEW DATA FIELD(S).
	}

	public int get(int i) { 								// THE NEW DATA FIELD(S) MAY CHANGE THE WAY GET WORKS.
		if (i < 0 || i >= length) {							// Retrieve an added element, O(1)
			throw new IndexOutOfBoundsException(i + "");
		}
		return a[i]; 										// Retrieve the element at position i
	}

	public int size() { 									// Number of added elements, O(1)
		int dateSize;										// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SIZE WORKS.
		return length; 										// The number of added elements to array
	}

	public void set(int i, int x) { 						// Modify an existing element, O(1)
		if (i < 0 || i >= a.length) {						// THE NEW DATA FIELD(S) MAY CHANGE THE WAY SET WORKS.
			throw new IndexOutOfBoundsException(i + "");
		}
		a[i] = x; 											// Change the existing element at position i to x
	}

	public void add(int x) { 								// Add an element to the end, O(n) for n
		if (length >= a.length) {							// THE NEW DATA FIELD(S) MAY CHANGE THE WAY ADD WORKS.
			int[] b = new int[a.length * 2]; 				// Create new array of double the length
			for (int i = 0; i < a.length; i++) {			// Copy the elements of a to the corresponding indexes of b
				b[i] = a[i];
			}
			a = b;											// Reassign a reference to b
		}
		a[length] = x;										// Place x at the end of the IAList
		length = length + 1;								// Increase length by 1

	}

	public void addBefore(int x) {				
		if (length >= a.length) {
			int[] b = new int [a.length * 2];				// Copy my items in the array, and shift the array elements forward one space
			for (int i = b.length - 1; i >= length; i--) { 
				b[i] = a[i - a.length];
				shift = i - 1;
			}
			a = b;
		}
		a[shift] = x;
		length = length + 1;
	}
}
