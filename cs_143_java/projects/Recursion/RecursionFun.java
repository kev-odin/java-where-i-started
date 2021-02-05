public class RecursionFun {
    public static void main(String[] args) {
        System.out.println(mystery(10));
        System.out.println(mystery(15));
        System.out.println(mystery(25));
        System.out.println(mystery(-14));


    }

    public static int mystery(int a) {
        if (a < 0) return mystery(-a);
        if (a == 0) return 0;
        return a % 10 + mystery(a/10);
      }
}
