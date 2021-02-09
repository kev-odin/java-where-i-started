// Name: Kevin Chung (CS143 - Winter 2021)

public class RecursionIntro {

    public static long eduodd(long n) { // DONE
        if (n < 0) {
            return -eduodd(-n);
        } else if (n < 10) { // base case, single digit
            if (n % 2 == 0) {
                return (n + 1) % 10;
            } else {
                return (n - 1) % 10;
            }
        } else {
            if (n % 2 == 0) {
                return 10 * eduodd(n / 10) + (n + 1) % 10;
            } else {
                return 10 * eduodd(n / 10) + (n - 1) % 10;
            }
        }
    }

    public static int fibby(int n) { // DONE
        if (n == 0) { // base case
            return 1;
        } else {
            return fibby(n / 3) + fibby((2 * n) / 3);
        }
    }

    public static void printSparseTable(int start, int end) { // DONE
        printFibPair(start, end, 0);
    }

    private static void printFibPair(int start, int end, int prevFib) { // DONE
        if (start <= end) { // prev fibby number has been printed, and continue method call
            if (prevFib == fibby(start)) {
                prevFib = fibby(start);
                start++;
                printFibPair(start, end, prevFib);
            } else { // fibby pair has not been printed, print, and continue method call
                System.out.println(start + " " + fibby(start));
                prevFib = fibby(start);
                start++;
                printFibPair(start, end, prevFib);
            }
        }
    }

    public static int lp2lt(int n) { // DONE
        if (n == 2) { // base case
            return 1;
        } else if (n > 2 && n % 2 == 0) { // even case
            return 2 * lp2lt(n / 2);
        } else { // odd case
            return 2 * lp2lt((n + 1) / 2);
        }
    }

    public static int champion(boolean[] a) {
        return battle(a, 0, a.length - 1, 0);
    }

    private static int battle(boolean[] a, int start, int end, int winner) {
    // base case, when the array length is only 1
    return 99;
    }
}
