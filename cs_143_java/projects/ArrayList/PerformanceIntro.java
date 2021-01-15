public class PerformanceIntro {
    public static void main(String[] args) {
        // int[] a1 = {1, 2, 3};
        // System.out.println(sum(a1));

        for (int i = 1_000_000; i < 10_000_000; i = i * 2) {
            int[] a = new int[i]; // array of zeros of length i
            long totalTime = 0;
            int trials = 100;
            for (int j = 0; j < trials; j++) {
                // ask for the time in milliseconds before sum executes
                long start = System.currentTimeMillis();
                // call the sum method
                int sum = sum(a);
                // ask for the time in milliseconds after sum executes
                long end = System.currentTimeMillis();

                totalTime = totalTime + end - start;
            }
            // average time of all the trials is the total time / the number of trials
            System.out.println(i + ": " + ((double) totalTime / trials) + " ms");
        }

    }

    /**
     * returns the sum of all the integers in array a
     * 
     * @param a
     * @return
     */
    public static int sum(int[] a) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum = sum + a[i]; // add each stored integer to the sum one by one
        }
        return sum;
    }

}
