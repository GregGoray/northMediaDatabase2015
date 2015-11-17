package View;
import Controllers.LoginWindowCtrl;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import Controllers.GuiCtrl;

/**
 * Created by Bob on 11/17/2015.
 */
public class LoginWindow  {



    public Scene setLoginScene() {
        UltimateSchedule ult = new UltimateSchedule();
        GuiCtrl guiCtrl= new GuiCtrl();

        VBox vBox = new VBox();
        Button b1 = new Button("Log In");
        vBox.getChildren().add(b1);

        b1.setOnAction(event -> {
           guiCtrl.setPrimaryStage().setScene(ult.getUltimateSchedule());
        });

        Scene loginScene = new Scene(vBox, 345, 345);
        System.out.println("login scene");
        return loginScene;

    }



}
