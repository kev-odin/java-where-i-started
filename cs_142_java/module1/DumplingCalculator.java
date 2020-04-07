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

	
	public static double cupsWholeWheat(double dozenDumplings) {
		return 0.0;
	}
	
	public static double cupsWhite(double dozenDumplings) {
		return 0.0;
	}
	
	public static double cupsCorn(double dozenDumplings) {
		return 0.0;
	}
	
	public static double tspSalt(double dozenDumplings) {
		return 0.0;
	}
	
	
	public static double cupsMilk(double dozenDumplings) {
		return 0.0;
	}
	// The amount (in cups) of milk shouldn't be too complicated, but the cartons of milk required
	// is a bit trickier. Remember you can use Math.ceil(number) to round a number up, and then 
	// you can cast it to an int.
	public static int cartonsMilk(double cupsMilk) {
		return 0;
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
		
		
	}
	


}
