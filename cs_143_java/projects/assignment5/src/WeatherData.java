
// Name: Kevin Chung (CS143 - Winter 2021)
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * A class representing weather data including temperatures, snowfall, and
 * precipitation over a period of time.
 * 
 * PLEASE DO NOT COPY THIS FILE TO OTHER STUDENTS OR TO WEBSITES LIKE CHEGG,
 * GITHUB, ETC WHERE OTHERS MAY VIEW IT!!! IT IS YOUR WORK AND YOU SHOULD BE
 * PROUD OF WHAT YOU HAVE ACCOMPLISHED! IN ADDITION, THIS FILE CONTAINS THE
 * COPYRIGHTED WORK OF MARTIN HOCK AND IS ONLY LICENSED FOR USE BY INDIVIDUAL
 * STUDENTS FOR NONPROFIT EDUCATIONAL PURPOSES.
 */
public class WeatherData {

	/**
	 * Load the data provided by the Scanner into your WeatherData class. The data
	 * should be loaded one line of text at a time using the Scanner's nextLine
	 * method. The first line of text should be discarded as it is a header. Each
	 * line of text, stored in a String, should be split using the .split(",")
	 * method. This will create an array of Strings. The relevant Strings are index
	 * 1, which indicates the date for the data on this line, index 2, which will
	 * indicate if the day contains multiple days of precipitation (or will be blank
	 * if it is just a single day of data), index 3, which indicates a multiple day
	 * precipitation total (or will be blank if it is a single day of
	 * precipitation), index 4, which indicates the single day precipitation total
	 * (or will be blank if the day contains multiple days of precipitation), index
	 * 7 which indicates the day's high temperature (and may be blank if this was
	 * not recorded), and index 8 which indicates the day's low temperature (and may
	 * be blank if this was not recorded). All other indexes may be ignored. All
	 * non-blank indexes in the array will contain a string surrounded by quotes -
	 * the substring command is the easiest way to get rid of them. Temperatures are
	 * always integers but precipitation and snowfall totals may contain decimal
	 * points. Dates are always of the form YYYY-MM-DD (a four digit year followed
	 * by a dash followed by a two digit month followed by a dash followed by a two
	 * digit day).
	 * 
	 * @param file Scanner connected to a weather data file
	 */
	// Method 1 & 2 boolean highTemp / lowTemp collections
	Set<Integer> highTempSet = new HashSet<>();
	Set<Integer> lowTempSet = new HashSet<>();

	// Method 3 double annualSnow collection
	Map<Integer, Double> annualSnow = new HashMap<>();

	public WeatherData(Scanner file) {
		file.nextLine(); // Discard header file
		while (file.hasNextLine()) {
			String[] rawData = file.nextLine().split(",");
			String[] date = rawData[1].substring(1,11).split("-");
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);

			// Extract high temperature data & low temperature, make sure that the length is long enough.
			if (rawData.length >= 9 && !rawData[7].equals("") && !rawData[8].equals("")){
				int highTemp = Integer.parseInt(rawData[7].substring(1, rawData[7].length() - 1));
				int lowTemp = Integer.parseInt(rawData[8]. substring(1, rawData[8].length() - 1));
				highTempSet.add(highTemp);
				lowTempSet.add(lowTemp);
			}

			// Extract snowfall data, makes sure the length is long enough
			if(rawData.length >= 6 && !rawData[5].equals("")){
                double snowfall = Double.parseDouble(rawData[5].substring(1, rawData[5].length() - 1));
                annualSnow.put(year, snowfall);
            }


		}

		// TODO: Save the data into the class. You should not use any static data
		// members. Remember that only the following methods are used to retrieve data,
		// so you can save the data using specialized collections for efficiency.
		// The constructor will probably do the hard work of setting up all the
		// collections so that the later methods can run efficiently.
		// Each method will probably have its own collection!
	}

	/**
	 * Determine whether the given temperature was ever seen as a high temperature
	 * in the data provided to the constructor. (10 points)
	 * 
	 * (HINT: This is a membership question. What data structure have we seen that
	 * can help us answer this question?)
	 * 
	 * @param degrees Temperature (same units as data file)
	 * @return true if high temp, false otherwise
	 */
	public boolean highTemp(int degrees) {
		if (highTempSet.contains(degrees)) {
			return true;
		} 
		return false;
	}

	/**
	 * Determine whether the given temperature was ever seen as a low temperature in
	 * the data provided to the constructor. (10 points)
	 * 
	 * @param degrees Temperature (same units as data file)
	 * @return true if low temp, false otherwise
	 */
	public boolean lowTemp(int degrees) {
		if (lowTempSet.contains(degrees)) {
			return true;
		}
		return false;
	}

	/**
	 * Determine the total amount of snowfall recorded in the given year. (20
	 * points)
	 * 
	 * (HINT: What data structure would allow us to correspond an amount of snowfall
	 * with a year? How much snowfall is recorded in a year not found in the file?)
	 * 
	 * @param year
	 * @return
	 */
	public double totalSnowfallForYear(int year) {
		return -1; // FIXME: Return actual snowfall for the given year
	}

	/**
	 * Determine the average (mean) total precipitation recorded for the given
	 * month. Be sure to include multi-day precipitation amounts. (Assume that all
	 * of the precipitation occurs on the date of the multi-date range - never
	 * divide it across months.) (20 points)
	 * 
	 * @param month
	 * @return
	 */
	public double averagePrecipitationForMonth(int month) {
		return -1; // FIXME: Return actual average precipitation
	}

	/**
	 * Return the most common (most often observed) high temperature seen in the
	 * given month. If there are two or more temperatures that are both seen the
	 * most number of times, return the lowest high temperature. (20 points)
	 * 
	 * @param month Month
	 * @return highest most common high temperature seen in that month
	 */
	public int lowestMostCommonHighForMonth(int month) {
		return 0; // FIXME: Return the most common high temperature for the given month
	}

	/**
	 * For the given low temperature, find the highest high temperature seen with
	 * that low. (20 points)
	 * 
	 * @param degrees Low temperature
	 * @return Highest high ever seen for that low temperature
	 */
	public int highestHighForLow(int degrees) {
		return 0; // FIXME: Return the highest high temperature seen for the given low temp
	}

}
