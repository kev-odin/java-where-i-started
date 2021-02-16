import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is going to read in a .txt file to be used as questions,
 * categories, and answers for the trivia game.
 */

public class QuestionReader {
    private Scanner readThis;
    private String line;
    private String answer;
    private static File textFile;

    ArrayList<Question> trivia = new ArrayList<Question>();

    public QuestionReader(File textFile) { // Constructor to read and sort .txt file
        textFile = new File("src/trivia.txt");
        readInFile(textFile);
    }

    private void readInFile(File textFile) {
        try {
            readThis = new Scanner(textFile);

            while (readThis.hasNextLine()) {
                if (readThis.hasNextInt()) {
                    answer = readThis.nextLine();
                } else {
                line = readThis.nextLine();
            }
        }

        } catch (FileNotFoundException e) {
            System.out.println("trivia.txt was not found");
        }
    }

    public static void main(String[] args) {
        QuestionReader test = new QuestionReader(textFile);
    }
}