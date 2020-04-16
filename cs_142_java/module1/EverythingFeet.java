public class EverythingFeet {
	public static void main(String[] args) {
		double distanceToMeasure = 12.0;
		System.out.println("The conversion from " + distanceToMeasure + " inches to feet is: "  + inchesToFeet(distanceToMeasure));
		System.out.println("The conversion from " + distanceToMeasure + " yards to feet is: "  + yardsToFeet(distanceToMeasure));
		System.out.println("The conversion from " + distanceToMeasure + " mile(s) to feet is: "  + milesToFeet(distanceToMeasure));
		System.out.println("The conversion from " + distanceToMeasure + " kilometer(s) to feet is: "  + kmToFeet(distanceToMeasure));
    }

	public static double inchesToFeet(double inches) {
		//converts inches to feet
		//12 inches per foot
		double feet = inches / 12.0;
		return feet;
	}

	public static double yardsToFeet(double yards) {
		//converts yards to feet
		//3 feet per yard
		double feet = yards * 3.0;
		return feet;
	}

	public static double milesToFeet(double miles) {
		//converts miles to feet
		//5280 feet per mile
		double feet = miles * 5280.0;
		return feet;
	}

	public static double kmToFeet(double kilometers) {
		//converts kilometers to feet
		//use old code
		double convert = GasCalculator.kmToMiles(kilometers);
		double feet = milesToFeet(convert);
		return feet;
	}
}