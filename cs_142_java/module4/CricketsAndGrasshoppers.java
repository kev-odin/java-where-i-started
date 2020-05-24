import java.util.Scanner;

public class CricketsAndGrasshoppers {

    public static void main(String[] args) {
    // The main method will do several things in this program:
    // Start by creating a new Scanner object, then use your promptNumberReadLine method to ask the user for the number of pieces per player and empty spaces in the middle. 
    // Use this information to create the initial board. 
    // Then use a while loop to repeat the primary game loop where you:
        // print the board to the console as a String,
        // ask the current player to enter their move, and, if it is valid,
        // modify the board with your move method. If it is not valid, print a message and ask again.
    // Repeat this until a player has won.
    // Once a player has won, exit the loop and print out a message as shown in the examples above.
        Scanner readThis = new Scanner(System.in);
        int playerInput = 0;
        String playerPrompt = "0";
        promptNumberReadLine(readThis, playerPrompt, playerInput);
    }

    public static int promptNumberReadLine(Scanner s, String prompt, int max) {
    // Print the prompt using System.out.print() (just print, not println). 
    // If the next piece of information in the Scanner represents an integer which is at least 1 and at most max, read in the rest of the line with s.nextLine() and then return the number.
    // Otherwise (if the next piece of information doesn’t meet the above requirements), read in the rest of the line with s.nextLine(), and print the line:
    // That was not a valid number! Please try again.
    // then repeat the process described in this box. Follow these directions precisely for full points.
        int maxSpace = 0;
        
        String[] playerName = new String[2];
            playerName[0] = "Crickets";
            playerName[1] = "Grasshoppers";
        
        String[] playerPrompt = new String[3];
            playerPrompt[0] = "Please enter the number of pieces for each player (1-10): ";
            playerPrompt[1] = "Please enter the number of spaces in the middle (1-9): ";
            playerPrompt[2] = ", please enter your move (1-5): "; // max number changes based on the max number in the board
        
            System.out.print(playerPrompt[0]);
            int playerPieces = s.nextInt();
            System.out.println("The number of player pieces was : " + playerPieces);
    
            System.out.print(playerPrompt[1]);
            int playerSpaces = s.nextInt();
            System.out.println("The number of spaces between the pieces was : " + playerSpaces);

        
        return 0;
    }

    // public static int[] createBoard(int piecesPerPlayer, int spacesInMiddle) {
    // Create and return an array representing a new game with the number of pieces for each player indicated. 
    // The pieces should be on the ends of the board with the specified empty spaces.
    // In your array, use 1 to represent Crickets (player 1), use 2 to represent Grasshoppers (player 2), and use 0 to represent an empty space.
    //     return 0;
    // }

    // public static String boardToString(int[] board) {
    // Create and return a String that represents the game board, all on one line. 
    // Crickets are specified with C, grasshoppers with G, and empty spaces with . (period)
    // Don’t print it with this method! You’ll print the board by calling this method from the main later. 
    // Hint: Use string concatenation in a for loop.
    //     return 0;
    // }

    public static boolean canMove(int[] board, int player) {
    // Return true if the given player has any move they can make. 
    // Cricket is player 1 and grasshopper is 2. 
    // This method will help you determine when the game is over.
        return true;
    }

    public static boolean move(int[] board, int player, int position) {
    // The player moves their piece in the given position (numbered 1 through n). 
    // If the specified move is allowed, modify the board and return true. 
    // Otherwise, don’t modify board and return false.
    // Note: The user will enter a number form 1 to n to specify a position, but in your board array, recall that the entries are indexed 0 to n-1.
        return true;
    }

    public static boolean isMoveLegal() { // possible to add later on for logic test
        return true;
    }
}