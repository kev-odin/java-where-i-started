public class GasCalculator {
    
    public static double cadToUsd(double dollarsCad) {
        // Converts from Canadian to USD
        return dollarsCad * 0.71;
    }

    public static double galToLiters(double gallons) {
        // Converts from gallons to liters
        return gallons * 3.78541;
    }

    public static double kmToMiles(double distanceKm) {
        // Converts from kilometers to miles
        return distanceKm / 1.609;
    }
    public static void main(String[] args) {
        // Compute gas used (in Liters)
        double distanceMi = kmToMiles(121.0);
        double gallonsOfGas = distanceMi / 36.0;
        double litersOfGas = galToLiters(gallonsOfGas);

        // Compute cost in CAD
        double costOfGasCad = litersOfGas * 1.049;

        // Total cost in USD
        double costOfGasUsd = cadToUsd(costOfGasCad);

        System.out.println("The total cost of gas from Vancouver BC to Whistler is: " + costOfGasUsd + " US dollars.");
    }
}
