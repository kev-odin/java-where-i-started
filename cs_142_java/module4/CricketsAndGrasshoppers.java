import java.util.Scanner;

public class CricketsAndGrasshoppers {

    public static void main(String[] args) {
        Scanner readThis = new Scanner(System.in);
        int playerInput = 0;
        String playerPrompt = "0";
        promptNumberReadLine(readThis, playerPrompt, playerInput);
    }

    public static int promptNumberReadLine(Scanner s, String prompt, int max) {
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
    //     return 0;
    // }

    // public static String boardToString(int[] board) {
    //     return 0;
    // }

    public static boolean canMove(int[] board, int player) {
        return true;
    }

    public static boolean move(int[] board, int player, int position) {
        return true;
    }

    public static boolean isMoveLegal() { // possible to add later on for logic test
        return true;
    }
}