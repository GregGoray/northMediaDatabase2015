
package Run;

import Controllers.GuiCtrl;
import Controllers.LoginWindowCtrl;
import View.LoginWindow;
import javafx.application.Application;
import javafx.stage.Stage;


import View.LoginWindow;



import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Bob on 11/17/2015.
 */
public class Run extends Application {
LoginWindow loginWindow = new LoginWindow();

Stage primaryStage= new Stage();


    @Override
    public void start(Stage primaryStage) throws Exception {


        primaryStage.setScene(primaryStage);
        primaryStage.show();
    }

    public Stage passPStage2Controller() {
        return primaryStage;
    }
}
