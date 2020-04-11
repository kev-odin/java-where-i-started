
// Kevin Chung
/*
Chocolate chip cookie recipe (4 dozen = 48 cookies)			Banana bread recipe (1 loaf)			Store Prices 										Conversions
2 1/4 cups of all purpose flour								1 1/2 cups of all purpose flour			5 lb of all purpose flour in a bag for $1.79		3 1/3 cups of flour are in 1 lb
1 tsp of salt												1/8 tsp of salt							26 oz container of salt for $1.09					6 tsp of salt or baking soda are in 1 oz
1 tsp of baking soda										1 tsp of baking soda					16 oz box of baking soda for $1.09					6 tsp of salt or baking soda are in 1 oz
1 tsp of vanilla extract									1 tsp of vanilla extract				1 liquid ounce of vanilla extract for $3.99			6 tsp of vanilla extract in 1 liquid ounce
2 eggs														1 eggs									1 dozen eggs for $2.19								
1 1/2 cups of sugar											3/4 cups of sugar						1 lb bag of sugar for $1.99							2 cups of sugar are in 1 lb
1 cup (2 sticks) of butter									1/3 cup of butter						1 lb (4 sticks) package of butter for $4.49			* 2 sticks of butter are in 1 cup
0 bananas													3 bananas								1 banana for $0.32									
2 1/2 cups of chocolate chips								0 cups of chocolate chips				12 oz (2 cups) bag of chocolate chips for $3.29		

cookieCount defines the individual number of cookies that you want to make.

Plan of attack: input the 


*/

public class BakingCalculator {

	public static void main(String [] args) {
		// Quick test main
		System.out.println(bagsOfFlour(1, 1));
	}

	public static int bagsOfFlour(int cookieCount, int loafCount) {
		double cookieAmount = (double) (cookieCount * (2.25 / 48.0));
		double cupsForCookies = cupsToPound(cookieAmount);
		System.out.print(cupsForCookies);
		return 0;
	}

	public static int containersOfSalt(int cookieCount, int loafCount) {
		return 0;
	}

	public static int boxesOfBakingSoda(int cookieCount, int loafCount) {
		return 0;
	}

	public static int bottlesOfVanilla(int cookieCount, int loafCount) {
		return 0;
	}

	public static int cartonsOfEggs(int cookieCount, int loafCount) {
		return 0;
	}

	public static int bagsOfSugar(int cookieCount, int loafCount) {
		return 0;
	}

	public static int packagesOfButter(int cookieCount, int loafCount) {
		return 0;
	}

	public static int bananas(int cookieCount, int loafCount) {
		return 0;
	}

	public static int bagsOfChocolateChips(int cookieCount, int loafCount) {
		return 0;
	}

	public static double totalCost(int cookieCount, int loafCount) {
		return 0;
	}

	// flour cups to pounds conversion
	public static double cupsToPound (double cupsAmount) {
		double poundAmount = cupsAmount / (10.0 / 3.0);
		return poundAmount; 
	}
	
	// teaspoon to ounces conversion
	public static double tspToOunces (double tspAmount) {
		double ouncesAmount = tspAmount * 6.0;
		return ouncesAmount;
	}


}
