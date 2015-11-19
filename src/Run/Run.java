
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
//LoginWindow loginWindow = new LoginWindow();

Stage primaryStage= new Stage();


    @Override
    public void start(Stage primaryStage) throws Exception {

        LoginWindowCtrl loginWindowControl= new LoginWindowCtrl();
        primaryStage.setScene(loginWindowControl.ctrGetLoginWindow(primaryStage));

        System.out.println("yeha");
        primaryStage.show();
    }

    public Stage passPStage2Controller() {
        return primaryStage;
    }
}
