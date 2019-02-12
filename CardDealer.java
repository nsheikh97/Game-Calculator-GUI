import java.util.Arrays;
import java.util.Collections;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/** This class can create a deck of 'Cards', deal, and shuffle*/
public class CardDealer {

    private Card[] deck = new Card[52];
    private int pointer = 0;

    /**
     * Default constructor,
     * Card dealer creates a standard 52 card deck
     */
    public CardDealer(){

        for (int i = 0; i < 13; i++) {
            for (int j = 0; j <4; j++) {
                deck[pointer] = new Card(i + 1, j+1);
                pointer ++ ;
            }
        }

        shuffle();
        pointer = 0;
    }

    /**
     * Calling deal will return a string value in the form of 'Rank' of 'Suit'
     *@return a card value
     */
    public String deal(){
        if (pointer > 51) pointer = 0;

        String rank = deck[pointer].getRank();
        String suit = deck[pointer].getSuit();

        pointer ++;

        return  rank + " of " + suit;
    }

    /**
     * Shuffles card deck into random assortment
     */
    public void shuffle(){
        Collections.shuffle(Arrays.asList(deck));
    }

}
