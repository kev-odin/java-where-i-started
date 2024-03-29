
// Name: Kevin Chung (CS143 - Winter 2021)
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

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

	// Method 3 double snowfallPerYear collection
	Map<Integer, Double> snowfallPerYear = new HashMap<>();

	// Method 4 averagePrecipitationForMonth collections
	Map<Integer, Double> monthPrecipTotal = new HashMap<>();
	Map<Integer, Double> monthPrecipAverage = new HashMap<>();

	// Method 5 lowestMostCommonHighForMonth collection
	Map<Integer, Map<Integer, Integer>> monthCount = new HashMap<>();
	Map<Integer, Integer> modeMap = new HashMap<>();

	// Method 6 highestHighForLow collection
	Map<Integer, Integer> highestHighLow = new HashMap<>();

	public WeatherData(Scanner file) {
		file.nextLine(); // Discard header file
		while (file.hasNextLine()) {
			String[] rawData = file.nextLine().split(",");
			String[] date = rawData[1].substring(1, 11).split("-");
			int year = Integer.parseInt(date[0]);
			int month = Integer.parseInt(date[1]);

			// Extract high temperature data & low temperature, the length is long enough.
			if (rawData.length >= 9 && !rawData[7].equals("") && !rawData[8].equals("")) {
				int highTemp = Integer.parseInt(rawData[7].substring(1, rawData[7].length() - 1));
				int lowTemp = Integer.parseInt(rawData[8].substring(1, rawData[8].length() - 1));
				highTempSet.add(highTemp);
				lowTempSet.add(lowTemp);

				/*
				 * Capturing the temperature frequency per month Step 1: Check if monthCount has
				 * a month key Step 2: If not, add month to monthCount and create empty tempFreq
				 * map Step 2A: Update tempFreq with current highTemp and add 1 to frequency
				 * Step 3: If month count contains the month key, get the current count for
				 * highTemp OR default count is 0 Step 4: Update monthCount map, with existing
				 * month, new/existing temperature with count + 1
				 */
				Map<Integer, Integer> tempFreq = new TreeMap<>(); // Inner map for monthCount
				if (monthCount.containsKey(month)) {
					int count = monthCount.get(month).getOrDefault(highTemp, 0);
					monthCount.get(month).put(highTemp, count + 1);
				} else {
					tempFreq.put(highTemp, 1);
					monthCount.put(month, tempFreq);
				}

				/*
				 * Processing the mode highest temperature for each month Step 1: If modeMap
				 * does not have a month key, add month and highTemp Step 2: If highCount >
				 * modeCount, add to modeMap Step 3: If highCount == modeCount, choose the lower
				 * temperature Step 4: Hope this works!
				 */

				if (!modeMap.containsKey(month)) {
					modeMap.put(month, highTemp);
				} else {
					int modeTemp = modeMap.get(month);
					int modeCount = monthCount.get(month).get(modeTemp);
					int highCount = monthCount.get(month).get(highTemp);

					if (highCount > modeCount) {
						modeMap.put(month, highTemp);
					} else if (highCount == modeCount) {
						if (highTemp > modeTemp) {
							modeMap.put(month, modeTemp);
						} else {
							modeMap.put(month, highTemp);
						}
					}
				}

				/*
				 * Capturing the highest low temperature seen for each month Step 1: Assign low
				 * temperature as key Step 2: Check if the low temperature is already a key, if
				 * so compare high temperature values Step 2A: If the highTemp is greater, then
				 * update value Step 2B: If the highTemp is less than, get previous value Step
				 * 3: If no low temperature is found as a key, assign low temperature as key,
				 * put in map
				 */

				if (highestHighLow.containsKey(lowTemp)) {
					if (highTemp > highestHighLow.get(lowTemp)) {
						highestHighLow.put(lowTemp, highTemp);
					} else {
						highestHighLow.put(lowTemp, highestHighLow.get(lowTemp));
					}
				} else {
					highestHighLow.put(lowTemp, highTemp);
				}
			}
			// Obtain snowfall totals
			if (rawData.length >= 6 && !rawData[5].equals("")) {
				double snowfall = Double.parseDouble(rawData[5].substring(1, rawData[5].length() - 1));
				double prevSnowfall = 0.0;

				// Step 1: check if year exists as a key (containsKey)
				if (snowfallPerYear.containsKey(year)) {
					prevSnowfall = snowfallPerYear.get(year);
					// Step 2: if step 1 was true, use get(year) to get the previous snowfall total
				} else {
					snowfallPerYear.put(year, snowfall);
				}
				// Step 3: add the new snowfall to previous, put that back in the map
				snowfall += prevSnowfall;
				snowfallPerYear.put(year, snowfall);
			}
			// Obtain single day precipitation
			if (rawData.length >= 5 && !rawData[4].equals("")) {
				double singlePrecip = Double.parseDouble(rawData[4].substring(1, rawData[4].length() - 1));
				double prevPrecip = 0.0;

				if (monthPrecipTotal.containsKey(month)) {
					prevPrecip = monthPrecipTotal.get(month);
				} else {
					monthPrecipTotal.put(month, singlePrecip);
				}
				singlePrecip += prevPrecip;
				monthPrecipTotal.put(month, singlePrecip);
			}
			// Obtain multiday precipitation
			if (rawData.length >= 4 && !rawData[3].equals("")) {
				double multiPrecip = Double.parseDouble(rawData[3].substring(1, rawData[3].length() - 1));
				double prevPrecip = 0.0;

				if (monthPrecipTotal.containsKey(month)) {
					prevPrecip = monthPrecipTotal.get(month);
				} else {
					monthPrecipTotal.put(month, multiPrecip);
				}
				multiPrecip += prevPrecip;
				monthPrecipTotal.put(month, multiPrecip);
			}
			// Monthly average precipitation
			for (int months : monthPrecipTotal.keySet()) {
				double average = monthPrecipTotal.get(months) / 100.0;
				monthPrecipAverage.put(months, average);
			}
		}
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
		return snowfallPerYear.getOrDefault(year, 0.0);
	}

	/**
	 * Determine the average (meanhighestHighForLow
	 * 
	 * @return
	 */
	public double averagePrecipitationForMonth(int month) {
		return monthPrecipAverage.getOrDefault(month, 0.0);
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
		return modeMap.getOrDefault(month, 0);
	}

	/**
	 * For the given low temperature, monthTempCountfind the highest high
	 * temperature seen with that low. (20 points)
	 * 
	 * @param degrees Low temperature
	 * @return Highest high ever seen for that low temperature
	 */
	public int highestHighForLow(int degrees) {
		return highestHighLow.getOrDefault(degrees, 0);
	}
}