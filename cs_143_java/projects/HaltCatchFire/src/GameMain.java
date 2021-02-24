import java.io.File;

public class GameMain {
    private static File textFile;
    public static void main(String[] args) {
        textFile = new File("src/trivia.csv"); // May need to change the path to where you have the "trivia.csv"; check your own computer.
        QuestionList library = new QuestionList(textFile);
        System.out.println(library.triviaList.get(15).toString()); // example on how to interact with the arrayList
    }
}
