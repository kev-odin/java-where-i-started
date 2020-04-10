// Short Assignment 1

/* Recipe for two dozen of Jon's Famous Cornbread Dumplings:
 *  2/3 cup whole wheat flour
 *  2/3 cup white flour
 *  1 cup corn flour
 *  1/2 teaspoon salt
 *  2 1/4 cups soy milk
 */

/* Fill in the following methods to scale the recipe from two dozen to any number of dozens.
 * 
 * All flours cost 35 cents per pound, salt costs nothing.
 * Milk comes in cartons of four cups each, and each carton costs $2.50
 * 
 * Print out the scaled recipe, with the amount of each ingredient on a different line.
 * Then print out the total cost of all the ingredients on a separate line. An unrounded amount of cents is fine.
 * Comment your code as appropriate.
 * Complete the extra credit if desired.
 */

public class DumplingCalculator {
	
	// recipe for single dozen dumplings of Jon's Cornbread
	public static double wholeWheatFlour = (2.0 / 3.0) / 2.0;
	public static double whiteFlour = (2.0 / 3.0) / 2.0;
	public static double cornFlour = (1.0) / 2.0;
	public static double salt = (1.0 / 2.0) / 2.0;
	public static double soyMilk = (2.25) / 2.0;
	
	// calculate the cups of whole wheat flower
	public static double cupsWholeWheat(double dozenDumplings) {
		double amount = wholeWheatFlour * dozenDumplings;
		return amount;
	}
	
	// calculate the cups of white flower
	public static double cupsWhite(double dozenDumplings) {
		double amount = whiteFlour * dozenDumplings;
		return amount;
	}
	
	// calculate the cups of corn flour
	public static double cupsCorn(double dozenDumplings) {
		double amount = cornFlour * dozenDumplings;
		return amount;
	}
	
	// calculate the cups of salt
	public static double tspSalt(double dozenDumplings) {
		double amount = salt * dozenDumplings;
		return amount;
	}
	
	// calculate the cups of milk
	public static double cupsMilk(double dozenDumplings) {
		double amount = soyMilk * dozenDumplings;
		return amount;
	}
	
	// calculate the cartons of milk, partial count is rounded up for the whole number
	public static int cartonsMilk(double cupsMilk) {
		double cartonCount = (double) (cupsMilk / 4.0);
		double roundCount = Math.ceil(cartonCount);
		return (int) roundCount;
	}
	
	public static double totalCost(double dozenDumplings) { 
		return 0.0;
	}
	
	public static void main(String[] args) {
		/*Give dd (for "dozen dumplings") a value to test your program. I would start with 
		dd = 2.0 and see if you get the given recipe back. Then try a larger amount and a smaller one.
		*/
		double dd = 2.0;
		// ingredient costs:
		double costFlourPerCup = 35;
		double costMilkPerCarton = 250;
		double flourCost = (cupsWholeWheat(dd) + cupsWhite(dd) + cupsCorn(dd)) * costFlourPerCup;
		double milkCost = cartonsMilk(cupsMilk(dd)) * costMilkPerCarton;

		// testing zone
		System.out.println("For " + dd + " dozen dumplings, you will need: ");
		System.out.println(cupsWholeWheat(dd) + " cups of whole wheat flour");
		System.out.println(cupsWhite(dd) + " cups of white flour");
		System.out.println(cupsCorn(dd) + " cups of corn flour");
		System.out.println(tspSalt(dd) + " tsp of salt");
		System.out.println(cupsMilk(dd) + " cups of soy milk");
		System.out.println(cartonsMilk(cupsMilk(dd)) + " cartons of milk");
		System.out.println(flourCost + milkCost + " cents.");
	}
}