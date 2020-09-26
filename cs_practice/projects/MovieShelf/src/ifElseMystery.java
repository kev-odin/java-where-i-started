public class ifElseMystery {
    public static void main(String[] args) {
        showTwos(7);
    }

    public static void showTwos(int x) {
        System.out.print(x + " = ");
        while (x > 0) {
            if (x % 2 == 1) {
                System.out.print(x + "\n");
            }
            x -= 2;
        }
    }

    public static void mystery1(int n) {
        System.out.print(n + " ");
        if (n > 0) {
            n = n - 5;
        }
        if (n < 0) {
            n = n + 7;
        } else {
            n = n * 2;
        }
        System.out.println(n);
    }

    public static int mystery2(int x) {
        int a = 1;
        int c = 0;
        while (x > 0) {
            a = x % 2;
            if (a == 1) {
                c++;
            }
            x = x / 2;
        }
        return c;
    }
}
