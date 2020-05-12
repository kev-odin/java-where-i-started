public class PracticeLoops {
    public static void main (String[] args) {
        int stars = 24;
        for (int row = 0; row <= stars; row++) {
            for (int col = 0; col <= stars ; col++) {
                if (row * col == stars) {
                    if (row == col - 2) {
                        System.out.println(row);
                        System.out.println(col);
                    }
                }
            }
        }
    }
}