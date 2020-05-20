import java.util.Scanner;

public class ArrayPractice {
    public static void main(String[] args) {
        // Create the scanner
        Scanner inputScan = new Scanner(System.in);
        double root = rootCalculator(inputScan);
        System.out.println("The square root is: " + root);
    }

    public static double rootCalculator(Scanner s) {
        while (true) {
            System.out.println("Please enter a non-negative number: ");

            if (s.hasNextDouble()) {
                double input = s.nextDouble();
                s.nextLine(); // clears out input after retrieving what we want
                if (input >= 0) {
                    return Math.sqrt(input);
                } else {
                    System.out.println("That number is negative. Try again.");
                }
            } else {
                s.nextLine(); // clear out invalid input before entering the loop
                System.out.println("Invalid Input. Try again.");
            }
        }
    }
}