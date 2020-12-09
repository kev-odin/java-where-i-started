import java.util.Scanner;
import java.util.Random;

public class Hangman {
    public static void main(String[] args) {        
        String[] gameString = new String[9];
        gameString[0] ="Welcome to Hangman.\nAre you ready to play? (Y/n)";
        gameString[1] ="Good job! You won this game of Hangman.";
        gameString[2] ="Sorry. You lost this game of Hangman.";
        gameString[3] ="The letter is present in the word.";
        gameString[4] ="The letter is absent in the word.";

        Scanner readThis = new Scanner(System.in);
        int randomNumber = new Random().nextInt(4);

    }

    public static String wordBank(int randomIndex) {
        String[] wordList = new String[4];
        wordList[0] = "Apple";
        wordList[1] = "Bear";
        wordList[2] = "Camera";
        wordList[3] = "Dentist";
        return wordList[randomIndex];
    }

    public static String[] gameBoard(int boardSize) {
        String[] stringBoard = new String[boardSize];
        return stringBoard;
    }

    public static boolean validInput(String s) {
        
        return true;
    }
}
