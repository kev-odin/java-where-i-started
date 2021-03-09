import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherMain {
    public static void main(String[] args) throws FileNotFoundException {
        String testFile = "brem100.csv";
        Scanner readThis = new Scanner(new File (testFile));
        WeatherData test = new WeatherData(readThis);
        //System.out.println(test.monthTempCount.keySet().toString().split(","));
        int i = 0;
    }
}
