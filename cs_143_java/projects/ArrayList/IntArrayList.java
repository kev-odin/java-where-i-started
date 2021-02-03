import java.util.Arrays;

/*
 * Our own simplified ArrayList
 *  it will only be able to store integers
 *  it will only have a subset of the methods ArrayLists have
 */
public class IntArrayList {

    private int[] a; // internal array to be used as storage for our IntArrayList
    private int n; // the number of integers that have been added to the IntArrayList

    /**
     * Constructor to create an empty IntArrayList
     */
    public IntArrayList(){
        a = new int[4];
        n = 0; // nothing has been added yet
    }

    /**
     * Put a new integer at the end of the IntArrayList
     * Use the array copying approach we discussed on 1/13 to add a new integer to the underlying array
     * @param thing
     */
    public void add(int thing){

        // have we reached the capacity of the underlying array?
        if(n == a.length) { // constant time (comparing two numbers)
            // we are out of space and need to make a bigger array and copy

            // first, lets create a new array to be of length a.length + 1 so we have space to add "thing" to the end
            int[] b = new int[a.length * 2];
            // Use a loop to manually copy everything from a into b
            // non-constant time (amount of time depends on the length of the array)
            for (int i = 0; i < a.length; i++) {
                b[i] = a[i]; // copy the value at index i from a to b
            }
            // update the reference (array property) to be the new bigger array
            a = b; // constant time
        }
        // n refers to the first unused location in the array (the location immediately after all the data added)
        a[n] = thing; // constant time
        // since we added another integer, update n to reflect that
        n++; // constant time
    }

    /**
     * Return the number of things in the IntArrayList (how many things have been added?)
     * @return
     */
    public int size(){
        return n; // n is variable that now tells us how many elements have been added
    }

    /**
     * Retrieve a int that has been added to the underlying array
     * @param i index between 0 and size() - 1
     * @return
     */
    public int get(int i){
        // check if the index is not a valid index, because if it isn't we can't retrieve the stored int
        if(i < 0 || i >= n){
            // invalid index (we cannot output an int, does not exist)
            throw new IndexOutOfBoundsException();
        }
        // otherwise, the index represents a valid spot in the list, return the value
        return a[i];
    }

    /**
     * Sets the element at index i in the IntArrayList to the new value v (if index i exists)
     * @param i
     * @param v
     */
    public void set(int i, int v){
        // check if the index is not a valid index, because if it isn't we can't change the value
        if(i < 0 || i >= n){
            // invalid index (we cannot output an int, does not exist)
            throw new IndexOutOfBoundsException();
        }
        // otherwise, the index represents a valid spot in the list, update that value to v
        a[i] = v;
    }

    @Override
    public String toString() {
        int[] copy = Arrays.copyOf(a, n); // n is the length of the data without the extra space
        // use the built in Arrays.toString static method to convert our IntArrayList into a String
        return Arrays.toString(copy);
    }
}
