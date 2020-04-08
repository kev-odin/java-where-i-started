public class GasCalculator {
    
    public static final double LITER_CONVERSION = 3.78541;
    public static final double MILES_CONVERSION = 1.609;
    public static double cadConversion = 0.71;
    public static double distanceBetweenCities = 121.0;
    public static double milesPerGallon = 36.0;
    public static double cadGasPrice = 1.049;

    public static double cadToUsd(double dollarsCad) {
        // Converts from Canadian to USD
        return dollarsCad * cadConversion;
    }

    public static double galToLiters(double gallons) {
        // Converts from gallons to liters
        return gallons * LITER_CONVERSION;
    }

    public static double kmToMiles(double distanceKm) {
        // Converts from kilometers to miles
        return distanceKm / MILES_CONVERSION;
    }
    public static void main(String[] args) {
        // Compute gas used (in Liters)
        double distanceMi = kmToMiles(distanceBetweenCities);
        double gallonsOfGas = distanceMi / milesPerGallon;
        double litersOfGas = galToLiters(gallonsOfGas);

        // Compute cost in CAD
        double costOfGasCad = litersOfGas * cadGasPrice;

        // Total cost in USD
        double costOfGasUsd = cadToUsd(costOfGasCad);

        System.out.println("The total cost of gas from Vancouver BC to Whistler is: " + costOfGasUsd + " US dollars.");
    }
}
