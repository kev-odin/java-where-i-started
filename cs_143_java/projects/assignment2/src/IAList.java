// Name: Kevin Chung (CS143 - Winter 2021)

public class IAList {
	private int[] a; // Underlying array
	private int length; // Number of added elements in a
	private int header; // Start position of data

	public IAList() { 
		a = new int[4];
		length = 0;
		header = 0;
	}

	public void add(int x) { // Add an element to the end, O(n) for n
		if (length + header >= a.length) {
			int[] b = new int[a.length * 2];
			for (int i = header; i < a.length; i++) { // Copy the elements of a to the corresponding indexes of b
				b[i] = a[i];
			}
			a = b;
		}
		a[length + header] = x; // Place x at the end of continuous data
		length++;
	}

	public void addBefore(int x) {
		if (length >= a.length || header == 0) { // No space availible for addBefore OR at the start
			int[] b = new int[a.length * 2];
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

	public int get(int i) {
		if (i < 0 || i >= length) { //(Retrieve an added element, O(1))
			throw new IndexOutOfBoundsException(i + "");
		} else {
			i = i + header;
		}
		return a[i];
	}

	public void set(int i, int x) {
		// (Modify an existing element, O(1))
		if (i < 0 || i >= a.length) {
			throw new IndexOutOfBoundsException(i + "");
		} else {
			i = i + header;
		}
		a[i] = x;
	}

	public int size() {
		return length;	//(Number of added elements, O(1))
	}
}