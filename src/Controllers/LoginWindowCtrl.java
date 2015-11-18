package Controllers;
import View.LoginWindow;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Bob on 11/17/2015.
 */
public class LoginWindowCtrl {
    LoginWindow loginWindow= new LoginWindow();


    public Scene ctrGetLoginWindow(Stage stage){
        return loginWindow.setLoginScene(stage);

    }

}
