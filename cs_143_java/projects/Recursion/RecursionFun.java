public class RecursionFun {
    public static void main(String[] args) {
        System.out.println(countOnes(1111));
        System.out.println(countOnes(1));
        System.out.println(countOnes(-1));
        System.out.println(countOnes(0));
        System.out.println(countOnes(-121));
        System.out.println(countOnes(2131415));
    }

    public static int countOnes(int n) {
        if (n < 0) {
            return countOnes(-n);
        } else if (n % 10 == 1) {
            return 1 + countOnes(n / 10);
        } else if (n > 0) {
            return countOnes(n / 10);
        } else {
            return 0;
        }
    }

    public static int mystery(int a) {
        if (a < 0)
            return mystery(-a);
        if (a == 0)
            return 0;
        return a % 10 + mystery(a / 10);
    }
}
