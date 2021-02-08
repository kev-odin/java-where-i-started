// Name: Kevin Chung (CS143 - Winter 2021)

public class RecursionIntro {

    public static long eduodd(long n) { // need help
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
        if (start <= end) { // prev fibby number has been printed, continue method call
            if (prevFib == fibby(start)) {
                prevFib = fibby(start);
                start++;
                printFibPair(start, end, prevFib);
            } else { // fibby pair has not been printed, print, anc continue method call
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
        return battle(a, 0, a.length - 1, 0);
    }

    private static int battle(boolean[] a, int start, int end, int winner) {
        // base case, when the array length is only 1

        if (a.length >= 1) {
            end = lp2lt(a.length);
            battle(a, start, end, winner);
        } else if (a.length == 1) {
            return winner;
        } else if (a.length == 2) {

        }

        if (a.length == 1) {
            return winner;
        } else if (a[0] != a[1]) {
            return winner;
        } else {
            winner++;
            return winner;
        }
    }
}
