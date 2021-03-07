import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class WeatherMain {
    public static void main(String[] args) throws FileNotFoundException {
        String testFile = "kent100.csv";
        Scanner readThis = new Scanner(new File (testFile));
        WeatherData test = new WeatherData(readThis);
        int i = 0;
    }
}
