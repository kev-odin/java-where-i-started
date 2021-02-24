import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * This class is going to read in a .csv file to be used as questions,
 * categories, and answers for the trivia game.
 */

public class QuestionList {
    private static File textFile;
    private Scanner readThis;

    ArrayList<Question> triviaList = new ArrayList<>();

    public QuestionList(File textFile) {
        textFile = new File("src/trivia.csv");
        readInFile(textFile);
    }

    private void readInFile(File textFile) {
        Integer readAnswer;
        String readCategory;
        String readQuestionString;
        Integer readPrize;
        Integer readRound;

        try {
            readThis = new Scanner(textFile);
            readThis.useDelimiter(",");
            readThis.nextLine();
            int selectionSize = readThis.nextInt();
            readThis.nextLine();

            while (readThis.hasNextLine()) {
                String[] readChoices = new String[selectionSize];
                String[] row = readThis.nextLine().split(",");
                for (int i = 0; i < selectionSize; i++) {
                    readChoices[i] = row[i];
                }
                readAnswer = Integer.parseInt(row[4]);
                readCategory = row[5];
                readQuestionString = row[6];
                readPrize = Integer.parseInt(row[7]);
                readRound = Integer.parseInt(row[8]);

                Question entry = new Question(readChoices, readAnswer, readCategory, readQuestionString, readPrize, readRound);
                triviaList.add(entry);
            }
        } catch (FileNotFoundException e) {
            System.out.println("trivia file was not found");
        }
    }

    public class Question {
        private String[] playerChoices;
        private Integer answer;
        private String category;
        private String questionString;
        private Integer prize;
        private Integer round;

        public Question(String[] playerChoices, Integer answer, String category, String questionString, Integer prize, Integer round) {
            this.playerChoices = playerChoices;
            this.answer = answer;
            this.category = category;
            this.questionString = questionString;
            this.prize = prize;
            this.round = round;
        }

        public String[] getChoices() {
            return playerChoices;
        }

        public Integer getAnswer() {
            return answer;
        }

        public String getCategory() {
            return category;
        }

        public String getQuestionString() {
            return questionString;
        }

        public Integer getPrize() {
            return prize;
        }

        public Integer getRound() {
            return round;
        }
    }
    public static void main(String[] args) {
        QuestionList test = new QuestionList(textFile);
    }
}