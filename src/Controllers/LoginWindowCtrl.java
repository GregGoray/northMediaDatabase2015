package Controllers;
import View.LoginWindow;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by Bob on 11/17/2015.
 */
public class LoginWindowCtrl {
    LoginWindow loginWindow;



    public LoginWindowCtrl(LoginWindow loginWindow) {
        this.loginWindow = loginWindow;

        loginWindow.addNewWindowHandler(new NewWindowListener());

    }
    public Scene ctrGetLoginWindow(Stage stage){
        return loginWindow.setLoginScene(stage);

    }



    class NewWindowListener implements EventHandler {

        @Override
        public void handle(Event event) {
            System.out.println("chujkurwa");
        }
    }//end inner class MultiplyListener

}
