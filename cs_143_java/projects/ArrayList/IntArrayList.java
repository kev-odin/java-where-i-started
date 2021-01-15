import java.util.Arrays;
/*
 * Our own simplified ArrayList
 *  it will only be able to store integers
 *  it will only have a subset of the methods ArrayLists have
 */
public class IntArrayList {

    private int[] a; // internal array to be used as storage for our IntArrayList

    /**
     * Constructor to create an empty IntArrayList
     */
    public IntArrayList() {
        a = new int[0];
    }

    /**
     * Put a new integer at the end of the IntArrayList Use the array copying
     * approach we discussed on 1/13 to add a new integer to the underlying array
     * 
     * @param thing
     */
    public void add(int thing) {
        // first, lets create a new array to be of length a.length + 1 so we have space
        // to add "thing" to the end
        int[] b = new int[a.length + 1];
        // Use a loop to manually copy everything from a into b
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i]; // copy the value at index i from a to b
        }
        // add the int "thing" to the end of the underlying array
        b[b.length - 1] = thing;
        // update the reference (array property) to be the new bigger array
        a = b;
    }

    /**
     * Return the number of things in the IntArrayList (how many things have been
     * added?)
     * 
     * @return
     */
    public int size() {
        return a.length;
    }

    /**
     * Retrieve a int that has been added to the underlying array
     * 
     * @param i index between 0 and size() - 1
     * @return
     */
    public int get(int i) {
        // check if the index is not a valid index, because if it isn't we can't
        // retrieve the stored int
        if (i < 0 || i >= size()) {
            // invalid index (we cannot output an int, does not exist)
            throw new IndexOutOfBoundsException();
        }
        // otherwise, the index represents a valid spot in the list, return the value
        return a[i];
    }

    @Override
    public String toString() {
        // use the built in Arrays.toString static method to convert our IntArrayList
        // into a String
        return Arrays.toString(a);
    }
}
