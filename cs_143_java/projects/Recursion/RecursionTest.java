public class RecursionTest {

    public static void main(String[] args) {
        System.out.println(square(4));
        System.out.println(factorial(5));
        System.out.println(pow(2, 10));
        System.out.println(multiply(5, 5));
    }

    public static int multiply(int a, int b) {
        if (b == 0) {
            return 0;
        } else {
            return a + multiply(a, b - 1);
        }
    }

    /**
     * O(n) (see notes) computes the square of n recursively, assume n is positive
     * 
     * @param n
     * @return
     */
    public static int square(int n) {
        // base case 1^2 = 1
        if (n == 1) {
            return 1;
        } else {
            return square(n - 1) + 2 * n - 1;
        }
    }

    /**
     * O(n) (see notes) computes the factorial of n recursively, assume n is
     * positive
     * 
     * @param n
     * @return
     */
    public static int factorial(int n) {
        // base case: 1! = 1
        if (n == 1) {
            return 1;
        } else {
            // recursive call to reduce to a smaller problem
            return n * factorial(n - 1);
        }
    }

    /**
     * O(n) Recursively computes base to the power exponent assume exponent is
     * non-negative
     * 
     * @param base
     * @param exponent
     * @return
     */
    public static int pow(int base, int exponent) {
        // base case, anything raised to the 0 power is 1
        if (exponent == 0) {
            return 1;
        } else {
            // reducing to a smaller problem (approach the base case)
            return base * pow(base, exponent - 1);
        }
    }

}
