

public class TryCatch {
    public static void main(String[] args) {
        int[] a = {1, 2, 3};
        System.out.println(a.toString());

        try {
            a[3] = 10;
        } catch(ArrayIndexOutOfBoundsException e) {
            for(int i = 0; i < a.length; i++) {
                a[i] = 0;
            }
            System.out.println("Array OoB");
        } finally {
            System.out.println(a.toString());
        }
    }
}
