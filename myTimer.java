//package Games;

import java.util.Timer;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/** This class runs a timer of a user specified length*/
public class myTimer {
    private int minutes;
    private int seconds;
    private Timer timer = new Timer();

    /**
     * Default constructor,
     * Timer has 30 seconds.
     */
    public myTimer() {
        minutes = 0;
        seconds = 30;
    }

    /**
     * Set time sets the timer class minutes and seconds
     *
     * @param min is the minutes assigned to timer class
     * @param sec is the seconds assigned to timer class
     */
    public void setTimer(String min, String sec) {

        int minInt = 0, secInt = 0;

        if(min == "") minutes = 0;
        if(sec == "") seconds = 0;

        try {
            secInt = Integer.parseInt(sec);
            minInt = Integer.parseInt(min);
        }catch (NumberFormatException x){
            minutes = 0;
            seconds = 0;
        }

        if (secInt > 60 || secInt < 0) {
            seconds = 60;
        }
        else seconds = secInt;

        if(minInt < 0) minutes = 0;
        else minutes = minInt;
    }

    /**
     * resets timer
     */
    public void reset(){
        minutes = 0;
        seconds = 0;
    }
    /**
     * removes a second from timer and properly recalculates minutes and seconds
     */
    public void decrement(){
        if(seconds > 0) {
            seconds --;
            return;
        }
        else if(minutes > 0) {
            minutes --;
            seconds += 60;
            return;
        }
        else return;
    }
    /**
     * returns minutes of time
     *@return  # of minutes on timer
     */
    public int getMinutes() {
        return minutes;
    }

    /**
     * returns seconds of time
     *@return  # of seconds on timer
     */
    public int getSeconds() {
        return seconds;
    }
}