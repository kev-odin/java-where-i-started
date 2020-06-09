public class Card {

    // Private variables, encoding the ranks and suits
    private final int suit;
    private final int rank;
    public static final String[] SUITS = { "Clubs", "Diamonds", "Hearts", "Spades" };
    public static final String[] RANKS = { null, "Ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "Jack", "Queen",
            "King" };
    
    static Card[] cards = new Card[52];

    // Constructors
    public Card(int rank, int suit) {
        this.rank = rank;
        this.suit = suit;
    }

    public String toString() {
        String s = RANKS[this.rank] + " of " + SUITS[this.suit];
        return s;
    }

    // Populate the cards array with references to Card objects
    public static Card[] makeDeck() {
        int index = 0;
        for (int suit = 0; suit <= 3; suit++) {
            for (int rank = 1; rank <= 13; rank++) {
                cards[index] = new Card(rank, suit);
                index++;
            }
        }
        return cards;
    }

    // Read the compareTo docs, -1 means less, 1 means more, 0 means the same
    public int compareTo(Card other) {
        if (this.rank == 1 && other.rank == 13) // Aces are high cards
            return 1;
        if (this.suit < other.suit)
            return -1;
        if (this.suit > other.suit)
            return 1;
        if (this.rank < other.rank)
            return -1;
        if (this.rank > other.rank)
            return 1;
        return 0;
    }

    public static void printDeck(Card[] cards) {
        for (Card card : cards) {
            System.out.println(card);
        }
    }

    // We want this object to be immutable
    public int getSuit() {
        return suit;
    }

    public int getRank() {
        return rank;
    }
}