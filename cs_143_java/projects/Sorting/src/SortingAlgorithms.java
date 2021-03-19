import java.util.ArrayList;
import java.util.Arrays;

public class SortingAlgorithms {
    public static void main(String[] args) {
//        int[] a = {5, -3, 10, 4, 0, 2};
//        int index = findIndexOfSmallest(a, 0);
//        System.out.println(index);
//        // replace what is at a[0] with what is at a[index]
//        int temp = a[0];
//        a[0] = a[index];
//        a[index] = temp;
//        System.out.println(Arrays.toString(a));
//        index = findIndexOfSmallest(a, 1);
//        System.out.println(index);
//        // replace what is at a[1] with what is at a[index]
//        temp = a[1];
//        a[1] = a[index];
//        a[index] = temp;
//        System.out.println(Arrays.toString(a));

        int[] a = {5, -3, 10, 4, 0, 2};
        System.out.println(Arrays.toString(a));
        //selectionSort(a);
        insertionSort(a);
        System.out.println(Arrays.toString(a));
    }

    public static void selectionSort(int[] array){
        for(int i = 0; i < array.length - 1; i++){
            int indexOfSmallest = findIndexOfSmallest(array, i);// select correct element to go at index i
            int temp = array[i];
            array[i] = array[indexOfSmallest];
            array[indexOfSmallest] = temp;
        }
    }

    /**
     * Fubd the index of the smallest element in array starting at index start
     * @param array
     * @param start Starting index to look for the smallest element
     * @return
     */
    public static int findIndexOfSmallest(int[] array, int start){
        // smallest so far will start at index 0
        int indexOfSmallest = start;
        // go through the array looking for something smaller than a[0]
        for(int i = start + 1; i < array.length; i++){
            // if this element is less than the smallest element we have seen
            if(array[i] < array[indexOfSmallest]){
                // update the index to be the index of the smaller number (i)
                indexOfSmallest = i;
            }
        }
        return indexOfSmallest;
    }

    public static void insertionSort(int[] array){
        // idea: for each element, we will insert it into the proper place
        // in the portion of the array we have already sorted
        // skip the first thing because it is already sorted with respect to itself
        for(int i = 1; i < array.length; i++){
            // move array[i] backwards until it ends up where it needs to go
            // in other words, keep moving array[i] backwards until we see something
            // less than the element we are trying to insert

            // we could alternatively think of this as moving all the elements
            // greater than array[i] forward, then putting array[i] in the empty spot
            int elementToInsert = array[i];
            // start at index i - 1 and shift all the elements greater than elementToInsert forward by one
            // declare j outside the loop so we have access to it after the loop
            int j = i - 1;
            for(; j >= 0; j--){
                // if this element is greater than the element we are trying to insert
                if(array[j] > elementToInsert){
                    // shift array[j] forward
                    array[j + 1] = array[j];// move array[j] to the right, since it should go after elementToInsert
                }
                else{
                    // otherwise, array[j] is less than or equal to elementToInsert
                    // then we know elementToInsert should go after array[j], so
                    // we have found the insertion point
                    // stop the loop, since all the numbers greater than elementToInsert have been shifted
                    break;
                }
            }
            // after the inner loop is finished, j contains the index of the first number that was less than
            // elementToInsert, so we will insert elementToInsert at index j + 1
            // (it goes after the element that is less than it)
            array[j + 1] = elementToInsert;
        }
    }

    public static void mergeSort(int[] a) {
        // If our array has less than two things, it's already sorted.
        if (a.length < 2) return; // Done!
        if (a.length < 40) {
            // If the array is short enough, use a simpler sorting algorithm
            // What is the best length to switch? You'll have to experiment to find out.
            insertionSort(a);
            return;
        }
        // Break the array in half
        // Copy the array into two pieces
        int[] first = Arrays.copyOf(a, a.length / 2);
        mergeSort(first);
        int[] second = Arrays.copyOfRange(a, a.length / 2, a.length);
        mergeSort(second);
        // At this point, first and second are sorted
        // Merge the two copies back together into the original...
        // Then we're done!
        int firstI = 0, secondI = 0; // start with first elements of both arrays
        int ai = 0; // where to put the element
        while (firstI < first.length && secondI < second.length) {
            // As long as we have two things to compare...
            if (first[firstI] <= second[secondI]) {
                // Select the element in the first array
                a[ai] = first[firstI];
                firstI++;
            } else {
                a[ai] = second[secondI];
                secondI++;
            }
            ai++;
        }
        // At this point, we're done comparing but we have some leftovers
        // in exactly one list.
        if (firstI < first.length) {
            // Finish copying first array
            do {
                a[ai] = first[firstI];
                ai++;
                firstI++;
            } while (firstI < first.length);
        } else {
            // Finish copying second array
            do {
                a[ai] = second[secondI];
                ai++;
                secondI++;
            } while (secondI < second.length);
        }
    }
}
