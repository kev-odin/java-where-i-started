import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherMain {
    public static void main(String[] args) throws FileNotFoundException {
        String testFile = "brem100.csv";
        Scanner readThis = new Scanner(new File (testFile));
        long start = System.currentTimeMillis();
        WeatherData test = new WeatherData(readThis);
        System.out.println(test.monthCount.entrySet());
        long end = System.currentTimeMillis();
        System.out.println((end - start) / 1000.0 + " second");
    }
}
