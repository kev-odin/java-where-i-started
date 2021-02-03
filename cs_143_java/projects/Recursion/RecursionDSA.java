public class RecursionDSA {
    public static void main(String[] args) {
        // int[] array = { 1, 2, 6, 7, 5 };
        // System.out.println(largest(array, 0));
        // System.out.println(findLargest);
        // System.out.println(multiply(3, 3));
        // System.out.println(GCD(8, 12));
        // System.out.println(log(2, 2));
        // System.out.println(sumtoK(4));
        // System.out.println(addOdd(7));
    }

    /**
     * recursive solution for finding the largest integer in an unsorted array
     * 
     * @param numbers
     * @param index
     * @return largest element in an array
     */
    public static int largest(int[] numbers, int index) {
        if (index >= numbers.length - 1) {
            return numbers[index];
        } else if (numbers[index] > numbers[index + 1]) {
            numbers[index + 1] = numbers[index];
        }
        return largest(numbers, index + 1);
    }

    /**
     * recursive solution for finding the product of 2 integers
     * 
     * @param x
     * @param y
     * @return product of two integers
     */
    public static int multiply(int x, int y) {
        if (x == 1) {
            return y;
        } else {
            return multiply(x - 1, y) + y;
        }
    }

    /**
     * recursive solution for finding the greatest common demoninator (GCD) of two
     * integers
     * 
     * @param x
     * @param y
     * @return
     */
    public static int GCD(int x, int y) {
        if (y == 0) {
            return x;
        } else {
            return GCD(y, x % y);
        }
    }

    /**
     * recursive solution for finding log of any exponent (slow)
     * 
     * @param base
     * @param exponent
     * @return
     */
    public static int log(int base, int exponent) {
        if (exponent < 1) {
            return 1;
        } else {
            return base * log(base, exponent - 1);
        }
    }

    /**
     * recursive solution for finding the consecutive sum to the number
     * 
     * @param number
     * @return consecutive sums to the number
     */
    public static int sumtoK(int number) {
        if (number <= 0) {
            return 0;
        } else {
            return sumtoK(number - 1) + number;
        }
    }
    /**
     * 
     * @param number
     * @return
     */
    public static int addOdd(int number) {
        if (number <= 0) {
            return 0;
        }
        if (number % 2 != 0) { // Odd value
            return addOdd(number - 1) + number;
        } else { // Even value
            return addOdd(number - 1);
        }
    }
}
