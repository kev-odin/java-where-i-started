import javax.annotation.processing.SupportedSourceVersion;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class WeatherAnalysis {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner file = new Scanner(new File("brem100.csv"));
        // read in the line that contains the headers (discard it)
        file.nextLine();

        int maxYear = 0; // 0 is less than any year in the file
        int minYear = 9999; // 9999 is greater than any year in the file
        int entryCount = 0;
        int sumYears = 0; // doesn't make sense

        int recordHigh = -999; // we know all temperatures will be greater than this
        String dateOfRecordHigh = "";
        int recordLow  = 999; // we know all temperatures will be less than this
        String dateOfRecordLow = "";

        Map<String, Integer> dailyTemperatureRange = new HashMap<>();
        int maxTempRange = 0; // we know the ranges will be greater than this
        int highMaxTempRange = -999; // high temp for the maximum temperature range
        int lowMaxTempRange = 999;   // low temp for the maximum temperature range

        Map<String, Double> snowfallPerDay = new HashMap<>();
        double maxSnowfall = 0.0;
        String dateOfMaxSnowfall = "";

        Map<Integer, Double> totalSnowfallPerMonth = new HashMap<>();
        // use the Scanner to iterate through each line in the data
        while(file.hasNextLine()){
            String line = file.nextLine();
            // split the data into an array of strings
            String[] data = line.split(",");
            // what index contains the date? : index 1
            // date is in the format:
            // "YYYY-MM-DD"
            // 01234567891011
            // quotation marks are at index 0 and 11
            // We want a new string that only includes indexes 1 through 10
            // we could use the substring method to remove the quotation marks
            // we could use split, with the - delimiter
            // we would get a String array that looks like {"YYYY", "MM", "DD"}
            String[] date = data[1].substring(1,11).split("-");
            // convert from the year String in the date array to a int
            int year = Integer.parseInt(date[0]);
            int month = Integer.parseInt(date[1]);

            // check if this data has enough room for a high and low temperature
            // and make sure the high and low temperature are not blank
            if(data.length >= 9 && !data[7].equals("") && !data[8].equals("")) {
                // extract the high and low temperatures for this day
                // System.out.println(Arrays.toString(date));
                int high = Integer.parseInt(data[7].substring(1, data[7].length() - 1));
                int low = Integer.parseInt(data[8].substring(1, data[8].length() - 1));
                // System.out.println(high + " " + low);
                if(high > recordHigh){
                    recordHigh = high;
                    dateOfRecordHigh = data[1].substring(1,11);
                }
                if(low < recordLow){
                    recordLow = low;
                    dateOfRecordLow = data[1].substring(1,11);
                }

                // add the range between today's high and low temperature to the dailyTemperatureRange map
                int range = high - low;
                // lets make the date look like MM/DD/YYYY
                dailyTemperatureRange.put(date[1]+"/"+date[2]+"/"+date[0], range);
                // check if this range is greater than the greatest range
                if(range > maxTempRange){
                    maxTempRange = range;
                    highMaxTempRange = high;
                    lowMaxTempRange = low;
                }
            }
            // check if this entry includes snowfall data (index 5)
            if(data.length >= 6 && !data[5].equals("")){
                double snowfall = Double.parseDouble(data[5].substring(1, data[5].length() - 1));
                String dateString = date[1]+"/"+date[2]+"/"+date[0];
                snowfallPerDay.put(dateString, snowfall);
                if(snowfall > maxSnowfall){
                    maxSnowfall = snowfall;
                    dateOfMaxSnowfall = dateString;
                }
                // first, get the snowfall total for this month so far
                double previousSnowfall = totalSnowfallPerMonth.getOrDefault(month, 0.0);
                totalSnowfallPerMonth.put(month, previousSnowfall + snowfall);
            }
            // is this year greater than the maximum?
            if(year > maxYear){
                maxYear = year;
            }
            // is this year less than the minimum?
            if(year < minYear){
                minYear = year;
            }
            sumYears = sumYears + year;
            entryCount++;
        }

        System.out.println("Largest year: " + maxYear);
        System.out.println("Smallest year: " + minYear);
        System.out.println("Number of entries: " + entryCount);
        System.out.println("Average year: " + (double)sumYears / entryCount);
        System.out.println("Record high temperature: " + recordHigh + " on " + dateOfRecordHigh);
        System.out.println("Record low temperature: " + recordLow + " on " + dateOfRecordLow);
        //System.out.println(dailyTemperatureRange);
        System.out.println(maxTempRange + ": high of " + highMaxTempRange + ", low of " + lowMaxTempRange);
        String date = "12/01/1921";
        System.out.println(snowfallPerDay.getOrDefault(date, 0.0));
        System.out.println(dateOfMaxSnowfall + ": " + maxSnowfall);

        // convert our snowfall totals into averages by dividing each total by 100
        Map<Integer, Double> averageSnowfallPerMonth = new HashMap<>();
        // iterate through the months in our totals map
        for(int month: totalSnowfallPerMonth.keySet()){
            // compute the average (100 is the number of years in the data)
            double average = totalSnowfallPerMonth.get(month) / 100.0;
            // put the average into the new map
            averageSnowfallPerMonth.put(month, average);
        }
        System.out.println(averageSnowfallPerMonth);
    }
}
