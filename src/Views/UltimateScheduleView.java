package Views;

import Controllers.LoginController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kuba on 2015-11-28.
 */
public class UltimateScheduleView {
    VBox ultimateScheduleBox;
    Button logOutButton;
    Scene ultimateScheduleScene;
    Stage ultimateScheduleStage;
    LoginController loginController;

    public void createUltimateScheduleView(){
        ultimateScheduleBox= new VBox();
        logOutButton= new Button("Log out");
        logOutButton.setOnAction(event -> {
            hideWindow();
            loginController= new LoginController();
            loginController.goBackToLoginView();

        });
        ultimateScheduleScene= new Scene(ultimateScheduleBox,300,300);
        ultimateScheduleBox.getChildren().addAll(logOutButton);
        ultimateScheduleStage= new Stage();
        ultimateScheduleStage.setScene(ultimateScheduleScene);
        ultimateScheduleStage.show();



    }
    public void hideWindow(){
        ultimateScheduleStage.hide();
    }

}
