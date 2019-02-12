import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/**
 * Responsible for timer rendering*/
public class MyTimerFX {

    private Scene timerScene;
    private myTimer timer = new myTimer();
    private VBox vboxMain;
    private Timeline timeline;

    /**
     * Non default constructor,
     * @param prevScene is the main menu scene
     * @param mainMenu is the anchor of the main menu so that control can be regained
     */
    public MyTimerFX(Scene prevScene, VBox mainMenu){

        // create a label control --------------------------------------------------------------------------------------
        Label titleLabel = new Label("Timer");
        titleLabel.setId("title");
        Label instructionLabel = new Label("ENTER TIME AND PRESS START");
        instructionLabel.setId("subtitle");
        Label colonLabel = new Label(":");
        colonLabel.setId("highlight");
        Label colonLabel2 = new Label(":");
        colonLabel2.setId("time");
        Label minuteLabel = new Label("00");
        minuteLabel.setId("time");
        Label secondLabel = new Label("00");
        secondLabel.setId("time");

        //create button control for timer
        Button startBtn = new Button("START");
        startBtn.setId("startButton");

        Button resetBtn = new Button("RESET");
        resetBtn.setId("resetButton");

        Button backBtn = new Button("BACK");
        backBtn.setId("exitButton");

        //create text fields for user input
        TextField minuteField = new TextField();
        minuteField.setPromptText("*MINUTES*");
        minuteField.setId("textArea");
        minuteField.setFocusTraversable(false);

        TextField secondField = new TextField();
        secondField.setPromptText("*SECONDS*");
        secondField.setId("textArea");
        secondField.setFocusTraversable(false);


        //--------------------------------------------------------------------------------------------------------------
        //build out timer ui

        //horizontal box for escape buttons
        HBox buttons = new HBox(5,startBtn, backBtn);
        buttons.setAlignment(Pos.CENTER);

        //horizontal box for time input
        HBox timeInput = new HBox(5,minuteField, colonLabel, secondField);
        timeInput.setAlignment(Pos.CENTER);


        vboxMain = new VBox(20, titleLabel,instructionLabel, timeInput, buttons);
        vboxMain.setBackground(Background.EMPTY);
        vboxMain.setAlignment(Pos.CENTER);

        vboxMain.setPrefWidth(200);
        backBtn.setMinWidth(vboxMain.getPrefWidth());
        startBtn.setMinWidth(vboxMain.getPrefWidth());

        //interface for counting down time remaining
        HBox countdown = new HBox(20,minuteLabel, colonLabel2, secondLabel);
        countdown.setBackground(Background.EMPTY);
        countdown.setAlignment(Pos.CENTER);

        VBox vboxCountdown = new VBox(20, countdown, resetBtn);
        vboxCountdown.setBackground(Background.EMPTY);
        vboxCountdown.setAlignment(Pos.CENTER);

        vboxCountdown.setPrefWidth(200);
        resetBtn.setMinWidth(vboxCountdown.getPrefWidth());

        //--------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------
        //EVENT HANDLERS
        // Register the event Handlers on each button

        backBtn.setOnAction(e-> {
            prevScene.setRoot(mainMenu);
        });

        startBtn.setOnAction(e ->{
            //sets timer values and updates
            timer.setTimer(minuteField.getText(), secondField.getText());
            minuteLabel.setText(Integer.toString(timer.getMinutes()));
            secondLabel.setText(Integer.toString(timer.getSeconds()));

            prevScene.setRoot(vboxCountdown);

            //decrements timer by 1 seconds using timeline
            timeline = new Timeline(new KeyFrame(
                    Duration.millis(1000),
                    ae -> {
                        //stops timer at end, reloads prev scene
                        if(timer.getMinutes() == 0 && timer.getSeconds() == 0){
                            timeline.stop();
                            prevScene.setRoot(vboxMain);
                        }
                        timer.decrement();
                        minuteLabel.setText(Integer.toString(timer.getMinutes()));
                        secondLabel.setText(Integer.toString(timer.getSeconds()));
                    }));
            timeline.setCycleCount(Animation.INDEFINITE);
            timeline.play();
        });

        resetBtn.setOnAction(e->{
            timer.reset();
            timeline.stop();
            prevScene.setRoot(vboxMain);
        });

        //--------------------------------------------------------------------------------------------------------------
    }

    /** return this main node
     *@return  this main node for menu to anchor
     */
    public VBox getTimerScene() {
        return this.vboxMain;
    }
}
