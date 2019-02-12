import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
 * Responsible for dice rendering*/
public class DiceFX {

    private Dice myDice = new Dice();
    private VBox vboxMain;

    /**
     * Non default constructor,
     * @param prevScene is the main menu scene
     * @param mainMenu is the anchor of the main menu so that control can be regained
     */
    public DiceFX(Scene prevScene, VBox mainMenu){

        //initialize

        //--------------------------------------------------------------------------------------------------------------
        // create a label control
        Label titleLabel = new Label("ROLL THE DICE");
        titleLabel.setId("title");
        Label instructionLabel = new Label("SET # OF SIDES AND ROll");
        instructionLabel.setId("subtitle");
        Label rollLabel = new Label("-");
        rollLabel.setId("highlight");

        //create button control for Dice
        Button rollBtn = new Button("ROLL");
        rollBtn.setId("resultArea");
        Button backBtn = new Button("Back");
        backBtn.setId("exitButton");

        //create user text field for number of sides
        TextField sidesField = new TextField();
        sidesField.setPromptText("Enter # of sides");
        sidesField.setId("textArea");
        sidesField.setFocusTraversable(false);

        //--------------------------------------------------------------------------------------------------------------
        // build dice ui

        //creating main node for scene
        vboxMain = new VBox(20, titleLabel,instructionLabel, rollLabel, sidesField, rollBtn, backBtn);
        vboxMain.setBackground(Background.EMPTY);
        vboxMain.setAlignment(Pos.CENTER);

        //sizing
        vboxMain.setPrefWidth(200);
        rollBtn.setMinWidth(vboxMain.getPrefWidth());
        backBtn.setMinWidth(vboxMain.getPrefWidth());
        sidesField.setMaxWidth(450);



        //--------------------------------------------------------------------------------------------------------------
        //EVENT HANDLERS
        // Register the event Handlers on each button
        backBtn.setOnAction(e-> {
            prevScene.setRoot(mainMenu);
        });

        //when roll button is pressed, sides gets set to text field value and dice roll is performed
        rollBtn.setOnAction(e->{

            myDice.setSides(sidesField.getText());
            instructionLabel.setText("# of sides is set to "+myDice.getSides());

            rollLabel.setText("-> " + String.valueOf(myDice.roll() + " <-"));
        });

        //on enter set sides
        sidesField.setOnKeyPressed(ke->{

            if (ke.getCode().equals(KeyCode.ENTER))
            {
                myDice.setSides(sidesField.getText());
                instructionLabel.setText("# of sides is set to "+myDice.getSides());
            }
        });


        //--------------------------------------------------------------------------------------------------------------

    }

    /** return this main node
     *@return  this main node for menu to anchor
     */
    public VBox getDiceScene() {
        return this.vboxMain;
    }
}
