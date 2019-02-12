/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/** Auxilary class used by dealer. Contains rank and suit for each card. When dealed, dealer will read it as 'rank' of
 * 'suit'*/
public class Card {

    int rank;
    int suit;

    /**
     * Non default constructor,
     * @param rank is the assigned rank to a card
     * @param suit is the assigned suit to a card
     */
    public Card(int rank , int suit){
        this.rank = rank;
        this.suit = suit;
    }

    /**
     * Calling this will return the rank of the card
     *@return a string card rank value
     */
    public String getRank() {
        switch (rank){
            case 1: return "Ace";
            case 11: return "Jack";
            case 12: return "Queen";
            case 13: return "King";
            default: return Integer.toString(rank);
        }

    }

    /**
     * Calling this will return the suit of the card
     *@return a string card suit value
     */
    public String getSuit() {

        //return suit
        switch (suit){
            case 1: return "Spades";
            case 2: return "Hearts";
            case 3: return "Diamond";
            case 4: return "Clubs";
            default: return "NaN";
        }

    }
}
