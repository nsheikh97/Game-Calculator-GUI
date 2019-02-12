import static java.lang.Math.min;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/** This keeps the score of up to 5 players*/
public class ScorePad {
    private int nPlayers = 2;
    private int[] scoreArray;

    /**
     * Default constructor,
     * Score pad has 2 players.
     */
    public ScorePad(){
        scoreArray = new int[nPlayers];
    }

    /**
     * Non default constructor,
     * @param numOfPlayers is the number of players added to the scorepad
     */
    public ScorePad(int numOfPlayers){
        nPlayers = numOfPlayers;
        scoreArray = new int[nPlayers];
    }

    /**
     * Adds score to a given player
     * @param player the player # to add score
     * @param score the amount to add
     */
    public void addScoreToPlayer(int player, int score){
        scoreArray[player] += score;
    }

    /**
     * Finds score of a given player
     * @param player the player # to find score
     * @return  score of given player
     */
    public int getPlayerScore(int player){
        return scoreArray[player];
    }

    /**
     * returns the number of players on score pad
     * @return  number of players on score pad
     */
    public int getnPlayers(){
        return nPlayers;
    }

    /**
     * sets number of players on score pad
     * @param  n the number of players to set
     */
    public void setnPlayer(int n){
        scoreArray = new int[n];
    }

    /**
     * sets number of players on score pad
     * @param  n the number of players to set with string value
     */
    public void setnPlayers(String n){
        try{
            nPlayers = min(5,Integer.parseInt(n));
            scoreArray = new int[nPlayers];
        }
        catch(NumberFormatException x) {

        }
    }
    /**
     * resets score pad
     */
    public void reset(){
        nPlayers = 2;
        scoreArray = new int[nPlayers];
    }
}
