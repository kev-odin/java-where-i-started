import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TallyCount {
    public static void main(String[] args) throws FileNotFoundException {
        File textFile = new File("classes.csv");
        TallyCount data = new TallyCount(textFile);
        int x = 0;
    }

    public TallyCount(File textFile) throws FileNotFoundException {
        readInFile(textFile);

    }

    private void readInFile(File textFile) throws FileNotFoundException {
        Scanner readThis = new Scanner(textFile);
        HashMap<String, Map<String, Integer>> dayCount = new HashMap<>();
        HashMap<String, Integer> count = new HashMap<>(); // key = 
        
        readThis.useDelimiter(",");
        readThis.nextLine(); // throw away first line 

        while (readThis.hasNext()) {
            String[] row = readThis.nextLine().split(",");
            String mon = row[9];
            String tues = row[10];
            String wed = row[11];
            String thurs = row[12];
            String fri = row[13];
            String sat = row[14];
            
            if (timeCount.containsKey(mon)) {

            }
        }
        readThis.close();
    }
}