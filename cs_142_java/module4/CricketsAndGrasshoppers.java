import java.util.Scanner;

public class CricketsAndGrasshoppers {

    public static void main(String[] args) {
        // The main method will do several things in this program:
        // Start by creating a new Scanner object, then use your promptNumberReadLine
        // method to ask the user for the number of pieces per player and empty spaces
        // in the middle.
        // Use this information to create the initial board.
        // Then use a while loop to repeat the primary game loop where you:
        // print the board to the console as a String,
        // ask the current player to enter their move, and, if it is valid,
        // modify the board with your move method. If it is not valid, print a message
        // and ask again.
        // Repeat this until a player has won.
        // Once a player has won, exit the loop and print out a message as shown in the
        // examples above.

        Scanner readThis = new Scanner(System.in);
        int max = 10; // given assignment parameter
        int piecesPerPlayer = 0;
        int spacesInMiddle = 0;
        int player = 1;

        String[] playerName = new String[2];
        playerName[0] = "Crickets";
        playerName[1] = "Grasshoppers";

        String[] playerPrompt = new String[4];
        playerPrompt[0] = "Please enter the number of pieces for each player (1-10): ";
        playerPrompt[1] = "Please enter the number of spaces in the middle (1-9): ";
        playerPrompt[2] = ", please enter your move ";
        playerPrompt[3] = "That space does not contain a piece you can move! Please try again.";

        // Prompt user to make the game board, gather information on the array size
        piecesPerPlayer = promptNumberReadLine(readThis, playerPrompt[0], max);
        spacesInMiddle = promptNumberReadLine(readThis, playerPrompt[1], max - 1);
        max = spacesInMiddle + piecesPerPlayer * 2;

        while (true) {
            // Create game board based on the user input
            int[] gameBoardPlay = createBoard(piecesPerPlayer, spacesInMiddle);
            System.out.println(boardToString(gameBoardPlay));

            if (player == 1) {
                promptNumberReadLine(readThis, playerName[0] + playerPrompt[2] + "(1-" + max + "): ", max);
                canMove(gameBoardPlay, player);
                player++;
            } else {
                promptNumberReadLine(readThis, playerName[1] + playerPrompt[2] + "(1-" + max + "): ", max);
                canMove(gameBoardPlay, player);
                player--;
            }
        }
    }

    public static int promptNumberReadLine(Scanner s, String prompt, int max) {

        int userInput = 0;
        String errorRange = "That was not a valid number! Please try again.";

        // Making sure that the user inputs are valid and within the the right range.
        while (true) {
            System.out.print(prompt);
            if (s.hasNextInt()) {
                userInput = s.nextInt();
                s.nextLine();
                if (userInput <= 0 || userInput > max) {
                    System.out.println(errorRange);
                } else {
                    return userInput;
                }
            } else {
                s.nextLine();
                System.out.println(errorRange);
            }
        }
    }

    public static int[] createBoard(int piecesPerPlayer, int spacesInMiddle) {

        int gameSize = (piecesPerPlayer * 2) + spacesInMiddle;
        int[] gameBoard = new int[gameSize];

        // build int[] based on player input
        for (int i = 0; i < gameBoard.length; i++) {
            if (i < piecesPerPlayer) {
                gameBoard[i] = 1; // Crickets
            } else if (i >= gameBoard.length - piecesPerPlayer) {
                gameBoard[i] = 2; // Grasshoppers
            }
        }
        return gameBoard;
    }

    public static String boardToString(int[] board) {

        String gameBoardString = "";

        // Searching the board array for 0, 1, 2 and adding the corresponding letter
        for (int i = 0; i < board.length; i++) {
            if (board[i] == 1) {
                gameBoardString += "C";
            } else if (board[i] == 2) {
                gameBoardString += "G";
            } else {
                gameBoardString += ".";
            }
        }
        return gameBoardString;
    }

    public static boolean isMoveValid(int[] board, int player, int position) {

        boolean validMoves = false;

        for (int i = 0; i < board.length; i++) {
            if (player == 1 && board[i] == 1) { // player 1 available moves, empty space OR enemy + empty space
                if (board[i + 1] == 0) {
                } else if (board[i + 1] == 2 && board[i + 2] == 0) {
                }
                validMoves = true;
            } else if (player == 2 && board[i] == 2) { // player 2 available moves, empty space OR enemy + empty space
                if (board[i - 1] == 0) {
                } else if (board[i - 1] == 1 && board[i - 2] == 0) {
                }
                validMoves = true;
            }
        }
        return validMoves;
    }

    public static boolean canMove(int[] board, int player) {
        // Return true if the given player has any move they can make.
        // Cricket is player 1 and grasshopper is 2.
        // This method will help you determine when the game is over.
        // Look for pieces matching the player piece in the array

        int position = 0;

        for (int i = 0; i < board.length; i++) {
            if (player == 1 && board[i] == 1) {
                isMoveValid(board, player, position);
            } else if (player == 2 && board[i] == 2) {
                isMoveValid(board, player, position);
            }
        }
        return true;
    }

    public static boolean move(int[] board, int player, int position) {
        // The player moves their piece in the given position (numbered 1 through n).
        // If the specified move is allowed, modify the board and return true.
        // Otherwise, don’t modify board and return false.
        // Note: The user will enter a number form 1 to n to specify a position, but in
        // your board array, recall that the entries are indexed 0 to n-1.
        return true;
    }

}