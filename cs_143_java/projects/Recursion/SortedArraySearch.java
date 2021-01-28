public class SortedArraySearch {
    public static void main(String[] args) {
        int[] a = new int[1000000]; // create an array of 1 million ints
        for (int i = 1; i < 1000000; i++) {
            a[i] = a[i-1] + (int)(Math.random()*3); // each element is the previous element + 0, 1, or 2
        }

        long start = System.currentTimeMillis();
        // lets search for the values between 0 and 9999 and see how long it takes
        for(int x = 0; x < 10000; x++){
            //find(a, x);
            binarySearch(a, x);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);

//        int[] a = {-5, 0, 2, 3, 4, 8, 15, 25, 27};
//        System.out.println(binarySearch(a, 20));
    }

    /**
     *  Returns the first index that x occurs at in the SORTED array a
     *  Returns -1 if x is not present
     * @param a
     * @param x
     * @return
     */
    public static int find(int[] a, int x){
        // loop through the array
        for(int i = 0; i < a.length; i++){
            // are we looking at x?
            if(a[i] == x){
                return i;// return the index!
            }
            if(a[i] > x){
                return -1; // x isn't there, because of the assumption that the array is sorted
            }
        }
        // if we terminate the loop without finding x, x does not exist
        return -1;
    }

    /**
     * Returns an index that x occurs at in the SORTED array a
     * Returns -1 if x is not present
     * @param a
     * @param x
     * @return
     */
    public static int binarySearch(int[] a, int x){
        // hand off the work to the private method
        return binarySearch(a, x, 0, a.length - 1);
    }

    private static int binarySearch(int[] a, int x, int start, int end){
        // invalid range
        if(start > end){
            return -1;
        }
        // calculate the middle index (middle of the start to end range)
        int mid = (start + end) / 2;
        // what value is stored at that middle index?
        int y = a[mid];
        // is x equal to y (we found what we are searching for!)
        if(x == y){
            return mid; // found x!
        }
        // is x less than y (look in the left half)
        else if(x < y){
            // recursively search in the left half
            return binarySearch(a, x, start, mid - 1);
        }
        // is x greater than y (look in the right half)
        else{ // x > y
            // recursively search in the right half
            return binarySearch(a, x, mid + 1, end);
        }
    }
}
