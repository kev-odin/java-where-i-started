// Name: Kevin Chung (CS143 - Winter 2021)

public class RecursionIntro {

    public static long eduodd(long n) {
        if (n < 0) {
            return -eduodd(-n); // if n is negative
        } else if (n > 10) {
            return 10 * eduodd(n / 10);
        } else if (n < 10) {
            if (n % 2 == 0) { 
                return (n + 1) % 10; // even numbers
            } else {
                return (n - 1) % 10; // odd numbers
            }
        }
        return n;
    }

    public static int fibby(int n) { // DONE
        // base case
        if (n == 0) {
            return 1;
        } else {
            return fibby(n / 3) + fibby((2 * n) / 3);
        }
    }

    public static void printSparseTable(int start, int end) { // DONE
        printFibPair(start, end, 0);
    }

    private static void printFibPair(int start, int end, int prevFib) { // DONE
        if (start <= end) {
            if (prevFib == fibby(start)) {
                prevFib = fibby(start);
                start++;
                printFibPair(start, end, prevFib);
            } else {
                System.out.println(start + " " + fibby(start));
                prevFib = fibby(start);
                start++;
                printFibPair(start, end, prevFib);
            }
        }
    }

    public static int lp2lt(int n) { // DONE
        // base case
        if (n == 2) {
            return 1;
        // even case
        } else if (n > 2 && n % 2 == 0) {
            return 2 * lp2lt(n / 2);
        // odd case
        } else {
            return 2 * lp2lt((n + 1) / 2);
        }
    }

    public static int champion(boolean[] a) {
        return 0;
    }
    
}
