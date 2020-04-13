
// Kevin Chung
/*
Chocolate chip cookie recipe (4 dozen = 48 cookies)			Banana bread recipe (1 loaf)			Store Prices 										Conversions
2 1/4 cups of all purpose flour								1 1/2 cups of all purpose flour			5 lb of all purpose flour in a bag for $1.79		3 1/3 cups of flour are in 1 lb
1 tsp of salt												1/8 tsp of salt							26 oz container of salt for $1.09					6 tsp of salt or baking soda are in 1 oz
1 tsp of baking soda										1 tsp of baking soda					16 oz box of baking soda for $1.09					6 tsp of salt or baking soda are in 1 oz
1 tsp of vanilla extract									1 tsp of vanilla extract				1 liquid ounce of vanilla extract for $3.99			6 tsp of vanilla extract are in 1 liquid ounce
2 eggs														1 eggs									1 dozen eggs for $2.19								
1 1/2 cups of sugar											3/4 cups of sugar						1 lb bag of sugar for $1.99							2 cups of sugar are in 1 lb
1 cup (2 sticks) of butter									1/3 cup of butter						1 lb (4 sticks) package of butter for $4.49			* 2 sticks of butter are in 1 cup
0 bananas													3 bananas								1 banana for $0.32									
2 1/2 cups of chocolate chips								0 cups of chocolate chips				12 oz (2 cups) bag of chocolate chips for $3.29		

cookieCount defines the individual number of cookies that you want to make.

Plan of attack: input the 


*/

public class BakingCalculator {

	public static int bagsOfFlour(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double cupsFlourPer48Cookies = 2.25 / 48.0;
		double cupsFlourPerBananaLoaf = 1.5 / 1.0;

		// Calculate cups of flour needed per every batch order of baked items and convert cup to pounds of flour
		double cookieCupAmount = (double) (cookieCount * cupsFlourPer48Cookies);
		double loafCupAmount = (double) (loafCount * cupsFlourPerBananaLoaf);
		double flourCupAmount = cookieCupAmount + loafCupAmount;
		double poundsForBatch = convertFlourCupToPound(flourCupAmount);

		// Calculate the number of bags to buy
		double bagsPerPoundFlour = 1.0 / 5.0;
		double bagsOfFlour = Math.ceil(poundsForBatch * bagsPerPoundFlour);

		return (int) bagsOfFlour;
	}

	public static int containersOfSalt(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double tspOfSaltPer48Cookies = 1.0 / 48.0;
		double tspOfSaltPerBananaLoaf = 1.0 / 8.0;

		// Calculate cups of salt needed per every batch of baked items and convert tsp to ounces
		double cookieTspAmount = (double) (cookieCount * tspOfSaltPer48Cookies);
		double loafTspAmount = (double) (loafCount * tspOfSaltPerBananaLoaf);
		double tspAmount = cookieTspAmount + loafTspAmount;
		double ouncesForBatch = convertTspToOunces(tspAmount);

		// Calculate the number of containers to buy
		double containersPerOunces = 1.0 / 26.0;
		double containersOfSalt = Math.ceil(ouncesForBatch * containersPerOunces);

		return (int) containersOfSalt;
	}

	public static int boxesOfBakingSoda(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double tspOfBakingSodaPer48Cookies = 1.0 / 48.0;
		double tspOfBakingSodaPerBananaLoaf = 1.0 / 1.0;

		// Calculate tsp of flour needed per every batch of baked items and convert tsp to ounces
		double cookieTspAmount = (double) (cookieCount * tspOfBakingSodaPer48Cookies);
		double loafTspAmount = (double) (loafCount * tspOfBakingSodaPerBananaLoaf);
		double tspAmount = cookieTspAmount + loafTspAmount;
		double ouncesForBatch = convertTspToOunces(tspAmount);

		// Calculate the number of containers to buy
		double containersPerOunces = 1.0 / 16.0;
		double boxesOfBakingSoda = Math.ceil(ouncesForBatch * containersPerOunces);

		return (int) boxesOfBakingSoda;
	}

	public static int bottlesOfVanilla(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double tspOfVanillaPer48Cookies = 1.0 / 48.0;
		double tspOfVanillaPerBananaLoaf = 1.0 / 1.0;

		// Calculate tsp of flour needed per every batch of baked items and convert tsp to ounces
		double cookieTspAmount = (double) (cookieCount * tspOfVanillaPer48Cookies);
		double loafTspAmount = (double) (loafCount * tspOfVanillaPerBananaLoaf);
		double tspAmount = cookieTspAmount + loafTspAmount;
		double ouncesForBatch = convertTspToOunces(tspAmount);

		// Calculate the number of containers to buy
		double bottlesPerOunces = 1.0 / 1.0;
		double bottlesOfVanilla = Math.ceil(ouncesForBatch * bottlesPerOunces);

		return (int) bottlesOfVanilla;
	}

	public static int cartonsOfEggs(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double eggsPer48Cookies = 2.0 / 48.0;
		double eggsPerBananaLoaf = 1.0 / 1.0;

		// Calculate tsp of flour needed per every batch of baked items and convert tsp to ounces
		double cookieEggAmount = (double) (cookieCount * eggsPer48Cookies);
		double loafEggAmount = (double) (loafCount *eggsPerBananaLoaf);
		double eggsAmount = cookieEggAmount + loafEggAmount;

		// Calculate the number of containers to buy
		double cartonsPerDozen = 1.0 / 12.0;
		double cartonsOfEggs = Math.ceil(eggsAmount * cartonsPerDozen);

		return (int) cartonsOfEggs;
	}

	public static int bagsOfSugar(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double cupsOfSugarPer48Cookies = 1.5 / 48.0;
		double cupsOfSugarPerBananaLoaf = 0.75 / 1.0;

		// Calculate tsp of flour needed per every batch of baked items and convert tsp to ounces
		double cookieSugarCupAmount = (double) (cookieCount * cupsOfSugarPer48Cookies);
		double loafSugarCupAmount = (double) (loafCount * cupsOfSugarPerBananaLoaf);
		double sugarCupAmount = cookieSugarCupAmount + loafSugarCupAmount;
		double poundsForBatch = convertSugarCupToPound(sugarCupAmount);

		// Calculate the number of containers to buy
		double bagsPerPound = 1.0;
		double bagsOfSugar = Math.ceil(poundsForBatch * bagsPerPound);
		
		return (int) bagsOfSugar;
	}

	public static int packagesOfButter(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double cupsOfButterPer48Cookies = 1.0 / 48.0;
		double cupsOfButterPerBananaLoaf = 1.0 / 3.0;

		// Calculate tsp of flour needed per every batch of baked items and convert tsp to ounces
		double cookieButterCupAmount = (double) (cookieCount * cupsOfButterPer48Cookies);
		double loafButterCupAmount = (double) (loafCount * cupsOfButterPerBananaLoaf);
		double butterCupAmount = cookieButterCupAmount + loafButterCupAmount;

		// Calculate the number of containers to buy
		double packagesPerCupButter = 1.0 / 2.0;
		double packagesOfButter = Math.ceil(butterCupAmount * packagesPerCupButter);

		return (int) packagesOfButter;
	}

	public static int bananas(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double bananasPer48Cookies = 0.0;
		double bananasPerBananaLoaf = 3.0 / 1.0;

		// Calculate tsp of flour needed per every batch of baked items and convert tsp to ounces
		double cookieBananaAmount = (double) (cookieCount * bananasPer48Cookies);
		// New variables?
		double loafBananaAmount = (double) (loafCount * bananasPerBananaLoaf);

		// Calculate the number of containers to buy
		int bananas = (int) loafBananaAmount;
		return bananas;
	}

	public static int bagsOfChocolateChips(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf, added cookieCount into calculation
		double cupsOfChipsPer48Cookies = (double) (2.5 / 48.0 * cookieCount);
		double cupsOfChipsPerBananaLoaf = 0.0;

		// Calculate tsp of flour needed per every batch of baked items and convert tsp to ounces
		double cupsOfChipsPerBag = 1.0 / 2.0;
		double bagsOfChocolateChips = Math.ceil(cupsOfChipsPer48Cookies * cupsOfChipsPerBag);

		// Calculate the number of containers to buy
		return (int) bagsOfChocolateChips;
	}

	public static double totalCost(int cookieCount, int loafCount) {
		// prices given from problem
		double priceBagOfFlour = 1.79;
		double priceContainerOfSalt = 1.09;
		double priceOfBakingSoda = 1.09;
		double priceOfVanilla = 3.99;
		double priceOfDozenEggs = 2.19;
		double priceBagOfSugar = 1.99;
		double priceOfButter = 4.49;
		double priceOfBanana = 0.32;
		double priceBagOfChips = 3.29;

		// total price for each component
		double totalPriceFlour = (double) (priceBagOfFlour * bagsOfFlour(cookieCount, loafCount));
		double totalPriceSalt = (double) (priceContainerOfSalt * containersOfSalt(cookieCount, loafCount));
		double totalPriceBakingSoda = (double) (priceOfBakingSoda * boxesOfBakingSoda(cookieCount, loafCount));
		double totalPriceVanilla = (double) (priceOfVanilla * bottlesOfVanilla(cookieCount, loafCount));
		double totalPriceDozenEggs = (double) (priceOfDozenEggs * cartonsOfEggs(cookieCount, loafCount));
		double totalPriceBagsOfSugar = (double) (priceBagOfSugar * bagsOfSugar(cookieCount, loafCount));
		double totalPriceOfButter = (double) (priceOfButter * packagesOfButter(cookieCount, loafCount));
		double totalPriceOfBanana = (double) (priceOfBanana * bananas(cookieCount, loafCount));
		double totalPriceBagOfChips = (double) (priceBagOfChips * bagsOfChocolateChips(cookieCount, loafCount));

		// total cost of ingredients
		double sumTotal = totalPriceFlour + totalPriceSalt + totalPriceBakingSoda + totalPriceVanilla + totalPriceDozenEggs + totalPriceBagsOfSugar + totalPriceOfButter + totalPriceOfBanana + totalPriceBagOfChips;

		return sumTotal;
	}

	// flour cups to pounds conversion
	public static double convertFlourCupToPound (double flourCupAmount) {
		final double CUPS_TO_POUND_RATIO = 10.0 / 3.0;
		double poundAmount = flourCupAmount / CUPS_TO_POUND_RATIO;
		return poundAmount; 
	}

	// sugar cups to pounds conversion
	public static double convertSugarCupToPound (double sugarCupAmount) {
		final double SUGAR_CUPS_TO_POUND_RATIO = 1.0 / 2.0;
		double sugarPoundAmount = sugarCupAmount * SUGAR_CUPS_TO_POUND_RATIO;
		return sugarPoundAmount;
	}
	
	// teaspoon to ounces conversion
	public static double convertTspToOunces (double tspAmount) {
		final double TSP_TO_OUNCES_RATIO = 1.0 / 6.0;
		double ouncesAmount = tspAmount * TSP_TO_OUNCES_RATIO;
		return ouncesAmount;
	}
}
