import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is going to read in a .txt file to be used as questions,
 * categories, and answers for the trivia game.
 */

public class Trebek {
    private Scanner readThis;
    private String line;
    private static File textFile;

    public Trebek(File textFile) { // Constructor to read and sort .txt file
        textFile = new File("trivia.txt");
        readInFile(textFile);
    }

    public Trebek() {

    }

    private void readInFile(File textFile) {
        try {
            readThis = new Scanner(textFile);

            while (readThis.hasNextLine()) {
                line = readThis.nextLine();
                System.out.println(line);
            }

        } catch (FileNotFoundException e) {
            System.out.println("trivia.txt was not found");
        }
    }

    public static void main(String[] args) {
        Trebek test = new Trebek(textFile);
    }
}