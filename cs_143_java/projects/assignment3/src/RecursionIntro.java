// Name: Kevin Chung (CS143 - Winter 2021)

public class RecursionIntro {

    public static long eduodd(long n) {
        if (n < 0) {
            return -eduodd(-n);
        } else if (n < 10 && n % 2 == 0) { // even up
            return (n + 1) % 10;
        } else if (n < 10 && n % 2 == 1) { // odd down
            return (n - 1) % 10;
        } else {
            return 10 * eduodd(n / 10) + (n + 1) % 10;
        }
    }

    public static int fibby(int n) {
        return 0;
    }

    public static void printSparseTable(int start, int end) {

    }

    private static void printSparseTable(int start, int end, int fibby) {

    }

    public static int lp2lt(int n) {
        return 0;
    }

    public static int champion(boolean[] a) {
        return 0;
    }
    
}
