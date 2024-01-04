package comp1721.cwk2;

// Implement PokerHand class here
/**
* Description:
 * PokerHand data type.
 * Can construct a hand from standard input, format a hand for output,
 * determine if a hand is a flush or a full house.
 * Test main() sets up 5-card poker hands from standard input,
 * prints flushes and full houses (one per line).
 *
 * Dependencies: StdIn, StdOut
 */

public class PokerHand {
    // class constants
    private static final int SIZEOFHAND = 5;  // we intialize the size of the hand to five cards

    // we instanciate variables
    private String[] hand;                  // in this case each card takes one card

    // we introduce a constructor that reads a 5-card poker hand from StdIn
    public PokerHand() {
        hand = new String[SIZEOFHAND];
        for (int i = 0; i < SIZEOFHAND; i++) {
            hand[i] = StdIn.readString();
        }

        // the poker will sort the hand in the manner that, the Queen is higher than King!
        // then Ten becomes highest than either of them
        // 2, 3, 4, 5, 6, 7, 8, 9, A, J, K, Q, T
        java.util.Arrays.sort(hand); // we call this to help in sorting

    }

    // this part helps to check if this hand is a flush?
    // we use boolen to check it.
    public boolean fLUSH() {
        char suit = hand[0].charAt(1);
        for (int i = 1; i < SIZEOFHAND; i++) {
            if (suit != hand[i].charAt(1)) return false;
        }
        return true;
    }

    // this part helps to check if this hand is a full house?
    public boolean fULLHOUSE() {
        // this part looks for the matching 3 martching and 2 matching.
        //check the first card
        char rank = hand[0].charAt(0);
        int sumRank = 1;
        // check the last card
        char rank1 = hand[SIZEOFHAND - 1].charAt(0);
        int sumRank1 = 1;
        // this for loop confirms the cards that are simillar to count cards  to first and last cards
        for (int i = 1; i < SIZEOFHAND - 1; i++) {
            if (hand[i].charAt(0) == rank) sumRank++;
            if (hand[i].charAt(0) == rank1) sumRank1++;
        }

        // this part helps to check if this hand is a full house?
        if (sumRank == 3 && sumRank1 == 2) return true;
        if (sumRank == 2 && sumRank1 == 3) return true;
        // if no full house then return false :(
        return false;
    }

    // string representation of this hand sorted
    public String toString() {
        String fullHand = "";
        for (int i = 0; i < SIZEOFHAND; i++)
            fullHand = fullHand + hand[i] + " ";
        return fullHand;
    }

    // main method for testing
    public static void main(String[] args) {
        // it helps in inputing one hand at a time
        // it should output it if it is a flush or full house
        while (!StdIn.isEmpty()) {
            PokerHand ph = new PokerHand();
            if (ph.fLUSH()) StdOut.println("     Flush: " + ph);
            if (ph.fULLHOUSE()) StdOut.println("Full house: " + ph);
        }
    }
}}