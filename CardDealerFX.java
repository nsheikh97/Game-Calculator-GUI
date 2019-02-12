import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Background;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import static java.lang.Math.min;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

/**
 * Responsible for Card Dealer rendering*/
public class CardDealerFX {

    private CardDealer dealer = new CardDealer();
    private VBox vboxMain;
    private int numberOfDeals = 0;

    /**
     * Constructs the final results after scoring a player
     * @return is a HBox element with player and score formatted for easy add to main node
     */
    private HBox constructFinalResults(){
        HBox finalResults = new HBox(5);
        finalResults.setAlignment(Pos.CENTER);
        for(int i=0; i < numberOfDeals; i++){
            Label newDraw = new Label(dealer.deal());
            newDraw.setId("highlight");
            finalResults.getChildren().add(newDraw);
        }

        return finalResults;
    }

    /**
     * Non default constructor,
     * @param prevScene is the main menu scene
     * @param mainMenu is the anchor of the main menu so that control can be regained
     */
    public CardDealerFX(Scene prevScene, VBox mainMenu){

        // create a label control --------------------------------------------------------------------------------------
        Label titleLabel = new Label("CARD DEALER");
        titleLabel.setId("title");
        Label instructionLabel = new Label("ENTER # OF CARDS TO DEAL(MAX 5)");
        instructionLabel.setId("subtitle");
        Label dealLabel = new Label("DEAL");
        dealLabel.setId("resultArea");
        Label cardsLabel = new Label("CARDS");
        cardsLabel.setId("highlight");

        //create button control for dealer
        Button dealBtn = new Button("DEAL");
        dealBtn.setId("startButton");

        Button shuffleBtn = new Button("SHUFFLE");
        shuffleBtn.setId("resetButton");

        Button backBtn = new Button("BACK");
        backBtn.setId("exitButton");

        //create text fields for user input
        TextField cardField = new TextField();
        cardField.setPromptText("# CARDS");
        cardField.setId("textArea");
        cardField.setFocusTraversable(false);


        //--------------------------------------------------------------------------------------------------------------
        //build out card dealer ui

        //horizontal box for escape buttons
        HBox buttons = new HBox(5,backBtn, shuffleBtn);
        buttons.setAlignment(Pos.CENTER);

        //horizontal box for time input
        HBox cardInput = new HBox(5, cardField, dealBtn);
        cardInput.setAlignment(Pos.CENTER);

        //initialize final results hbox
        HBox finalResultHbox = constructFinalResults();

        vboxMain = new VBox(20, titleLabel,instructionLabel,finalResultHbox, cardInput, buttons);
        vboxMain.setBackground(Background.EMPTY);
        vboxMain.setAlignment(Pos.CENTER);

        vboxMain.setPrefWidth(200);
        backBtn.setMinWidth(vboxMain.getPrefWidth());
        shuffleBtn.setMinWidth(vboxMain.getPrefWidth());
        dealBtn.setMinWidth(vboxMain.getPrefWidth());


        //--------------------------------------------------------------------------------------------------------------
        //--------------------------------------------------------------------------------------------------------------
        //EVENT HANDLERS
        // Register the event Handlers on each button

        //back to menu
        backBtn.setOnAction(e-> {
            prevScene.setRoot(mainMenu);
        });

        dealBtn.setOnAction(e ->{
            //push card count to start dealing
            try {
                numberOfDeals = min(5, Integer.parseInt(cardField.getText()));
            }catch (NumberFormatException x){
                numberOfDeals = 1;
            }

            //feedback to user
            instructionLabel.setText("Dealt " + numberOfDeals + " cards");

            //update final results hbox with new values;
            finalResultHbox.getChildren().setAll(constructFinalResults().getChildren());
        });

        shuffleBtn.setOnAction(e ->{
            //shuffle deck of cards
            dealer.shuffle();

            instructionLabel.setText("Shuffled Cards");

        });

        //--------------------------------------------------------------------------------------------------------------
    }
    /**
     * returns this main node
     *@return this main node for menu to anchor
     */
    public VBox getCardDealerScene() {
        return this.vboxMain;
    }
}
