package Run;

import View.LoginWindow;


import javafx.application.Application;
import javafx.stage.Stage;

/**
 * Created by Bob on 11/17/2015.
 */
public class Run extends Application{
LoginWindow loginWindow = new LoginWindow();

    Stage primaryStage= new Stage();

    public Stage passPStage2Controller() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception {

        primaryStage.setScene(loginWindow.setLoginScene());

        primaryStage.show();
    }
}
