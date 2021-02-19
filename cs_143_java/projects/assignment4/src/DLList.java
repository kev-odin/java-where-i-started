import java.util.Iterator;

/**
 * A class representing a double linked list.
 * 
 * PLEASE DO NOT COPY THIS FILE TO OTHER STUDENTS OR TO WEBSITES LIKE CHEGG,
 * GITHUB, ETC WHERE OTHERS MAY VIEW IT!!! IT IS YOUR WORK AND YOU SHOULD BE
 * PROUD OF WHAT YOU HAVE ACCOMPLISHED! IN ADDITION, THIS FILE CONTAINS THE
 * COPYRIGHTED WORK OF MARTIN HOCK AND IS ONLY LICENSED FOR USE BY INDIVIDUAL
 * STUDENTS FOR NONPROFIT EDUCATIONAL PURPOSES.
 */
public class DLList<T> implements Iterable<T> {
	private static class Node<T> {
		// before is reference to adjacent node closer to first (or null if this node is
		// the first)
		// after is reference to adjacent node closer to last (or null if this node is
		// the last)
		public Node<T> before, after;
		// data is the information stored in the node of type T (T could be String,
		// Integer, etc.)
		public T data;

		public Node(Node<T> before, T data, Node<T> after) {
			this.before = before;
			this.after = after;
			this.data = data;
		}
	}

	// first is beginning node (no before), last is end node (no after)
	// They can both reference the same node if the list is one element long
	// The can both reference null if the list is empty
	private Node<T> first, last;
	private int size;

	/**
	 * Forward iterator class (conductor).
	 */
	private static class Conductor<T> implements Iterator<T> {
		public Node<T> car; // Next node to visit

		public Conductor(DLList<T> list) {
			car = list.first; // Begin at first
		}

		public boolean hasNext() {
			return car != null; // No more to visit
		}

		public T next() {
			T data = car.data; // Remember current
			car = car.after; // Advance to after car
			return data; // Return old car data
		}
	}

	public DLList() {
		first = last = null; // Empty list
	}

	/**
	 * Add data to the end (last) of the list.
	 * Size is recorded with increment operator to update.
	 */
	public void add(T data) {
		if (last == null) {
			// Empty list: one node is first and last
			size++;
			first = new Node<>(null, data, null);
			last = first;
		} else {
			size++;
			last.after = new Node<>(last, data, null);
			last = last.after;
		}
	}

	/**
	 * Retrieve an element from middle of list.
	 * 
	 * @param i Zero-based index of element
	 * @return The element at that index
	 * @throws IndexOutOfBoundsException if i is invalid
	 */
	public T get(int i) {
		if (i < 0) {
			throw new IndexOutOfBoundsException();
		}
		Node<T> current = first;
		for (int j = 0; current != null && j < i; j++) {
			// Count our way up to desired element
			current = current.after;
		}
		if (current == null) {
			throw new IndexOutOfBoundsException();
		}
		return current.data;
	}

	/**
	 * Get and remove element i from the list.
	 * 
	 * @param i Zero-based index of element
	 * @return The element at that index
	 * @throws IndexOutOfBoundsException if i is invalid
	 */
	public T remove(int i) {
		if (i < 0) throw new IndexOutOfBoundsException();
		
		Node<T> current = first;
		for (int j = 0; current != null && j < i; j++) {
			// Count our way up to desired element
			current = current.after;
		}
		if (current == null) throw new IndexOutOfBoundsException();
		size--;

			if (current.before != null) {
			// Link before's after to new after
			// (The node after the node before the current node
			// becomes the node after the current node)
			current.before.after = current.after;
		} else {
			// current must be first, so first should refer to
			// the node after it to stop referencing current
			first = first.after;
		}
		if (current.after != null) {
			// Link after's before to new before
			// (The node before the node after the current node
			// becomes the node before the current node)
			current.after.before = current.before;
		} else {
			// current must be last, so last should refer to
			// the node before it to stop referencing current
			last = last.before;
		}
		return current.data;
	}

	/**
	 * Create a forward iterator for this list.
	 * 
	 * @return iterator that walks from first to last
	 */
	public Iterator<T> iterator() {
		// The Conductor object can walk this list
		// forward, front to back. Each time
		// .next() is called, the Conductor
		// produces one more piece of data,
		// starting with first and ending with last
		return new Conductor<T>(this);
	}

	private static class BackwardConductor<T> implements Iterator<T> {
		public Node<T> cart; // Next node to visit

		public BackwardConductor(DLList<T> list) {
			cart = list.last; // Begin at first
		}

		public boolean hasNext() {
			return cart != null; // No more to visit
		}

		public T next() {
			T data = cart.data; // Remember current
			cart = cart.before; // Advance to before cart
			return data; // Return old car data
		}
	}

	/**
	 * Create a reverse iterator for this list.
	 * 
	 * @return iterator that walks from last to first
	 */
	public Iterator<T> descendingIterator() {
		return new BackwardConductor<T>(this);
	}

	/**
	 * Retrieve the number of nodes of this list in O(1) time.
	 * Maintains the size property as nodes are changed with add and remove methods.
	 * 
	 * @return number of nodes
	 */
	public int size() {
		return size; // TODO: Fix this!
	}

	/**
	 * Reverse the list, so that what was the last is now the first, and so forth. A
	 * list going A <-> B <-> C <-> D would now go D <-> C <-> B <-> A.
	 */
	public void reverse() {
		// TODO: Write this method!
	}

	/**
	 * Add data to a new node at index i, causing the nodes at that index and after
	 * to be one place ahead of where they were in the list. (Do nothing if i was
	 * not a valid index in the list.)
	 * 
	 * @param i    existing index in the list
	 * @param data information to add into a new node
	 * @return false if i is not an index in the list, true otherwise
	 */
	public boolean add(int i, T data) {
		return false; // TODO: Fix this!
	}
}
