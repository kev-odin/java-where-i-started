public class Card {

    // Class variables are often used to store constant values that are needed in several places. In that case, they should also be declared as final. 
    // Note that whether a variable is static or final involves two separate considerations: static means the variable is shared, and final means the variable is constant.
    // Naming static final variables with capital letters is a common convention that makes it easier to recognize their role in the class. 
    // In the toString method, we can refer to SUITS and RANKS as if they were local variables, but we can tell that they are class variables.
    // One advantage of defining SUITS and RANKS as class variables is that they don’t need to be created (and garbage-collected) every time toString is called. 
    // They may also be needed in other methods and classes, so it’s helpful to make them available everywhere. 
    // Since the array variables are final, and the strings they reference are immutable, there is no danger in making them public.

    //Private variables, encoding the ranks and suits
    private final int suit;
    private final int rank;
    public static final String[] SUITS = {"Clubs", "Diamonds", "Hearts", "Spades"};
    public static final String[] RANKS = {null, "Ace", "2", "3", "4", "5", "6", 
                                        "7", "8", "9", "10", "Jack", "Queen","King"};

    // Populate the cards array with references to a Card object
    Card[] cards = new Card[52];

    int index = 0;

    //Constructors
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    @Override
    public String toString() {
        String s = RANKS[this.rank] + " of " + SUITS[this.suit];     
        return s;
    }

    // Read the compareTo docs, -1 means less, 1 means more, 0 means the same
    public int compareTo(Card other) {
        if(this.suit < other.suit) return -1;
        if(this.suit > other.suit) return 1;
        if(this.rank < other.rank) return -1;
        if(this.rank > other.rank) return 1;
        return 0;
    }
    // We want this object to be immutable
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}