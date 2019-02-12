import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.*;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/**
 * Responsible for score pad rendering*/
public class ScorePadFX {

    private ScorePad myScorePad = new ScorePad();
    private VBox vboxMain;

    /**
     * Constructs the final results after scoring a player
     * @return is a HBox element with player and score formatted for easy add to main node
     */
    private HBox constructFinalResults(){
        HBox finalResults = new HBox(5);
        finalResults.setAlignment(Pos.CENTER);
        for(int i=0; i < myScorePad.getnPlayers(); i++){
            Label newPlayer = new Label("Player " + (i+1) + " : " + myScorePad.getPlayerScore(i));
            newPlayer.setId("highlight");
            finalResults.getChildren().add(newPlayer);
        }

        return finalResults;
    }

    /**
     * Non default constructor,
     * @param prevScene is the main menu scene
     * @param mainMenu is the anchor of the main menu so that control can be regained
     */
    public ScorePadFX(Scene prevScene, VBox mainMenu){

        //--------------------------------------------------------------------------------------------------------------
        // create a label control
        Label titleLabel = new Label("SCORE PAD");
        titleLabel.setId("title");
        Label titleUpdateLabel = new Label("...KEEPING SCORE...");
        titleUpdateLabel.setId("title");
        Label instructionLabel = new Label("ENTER # OF PLAYERS (MAX 5 PLAYERS)");
        instructionLabel.setId("subtitle");
        Label playerCountLabel = new Label("ENTER # OF PLAYERS");
        playerCountLabel.setId("subtitle");
        Label scoreLabel = new Label("");
        scoreLabel.setId("resultArea");
        Label addLabel = new Label("+");
        addLabel.setId("title");

        //create button control
        Button resetBtn = new Button("RESET");
        resetBtn.setId("resetButton");
        Button applyBtn = new Button("APPLY");
        applyBtn.setId("gameButton");
        Button backBtn = new Button("BACK");
        backBtn.setId("exitButton");
        Button confirmBtn = new Button("CONFIRM");
        confirmBtn.setId("resultArea");

        //create user text field for number of players
        TextField nPlayerField = new TextField();
        nPlayerField.setPromptText("Enter # of players (Default # : 2)");
        nPlayerField.setId("textArea");
        nPlayerField.setFocusTraversable(false);

        //create user text field to change player count
        TextField counterField = new TextField();
        counterField.setPromptText("*Score*");
        counterField.setId("textArea");
        counterField.setFocusTraversable(false);

        //create combobox for user selection
        final ComboBox playerBox = new ComboBox();
        playerBox.setPromptText("Player");
        playerBox.setId("textArea");

        //--------------------------------------------------------------------------------------------------------------

        //construct top of beginning scene where user selects player count
        vboxMain = new VBox(20, titleLabel,instructionLabel, nPlayerField, applyBtn, backBtn);
        vboxMain.setBackground(Background.EMPTY);
        vboxMain.setAlignment(Pos.CENTER);
        vboxMain.setPrefWidth(200);
        applyBtn.setMinWidth(vboxMain.getPrefWidth());
        nPlayerField.setMaxWidth(600);


        //--------------------------------------------------------------------------------------------------------------
        //constructing ui for user input
        HBox hboxCenter = new HBox(10);
        //hboxCenter.setPadding(new Insets(50, 20, 50, 20));
        hboxCenter.getChildren().addAll(playerBox, addLabel,counterField, confirmBtn);
        hboxCenter.setAlignment(Pos.CENTER);

        //horizontal box for escape buttons
        HBox buttons = new HBox(5,backBtn,resetBtn);
        buttons.setAlignment(Pos.CENTER);

        //initialize final results hbox
        HBox finalResultHbox = constructFinalResults();

        //counter interface
        VBox vboxCounter = new VBox(20, titleUpdateLabel, playerCountLabel, finalResultHbox, hboxCenter, buttons);
        vboxCounter.setBackground(Background.EMPTY);
        vboxCounter.setAlignment(Pos.CENTER);

        vboxCounter.setPrefWidth(200);
        resetBtn.setMinWidth(vboxCounter.getPrefWidth());
        backBtn.setMinWidth(vboxCounter.getPrefWidth());
        vboxMain.setPrefWidth(200);
        counterField.setMinWidth(vboxCounter.getPrefWidth());


        //--------------------------------------------------------------------------------------------------------------
        //EVENT HANDLERS
        // Register the event Handlers on each button

        backBtn.setOnAction(e-> {
            prevScene.setRoot(mainMenu);
        });

        nPlayerField.setOnKeyPressed(ke->{

            if (ke.getCode().equals(KeyCode.ENTER))
            {
                myScorePad.setnPlayers(nPlayerField.getText());
                playerCountLabel.setText("# of players set to " + myScorePad.getnPlayers());
                prevScene.setRoot(vboxCounter);
                //add players to comboBox;
                for(int i = 0; i < myScorePad.getnPlayers(); i++) playerBox.getItems().add(i+1);

                //update final results hbox with initial values;
                finalResultHbox.getChildren().setAll(constructFinalResults().getChildren());
            }
        });

        applyBtn.setOnAction(e->{

            myScorePad.setnPlayers(nPlayerField.getText());
            playerCountLabel.setText("# of players set to " + myScorePad.getnPlayers());
            prevScene.setRoot(vboxCounter);
            //add players to comboBox;
            for(int i = 0; i < myScorePad.getnPlayers(); i++) playerBox.getItems().add(i+1);

            //update final results hbox with initial values;
            finalResultHbox.getChildren().setAll(constructFinalResults().getChildren());

        });

        confirmBtn.setOnAction(e ->{
            //push score to proper player

            int player = 1;
            int scoreToAdd = 0;
            try {
                 player  = Integer.parseInt(playerBox.getValue().toString());
                 scoreToAdd = Integer.parseInt(counterField.getText());
            }catch (NumberFormatException | NullPointerException x){
                 scoreToAdd = 0;
            }

            myScorePad.addScoreToPlayer(player -1, scoreToAdd);

            //update final results hbox with new values;
            finalResultHbox.getChildren().setAll(constructFinalResults().getChildren());
        });

        //resets scoring and players. Returns to choosing player count
        resetBtn.setOnAction(e->{

            myScorePad.reset();
            prevScene.setRoot(vboxMain);
            playerBox.getItems().clear();

        });

        //--------------------------------------------------------------------------------------------------------------
    }

    /** return this main node
     *@return  this main node for menu to anchor
     */
    public VBox getScoreScene() {
        return this.vboxMain;
    }


}
