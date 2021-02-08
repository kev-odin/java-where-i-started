public class RecursionMain {
    public static void main(String[] args) {
        // System.out.println(eduodd(1)); // 0
        // System.out.println(eduodd(2)); // 3
        // System.out.println(eduodd(27)); // = 36
        // System.out.println(eduodd(987654321)); // = 896745230
        // System.out.println(eduodd(-11)); // = 0
        boolean test[] = { false, false }; // false is tails, true is heads
        champion(test);

    }

    public static int champion(boolean[] a) {
        return battle(a, 0, a.length - 1, 0);
    }

    private static int battle(boolean[] a, int start, int end, int winner) {
        // base case, when the array length is only 1
        if (a.length > 1) {
            end = lp2lt(a.length);
        } else if (a.length == 1) {
            winner = start;
            return winner;
        } else if (a.length == 2) {
            if (a[start] != a[end]) {
                winner = start;
                return winner;
            } else {
                winner = end;
                return winner;
            }
        } else {
            battle(a, start, end, winner);
        }
        return winner;
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

    public static int mystery(int n) { // eduodd part 1; what to do when n is even or odd
        if (n < 0) {
            return -mystery(-n);
        } else if (n < 10) { // base case, when n is less than 10, then mod will
            return (n + 1) % 10;
        } else {
            return 10 * mystery(n / 10) + (n + 1) % 10;
        }
    }

    public static long eduodd(long n) { // WIP
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
}
