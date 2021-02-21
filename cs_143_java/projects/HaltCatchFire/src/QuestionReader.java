import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is going to read in a .csv file to be used as questions,
 * categories, and answers for the trivia game.
 */

public class QuestionReader {
    private static File textFile;
    private Scanner readThis;
    private String line;
    private String answer;

    private class Question {
        private String category;
        private String questionString;
        private String[] choices = new String[4];
        private Integer answer;

        public Question(String[] scanned) {
            this.category = scanned[0];
            this.questionString = scanned[1];
            this.choices[0] = scanned[2];
            this.choices[1] = scanned[3];
            this.choices[2] = scanned[4];
            this.choices[3] = scanned[5];
            this.answer = Integer.parseInt(scanned[6]);
        }
    }

    ArrayList<Question> trivia = new ArrayList<Question>();

    public QuestionReader(File textFile) { // Constructor to read and sort .txt file
        textFile = new File("src/trivia.csv");
        readInFile(textFile);
    }

    private void readInFile(File textFile) {
        try {
            readThis = new Scanner(textFile);
            while (readThis.hasNextLine()) {
                String[] row = readThis.nextLine().split(",");
                Question triviaHelp = new Question(row);
            }

        } catch (FileNotFoundException e) {
            System.out.println("trivia file was not found");
        }
    }

    public static void main(String[] args) {
        QuestionReader test = new QuestionReader(textFile);
    }
}