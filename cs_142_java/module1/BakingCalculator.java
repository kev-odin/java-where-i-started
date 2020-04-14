
// Kevin Chung

public class BakingCalculator {
	final static double CUPS_TO_POUND_RATIO = 10.0 / 3.0;
	final static double SUGAR_CUPS_TO_POUND_RATIO = 1.0 / 2.0;
	final static double TSP_TO_OUNCES_RATIO = 1.0 / 6.0;

	public static int bagsOfFlour(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double cupsFlourPer48Cookies = 2.25 / 48.0;
		double cupsFlourPerBananaLoaf = 1.5;
		double bagsPerPoundFlour = 1.0 / 5.0;

		// Calculate cups of flour needed per every batch order of baked items and convert cup to pounds of flour
		double cookieCupAmount = (double) (cookieCount * cupsFlourPer48Cookies);
		double loafCupAmount = (double) (loafCount * cupsFlourPerBananaLoaf);
		double flourCupAmount = cookieCupAmount + loafCupAmount;
		double poundsFlourForBatch = convertFlourCupToPound(flourCupAmount);

		// Calculate the number of bags to buy
		double bagsOfFlour = Math.ceil(poundsFlourForBatch * bagsPerPoundFlour);

		return (int) bagsOfFlour;
	}

	public static int containersOfSalt(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double tspSaltPer48Cookies = 1.0 / 48.0;
		double tspSaltPerBananaLoaf = 1.0 / 8.0;
		double containerPerOunces = 1.0 / 26.0;

		// Calculate tsp of salt needed per every batch of baked items and convert tsp to ounces
		double cookieTspAmount = (double) (cookieCount * tspSaltPer48Cookies);
		double loafTspAmount = (double) (loafCount * tspSaltPerBananaLoaf);
		double saltTspAmount = cookieTspAmount + loafTspAmount;
		double ouncesForBatch = convertTspToOunces(saltTspAmount);

		// Calculate the number of containers to buy
		double containersOfSalt = Math.ceil(ouncesForBatch * containerPerOunces);

		return (int) containersOfSalt;
	}

	public static int boxesOfBakingSoda(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double tspBakingSodaPer48Cookies = 1.0 / 48.0;
		double tspBakingSodaPerBananaLoaf = 1.0;
		double boxPerOunces = 1.0 / 16.0;

		// Calculate tsp of baking soda needed per every batch of baked items and convert tsp to ounces
		double cookieTspAmount = (double) (cookieCount * tspBakingSodaPer48Cookies);
		double loafTspAmount = (double) (loafCount * tspBakingSodaPerBananaLoaf);
		double bakingSodaTspAmount = cookieTspAmount + loafTspAmount;
		double ouncesForBatch = convertTspToOunces(bakingSodaTspAmount);

		// Calculate the number of boxes to buy
		double boxesOfBakingSoda = Math.ceil(ouncesForBatch * boxPerOunces);

		return (int) boxesOfBakingSoda;
	}

	public static int bottlesOfVanilla(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double tspVanillaPer48Cookies = 1.0 / 48.0;
		double tspVanillaPerBananaLoaf = 1.0;
		double bottlesPerOunces = 1.0;

		// Calculate tsp of vanilla needed per every batch of baked items and convert tsp to ounces
		double cookieTspAmount = (double) (cookieCount * tspVanillaPer48Cookies);
		double loafTspAmount = (double) (loafCount * tspVanillaPerBananaLoaf);
		double vanillaTspAmount = cookieTspAmount + loafTspAmount;
		double ouncesForBatch = convertTspToOunces(vanillaTspAmount);

		// Calculate the number of bottles to buy
		double bottlesOfVanilla = Math.ceil(ouncesForBatch * bottlesPerOunces);

		return (int) bottlesOfVanilla;
	}

	public static int cartonsOfEggs(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double eggsPer48Cookies = 2.0 / 48.0;
		double eggsPerBananaLoaf = 1.0;
		double cartonsPerDozen = 1.0 / 12.0;

		// Calculate cartons of eggs needed per every batch of baked items
		double cookieEggAmount = (double) (cookieCount * eggsPer48Cookies);
		double loafEggAmount = (double) (loafCount *eggsPerBananaLoaf);
		double eggsAmount = cookieEggAmount + loafEggAmount;

		// Calculate the number of containers to buy
		double cartonsOfEggs = Math.ceil(eggsAmount * cartonsPerDozen);

		return (int) cartonsOfEggs;
	}

	public static int bagsOfSugar(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double cupsSugarPer48Cookies = 1.5 / 48.0;
		double cupsSugarPerBananaLoaf = 0.75;
		double bagsPerPound = 1.0;

		// Calculate cups of sugar needed per every batch of baked items and convert cups to pound
		double cookieSugarCupAmount = (double) (cookieCount * cupsSugarPer48Cookies);
		double loafSugarCupAmount = (double) (loafCount * cupsSugarPerBananaLoaf);
		double sugarCupAmount = cookieSugarCupAmount + loafSugarCupAmount;
		double poundsForBatch = convertSugarCupToPound(sugarCupAmount);

		// Calculate the number of containers to buy
		double bagsOfSugar = Math.ceil(poundsForBatch * bagsPerPound);
		
		return (int) bagsOfSugar;
	}

	public static int packagesOfButter(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double cupsButterPer48Cookies = 1.0 / 48.0;
		double cupsButterPerBananaLoaf = 1.0 / 3.0;
		double packagesPerCupButter = 1.0 / 2.0;

		// Calculate cups of butter needed per every batch of baked items
		double cookieButterCupAmount = (double) (cookieCount * cupsButterPer48Cookies);
		double loafButterCupAmount = (double) (loafCount * cupsButterPerBananaLoaf);
		double butterCupAmount = cookieButterCupAmount + loafButterCupAmount;

		// Calculate the number of containers to buy
		double packagesOfButter = Math.ceil(butterCupAmount * packagesPerCupButter);

		return (int) packagesOfButter;
	}

	public static int bananas(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf
		double bananasPerBananaLoaf = 3.0;

		// Calculate bananas needed per every batch of baked items
		double loafBananaAmount = (double) (loafCount * bananasPerBananaLoaf);

		// Calculate the number of bananas to buy
		int bananas = (int) loafBananaAmount;
		return bananas;
	}

	public static int bagsOfChocolateChips(int cookieCount, int loafCount) {
		// Recipe amounts given per 48 cookies and 1 banana bread loaf, added cookieCount into calculation
		double cupsChipsPer48Cookies = (2.5 / 48.0);
		double bagsPerCupChips = 1.0 / 2.0;

		// Calculate tsp of flour needed per every batch of baked items and convert tsp to ounces
		double chipsCupAmount = cookieCount * cupsChipsPer48Cookies;
		double bagsOfChocolateChips = Math.ceil(chipsCupAmount * bagsPerCupChips);

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
		double priceBagOfChocolateChips = 3.29;

		// total price for each component
		double totalPriceFlour = (double) (priceBagOfFlour * bagsOfFlour(cookieCount, loafCount));
		double totalPriceSalt = (double) (priceContainerOfSalt * containersOfSalt(cookieCount, loafCount));
		double totalPriceBakingSoda = (double) (priceOfBakingSoda * boxesOfBakingSoda(cookieCount, loafCount));
		double totalPriceVanilla = (double) (priceOfVanilla * bottlesOfVanilla(cookieCount, loafCount));
		double totalPriceDozenEggs = (double) (priceOfDozenEggs * cartonsOfEggs(cookieCount, loafCount));
		double totalPriceBagsOfSugar = (double) (priceBagOfSugar * bagsOfSugar(cookieCount, loafCount));
		double totalPriceOfButter = (double) (priceOfButter * packagesOfButter(cookieCount, loafCount));
		double totalPriceOfBanana = (double) (priceOfBanana * bananas(cookieCount, loafCount));
		double totalPriceBagOfChocolateChips = (double) (priceBagOfChocolateChips * bagsOfChocolateChips(cookieCount, loafCount));

		// total cost of ingredients
		double sumTotal = totalPriceFlour + totalPriceSalt + totalPriceBakingSoda + totalPriceVanilla + totalPriceDozenEggs + totalPriceBagsOfSugar + totalPriceOfButter + totalPriceOfBanana + totalPriceBagOfChocolateChips;

		return sumTotal;
	}

	// flour cups to pounds conversion
	public static double convertFlourCupToPound (double flourCupAmount) {
		double poundAmount = flourCupAmount / CUPS_TO_POUND_RATIO;
		return poundAmount; 
	}

	// sugar cups to pounds conversion
	public static double convertSugarCupToPound (double sugarCupAmount) {
		double sugarPoundAmount = sugarCupAmount * SUGAR_CUPS_TO_POUND_RATIO;
		return sugarPoundAmount;
	}
	
	// teaspoon to ounces conversion
	public static double convertTspToOunces (double tspAmount) {
		double ouncesAmount = tspAmount * TSP_TO_OUNCES_RATIO;
		return ouncesAmount;
	}
}
