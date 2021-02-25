import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

/**
 * Analyze the COVID data of counties in the United States
 */
public class CovidData {
    public static void main(String[] args) throws FileNotFoundException {
        // use a Scanner to parse the file line by line
        Scanner file = new Scanner(new File("us-counties.csv"));

        // read the first row (date,county,state,fips,cases,deaths) data headings
        // so that our scanner can skip over it and move on to the actual data
        System.out.println(file.nextLine());
        // how many rows in the data
        int rows = 0;
        // the latest date we have observed
        String latestDate = null;
        // how many cumulative deaths were there on the latest date
        int deathCount = 0;
        // set of all states in the data
        Set<String> states = new TreeSet<>();
        // set of all counties in the data
        Set<String> counties = new TreeSet<>();

        // String (key) is the County,State,Date
        // and the Integer (value) is the total number of deaths in that County/State as of that date
        Map<String, Integer> deathsInCountyAsOfDate = new TreeMap<>();

        // String (key) is the Date
        // and the Integer(value) is the total number of deaths as of that date
        Map<String, Integer> deathsAsOfDate = new TreeMap<>();

        // loop through each line in the file using the nextLine method
        // we wont use next, because next will only get one word, not an entire line
        // while we have not reached the end of the file...
        while(file.hasNext()){
            String[] row = file.nextLine().split(","); // Example {"2020-01-29","Snohomish","Washington","53061","1","0"}
            // now row[0] contains the date, row[1] contains the county, row[2] contains the state and so on...
            states.add(row[2]); // add the state to the set of all states
            counties.add(row[1]);

            // add an entry to the deathsInCountyAsOfDate map
            String key = row[1] + "," + row[2] + "," + row[0]; // create the key from the row data
            Integer deaths = Integer.parseInt(row[5]); // convert the deaths string into an integer
            deathsInCountyAsOfDate.put(key, deaths); // add the new entry to the map

            // add or update an entry in the deathsAsOfDate map
            // if row[0] (the date) is equal to the latestDate, then
            // we would have already added an entry for this date
            // so, we will add on to its value with the new death data
            if(row[0].equals(latestDate)){
                // this row is another entry for the same date (latestDate)
                // accumulate the deaths in this row onto the number of deaths
                // seen so far for this date (deathCount)
                deathCount = deathCount + Integer.parseInt(row[5]);
            }
            else{
                // this row is a new date, so update latestDate to the new date
                latestDate = row[0];
                // since this is a new date, deathCount on this date will start
                // as the number of deaths in this entry
                deathCount = Integer.parseInt(row[5]);
            }
            // last step: add this entry to the map
            // this works because put will override an entry in the map
            // if the key already exists, otherwise it will update an existing entry
            deathsAsOfDate.put(latestDate, deathCount);
            rows++;
        }

        // we are done processing the file, but we can use the existing maps to generate
        // new maps to analyze the data in different ways

        // deathsAsOfDate is an accumulation, so lets construct a new map called
        // newDeathsOnDate to map from each date to the number of new deaths observed on that date
        Map<String, Integer> newDeathsOnDate = new TreeMap<>();
        // how many total deaths were observed as of the previous date
        int prevAccumulatedDeaths = 0;
        // which date had the most new deaths?
        String dateWithMostDeaths = null; // placeholder value
        // how many new deaths were on the date that had the most deaths?
        int mostDeaths = -1; // placeholder value
        // use a foreach loop to iterate through the dates (keys) in our deathsAsOfDate map
        // and add an entry for each date to our newDeathsOnDate map
        for(String date: deathsAsOfDate.keySet()){
            // because deathsAsOfDate is a TreeMap, it is sorted by keys
            // so we will iterate from the oldest date to the newest date
            // Step 1: retrieve the accumulated number of deaths on this date
            int accumulatedDeaths = deathsAsOfDate.get(date);
            // number of new deaths is the number of deaths as of this date
            // minus the number of deaths as of the previous date
            int newDeaths = accumulatedDeaths - prevAccumulatedDeaths;
            // add an entry to our newDeathsOnDateMap
            newDeathsOnDate.put(date, newDeaths);
            // for the next date, the prevAccumulatedDeaths should be updated
            // to be the current accumulatedDeaths
            // (for the next iteration, the current deaths should be the previous deaths)
            prevAccumulatedDeaths = accumulatedDeaths;

            // finally, check if newDeaths is more than the most deaths we have seen
            // on a given day
            if(newDeaths > mostDeaths){
                mostDeaths = newDeaths;
                dateWithMostDeaths = date;
            }
        }

        Map<Integer, Set<String>> datesPerDeathCount = new TreeMap<>();

        // our newDeathsOnDate map already contains this data, it allows us
        // to look up the number of deaths on a particular date
        // The difference is, in that map the keys are dates and the values are death counts
        // In our new map the keys will be death counts and the values will be Sets of dates

        // lets iterate through all the dates in our data
        for(String date: newDeathsOnDate.keySet()){
            int deaths = newDeathsOnDate.get(date); // retrieving the number of new deaths on this date
            // this death count should be a key in the datesPerDeathCount map
            // situation 1: another date already had this many deaths, the key already exists
            //      -> add this date to the set associated with this deathCount
            if(datesPerDeathCount.containsKey(deaths)){
                // we already have dates associated with this many deaths
                // retrieve the set of dates that observed this many deaths
                Set<String> dates = datesPerDeathCount.get(deaths);
                // add the new date to the set
                dates.add(date);
            }
            // situation 2: this number of deaths is not yet associated with any dates
            //      -> add a brand new entry to the map with a new set containing this date
            else{
                // add a new entry to the map
                // deaths should be the key
                // since we had not previously observed a day with this many deaths,
                // the value will be a new set with only this date in it
                Set<String> newDateSet = new TreeSet<>(); // create a new set
                newDateSet.add(date); // add this date to the set
                datesPerDeathCount.put(deaths, newDateSet); // associate this new death count with the new set of dates
            }
        }

        // Map from County,State pairs to the total deaths in that county as of the latest date
        Map<String, Integer> totalDeathsPerCounty = new TreeMap<>();
        // Map from County,State,Date triplets to the number of new deaths in that county on that date
        Map<String, Integer> newDeathsPerCountyOnDate = new TreeMap<>();
        // iterate through our existing county data that looks like:
        // "King,Washington,2020-11-11" : 848
        // add this information to our new map (combine all the data for a county into a single entry
        // that describes the latest death count for that county)
        for(String countyDate: deathsInCountyAsOfDate.keySet()){
            // each string looks like County,State,Date
            // our new map should keys that look like County,State
            String[] countyStateDate = countyDate.split(","); // {"King", "Washington", "2020-11-11"}
            // at this point, we need to retrieve the total number of deaths associated with this date in this county
            int accumulatedDeaths = deathsInCountyAsOfDate.get(countyDate);

            // before we add the new entry to override the previous total, lets use the previous accumulation
            // to determine how many new deaths there were as of this date in this county
            // Problem: what if this is the first time we have seen this county?
            int previousAccumulatedDeaths = totalDeathsPerCounty.getOrDefault(countyStateDate[0]+","+countyStateDate[1], 0);
            int difference = accumulatedDeaths - prevAccumulatedDeaths;
            // add the difference to our newDeathsPerCountyOnDateMap
            newDeathsPerCountyOnDate.put(countyDate, difference);
            // add the updated total for this date to the entry for this county in our new map
            // when we see another entry for this county
            totalDeathsPerCounty.put(countyStateDate[0]+","+countyStateDate[1], accumulatedDeaths);
        }


//        System.out.println(rows);
//        System.out.println(states);
//        System.out.println(states.size());
//        System.out.println(counties);
//        System.out.println(counties.size());
        System.out.println(deathsInCountyAsOfDate.get("King,Washington,2020-11-11"));
        System.out.println(newDeathsPerCountyOnDate.get("King,Washington,2020-11-01"));
        System.out.println(deathsAsOfDate.get("2020-08-01"));
        System.out.println(newDeathsOnDate.get("2020-08-01"));
        System.out.println(dateWithMostDeaths + " " + mostDeaths);
        System.out.println(newDeathsOnDate);
        System.out.println(datesPerDeathCount.get(1049));
        System.out.println(totalDeathsPerCounty.get("Los Angeles,California"));
    }
}
