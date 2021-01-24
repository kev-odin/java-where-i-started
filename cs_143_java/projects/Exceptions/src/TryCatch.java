public class TryCatch {
    public static void insertIntoArray(int[] array, int count, int index, int element) {
        if (count >= array.length || index >= array.length || index < 0) return;
        
        for(int i = array.length - 1; i > index; i--) {
            array[i] = array[i - 1];
        }
        
        array[index] = element;
    }

    public static void main(String[] args) {

        int[] array1 = {0, 0};
        int[] array2 = {0, 2, 3, 4, 0};
        //insertIntoArray([0],0,0,1);// OK
        //insertIntoArray([0],1,0,1);// OK
        //insertIntoArray([0],0,1,1);// OK
        //insertIntoArray([0,0],0,0,2);// OK
        //insertIntoArray([0,0],0,-1,2);// OK
        //insertIntoArray([1,0],1,-1,2);// OK
        //insertIntoArray(array,1,0,2);// modified array to [2,0] expected [2,1]
        //insertIntoArray([0,0],2,0,2);// OK
        insertIntoArray(array1,0,1,2);// modified array to [0,2] expected [0,0]
        //insertIntoArray([1,0],1,1,2);// OK
        //insertIntoArray([0,2,3,4,0],4,0,0);// modified array to [0,2,3,4,0] expected [0,0,2,3,4]
        insertIntoArray(array2,4,1,0);// modified array to [0,0,3,4,0] expected [0,0,2,3,4]
        //insertIntoArray([0,2,3,4,0],4,2,0); 
    }
}
