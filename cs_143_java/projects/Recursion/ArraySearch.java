public class ArraySearch {
    public static void main(String[] args) {
        int[] a = {10, -5, 17, 6, 17};
        System.out.println(find(a, 17));
        System.out.println(find(a, 1));
    }

//    /**
//     * Returns the first index that x occurs at in the array a
//     * Returns -1 if x is not present
//     * @param a
//     * @param x
//     * @return
//     */
//    public static int find(int[] a, int x){
//        // loop through the array
//        for(int i = 0; i < a.length; i++){
//            // are we looking at x?
//            if(a[i] == x){
//                return i;// return the index!
//            }
//        }
//        // if we terminate the loop without finding x, x does not exist
//        return -1;
//    }


    /**
     * O(n): see notes
     * Returns the first index that x occurs at in the array a
     * Returns -1 if x is not present
     * @param a
     * @param x
     * @return
     */
    public static int find(int[] a, int x){
        // since we aren't using a loop, we do not automatically have
        // access to a loop counter variable that keeps track of the index we are on
        // in the search (no i variable)
        // we could create a helper method that takes an index as a parameter
        // use the helper method to do all the work
        return find(a, x, 0);
    }

    /**
     * Returns -1 if i is an invalid index
     * Returns i if a[i] == x
     * Otherwise, recursively calls find for the next index
     * @param a
     * @param x
     * @param i
     * @return
     */
    private static int find(int[] a, int x, int i){
        // check for invalid index
        if(i < 0 || i >= a.length){
            return -1;
        }
        // check if index i contains an x
        if(a[i] == x){
            return i;
        }

        // if neither of the above are true, hand off the work to a
        // recursive call to check the next index
        return find(a, x, i + 1);
    }
}
