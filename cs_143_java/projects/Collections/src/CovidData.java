import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

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
        // set of all states in the data
        Set<String> states = new TreeSet<>();
        // set of all counties in the data
        Set<String> counties = new TreeSet<>();

        // loop through each line in the file using the nextLine method
        // we wont use next, because next will only get one word, not an entire line
        // while we have not reached the end of the file...
        while(file.hasNext()){
            String[] row = file.nextLine().split(","); // Example {"2020-01-29","Snohomish","Washington","53061","1","0"}
            // now row[0] contains the date, row[1] contains the county, row[2] contains the state and so on...
            states.add(row[2]); // add the state to the set of all states
            counties.add(row[1]);
            rows++;
        }

        System.out.println(rows);
        System.out.println(states);
        System.out.println(states.size());
        System.out.println(counties);
        System.out.println(counties.size());
    }
}
