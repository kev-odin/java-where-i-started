public class RecursionMain {
    public static void main(String[] args) {
        boolean test[] = {false, false, false};
        //boolean test[] = {true, false, false, true, false, false}; // false is tails, true is heads (83/100)
        //boolean test[] = {false, false, true, false, true, true, true, false, true}; // OneNote example
        //boolean test[] = {false, true, false, false, true, false, true, false}; //kevin.pdf
        System.out.println(champion(test));
    }

    public static int champion(boolean[] a) {
        return battle(a, 0, a.length - 1);
    }

    private static int battle(boolean[] a, int start, int end) {
        int length = (end - start) + 1; // length of the section
        battleStats(start, end, length);

        if (start == end) { // start and end are the same, only one person in arena - base case
            return start;
        } else if (end - start == 1) { // start and end are next to each other - base case
            if (a[start] == a[end]) { // same coin
                return end;
            }
            return start; // different coin

        } else { // (end - start > 1)
            // (first portion has length lp2lt(size of current portion))
            int leftEnd = start + lp2lt(length) - 1;
            // (second portion is everyone else in the group)
            int rightStart = start + lp2lt(length);
            // Then you have two recursive calls, one where you pass in the start and end indices of the first group,
            int winnerLeft = battle(a, start, leftEnd);
            // one where you pass in the start and end indices of the second group.
            int winnerRight = battle(a, rightStart, end);
            // Then once you have recursively computed the winners of the two groups, compare them using the rules to get a final winner.

            if (a[winnerLeft] == a[winnerRight]) {
                return winnerRight;
            }
            return winnerLeft;
        }
    }

    public static void battleStats(int start, int end, int length) {
        System.out.println("The start index is: " + start);
        System.out.println("The end index is: " + end);
        System.out.println("The length of this portion is: " + length);
    }

    public static long eduodd(long n) { // DONE
        if (n < 0) {
            return -eduodd(-n);
        } else if (n < 10) {
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
