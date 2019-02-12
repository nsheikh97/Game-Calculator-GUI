import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author Nabeel Sheikh
 * @date 2/3/19
 * @rev A
 * A GUI Game Calculator Application
 */

public class GameCalc extends Application {

    //field for label control
    MenuFX mainMenu;

    public static void main(String[] args) {
        //launch the Application
        launch(args);
    }//end main

    @Override
    public void start(Stage primaryStage){

        //application will have a fixed size
        primaryStage.setResizable(false);

        MenuFX mainMenu = new MenuFX(primaryStage);


    } //end start


}//end class
