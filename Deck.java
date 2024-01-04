package comp1721.cwk2;

// Implement Deck class here

public class Deck {

    private Card[] deck;
    private int cardsused;
    public Deck() {
        this(false);
    }

    public Deck(boolean JokersIncluded) {
        if (JokersIncluded)
            deck = new Card[54];
        else
            deck = new Card[52];
        int cardCt = 0; 
        for ( int suit = 0; suit <= 3; suit++ ) {
            for ( int value = 1; value <= 13; value++ ) {
                deck[cardCt] = new Card(value,suit);
                cardCt++;
            }
        }
        if (JokersIncluded) {
            deck[52] = new Card(1,Card.JOKER);
            deck[53] = new Card(2,Card.JOKER);
        }
        cardsused = 0;
    }
    public void shuffle() {
        for ( int i = deck.length-1; i > 0; i-- ) {
            int rand = (int)(Math.random()*(i+1));
            Card temp = deck[i];
            deck[i] = deck[rand];
            deck[rand] = temp;
        }
        cardsused = 0;
    }
    public int Leftcards() {
        return deck.length - cardsused;
    }
    public Card carddeals() {
        if (cardsused == deck.length)
            throw new IllegalStateException("The deck is empty.");
        cardsused++;
        return deck[cardsused - 1];
    }
    public boolean withJokers() {
        return (deck.length == 54);
    }

}