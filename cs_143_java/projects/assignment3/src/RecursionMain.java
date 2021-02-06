public class RecursionMain {
    public static void main(String[] args) {
        System.out.println(mystery(-6));
        System.out.println(mystery(63));
        System.out.println(mystery(-763));
        System.out.println(mystery(8888));
        System.out.println(eduodd(27));         // = 36
        System.out.println(eduodd(987654321));  // = 896745230
        System.out.println(eduodd(-11));        // = 0

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

    public static long eduodd(long n) {
        if (n < 0) {
            return -eduodd(-n); // if n is negative
        } else if (n % 2 == 0 && n > 0) {
            return 10 * eduodd(n / 10) + (n + 1) % 10;
        } else {
            return 10 * eduodd(n / 10) + (n - 1) % 10;
        }
    }
}
