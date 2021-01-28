public class Fibonacci {
    public static void main(String[] args) {
        // slow algorithm works fine for these
//        for(int i = 0; i <= 10; i++){
//            System.out.println(i + ": " + fib(i));
//        }
        System.out.println(fibA(100));
    }

    /**
     * Compute the nth fibonacci number
     * @param n
     * @return
     */
    public static long fib(int n){
        // base case n = 1 or n = 0
        if(n == 0 || n == 1){
            return 1;
        }
        else{
            return fib(n - 1) + fib(n - 2);
        }
    }

    // storage for fibonacci numbers (cache)
    private static long[] fibA = new long[1000];
    /**
     * Compute the nth fibonacci number (fast version that stores previously calculated numbers in an array)
     * only work for the first 1000 fibonacci numbers
     * @param n
     * @return
     */
    public static long fibA(int n){
        // base case n = 1 or n = 0
        if(n == 0 || n == 1){
            return 1;
        }
        // has fibA(n) already been calculated?
        // if fibA[n] in the array is a zero, we know that fibA(n) has not been calculated
        // if fib[n] > zero, we know that fibA(n) has been calculated
        if(fibA[n] > 0){
            // this fibonacci number has already been calculated, return the stored value!
            return fibA[n];
        }
        else{
            // this fibonacci number has not been calculated yet (array element at n is zero)
            // calculate it, store it in the array, then return it
            fibA[n] = fibA(n - 1) + fibA(n - 2); // storing the number for future calculations
            return fibA[n];
        }
    }
}
