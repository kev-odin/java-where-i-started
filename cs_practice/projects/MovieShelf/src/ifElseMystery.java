public class ifElseMystery {
    public static void main(String[] args) {
        mystery1(8); 	
        mystery1(-3); 	
        mystery1(1); 	
        mystery1(0);
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
}
