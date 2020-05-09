public class PracticeLoops {
    public static void main(String[] args) {
        for (int i = 0; i <= 10; i++) {
            System.out.println(i);
            for (int j = i; j > 0; j--){
                System.out.print(j + " ");
            }
        }
    }
}