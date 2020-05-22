import java.util.Scanner;

// Kevin Chung
public class YardSaleScanner {

	// In the main method, you should create a new scanner and call the yardSale
	// method to test your code.

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		double remainingBudget = yardSale(input, 50.75);
	}

	public static double yardSale(Scanner s, double money) {
		double spendyCash = 0.0;
		int quantity = 0;
		int totalQuantity = 0;

		// Money needs to be above $5.00 to keep the loop going
		while (money > 5.0) {
			// Asks the user the price of items at the yard sale.
			System.out.print("Price? ");
			spendyCash = s.nextDouble();

			// Asks the user the quantity you want to purchase.
			System.out.print("Quantity? ");
			quantity = s.nextInt();

			// Multiply the cost * quantity for total cost
			double finalCost = spendyCash * quantity;

			// Prevent a negative money value
			if ((money - finalCost) >= 0) {
				// Deal checker
				if (spendyCash < 10.00) {
					System.out.println("What a deal! I'll buy it.");
					totalQuantity += quantity;
					money -= finalCost;
				}
			}
			System.out.print("Remaining money: $" + money + "\n");
		}
		System.out.println("Total quantity purchased: " + totalQuantity);
		return money; // change this to the correct amount
	}
}
