import java.util.Random;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/** This class rolls a die of n sides*/
public class Dice  {
    int sides;

    /**
     * Default constructor,
     * Dice has 6 sides.
     */
    public Dice() {
        sides = 6;
        roll();
    }

    /**
     * Non default constructor,
     * @param side is the number of sides desired
     */
    public Dice(int side){
        sides = side;
        roll();
    }

    /**
     * Calling roll returns the rolled value.
     *@return a dice roll value
     */
    public int roll(){
        Random val = new Random();
        return val.nextInt(sides) + 1;
    }

    /**
     * Set sides sets the number of sides on dice
     *@param sides is the number of sides desired
     */
    public void setSides(int sides){
        this.sides = sides;
    }

    /**
     * Set sides sets the number of sides on dice, if string is invalid default value will be set
     *@param sides is the number of sides desired
     */
    public void setSides(String sidesString){
        //if user input a non-integer, the exception will be caught and the default value of six will be set
        try{
            sides = Integer.parseInt(sidesString);
        }
        catch(NumberFormatException x) {
            sides = 6;
        }
    }

    /**
     * returns sides of game dice
     *@return  # of sides set on game dice
     */
    public int getSides(){
        return sides;
    }

}//end Dice