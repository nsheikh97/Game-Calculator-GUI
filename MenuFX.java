import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/**
 * Responsible for menu rendering*/
public class MenuFX {

    //creating mainMenu Scene
    private Scene mainScene;
    private Stage primaryStage;

    /**
     * Non default constructor,
     * @param primaryStage is the main stage for javaFX
     */
    public MenuFX(Stage primaryStage){
        //MAIN MENU SCENE
        // create a label control --------------------------------------------------------------------------------------
        Label instructionLabel = new Label("CHOOSE A GAME BELOW");
        instructionLabel.setId("title");

        //create button control for Dice
        Button diceBtn = new Button("DICE");
        diceBtn.setId("gameButton");
        //create button control for Timer
        Button timerBtn = new Button("TIMER");
        timerBtn.setId("gameButton");
        //create button control for ScoreKeeper
        Button scorePadBtn = new Button("SCORE PAD");
        scorePadBtn.setId("gameButton");
        //create button for card dealer
        Button cardDealerBtn = new Button("CARD DEALER");
        cardDealerBtn.setId("gameButton");
        //create button control for ScoreKeeper
        Button exitBtn = new Button("EXIT");
        exitBtn.setId("exitButton");
        //--------------------------------------------------------------------------------------------------------------
        //build out menu with 10 spacing

        HBox column1 = new HBox(20, diceBtn, timerBtn);
        column1.setAlignment(Pos.CENTER);

        HBox column2 = new HBox(20, scorePadBtn, cardDealerBtn);
        column2.setAlignment(Pos.CENTER);

        //build out menu with 10 spacing
        VBox vboxMain = new VBox(20, instructionLabel, column1, column2, exitBtn);
        vboxMain.setBackground(Background.EMPTY);


        //set width of buttons
        vboxMain.setPrefWidth(200);
        diceBtn.setMinWidth(vboxMain.getPrefWidth());
        timerBtn.setMinWidth(vboxMain.getPrefWidth());
        scorePadBtn.setMinWidth(vboxMain.getPrefWidth());
        cardDealerBtn.setMinWidth(vboxMain.getPrefWidth());
        exitBtn.setMinWidth(vboxMain.getPrefWidth());


        // create a Scene with the HBox as its root node
        // set the size of the scene (without this it is only as big as the label)
        mainScene = new Scene(vboxMain,1200, 600);
        mainScene.setFill(Color.web(("#19647E")));
        mainScene.getStylesheets().add("styles.css");

        // center the Label
        vboxMain.setAlignment(Pos.CENTER);

        // Add the scene to the Stage
        primaryStage.setScene(mainScene);

        //show the window
        primaryStage.show();

        //--------------------------------------------------------------------------------------------------------------
        //EVENT HANDLERS
        // Register the event Handlers on each button

        //latch to game nodes when button pressed
        diceBtn.setOnAction(e-> {
            mainScene.setRoot(new DiceFX(mainScene, vboxMain).getDiceScene());
        });
        timerBtn.setOnAction(e-> {
            mainScene.setRoot(new MyTimerFX(mainScene, vboxMain).getTimerScene());
        });
        scorePadBtn.setOnAction(e -> {
            mainScene.setRoot(new ScorePadFX(mainScene, vboxMain).getScoreScene());
        });
        cardDealerBtn.setOnAction(e -> {
        mainScene.setRoot(new CardDealerFX(mainScene, vboxMain).getCardDealerScene());
         });
        //exit
        exitBtn.setOnAction(e-> {
            System.exit(0);
        });
        //--------------------------------------------------------------------------------------------------------------
    }
}
