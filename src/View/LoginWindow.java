package View;
import Controllers.LoginWindowCtrl;
import Run.Run;
import Controllers.UltimateScheduleCtrl;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.application.Application;
import Controllers.GuiCtrl;

import java.awt.event.ActionListener;

/**
 * Created by Bob on 11/17/2015.
 */
public class LoginWindow  {

Button b1 = new Button("Log In");

    public Scene setLoginScene(Stage stage) {
        /*Run run= new Run();
        UltimateScheduleCtrl ultimateScheduleCtrl= new UltimateScheduleCtrl();
        GuiCtrl guiCtrl= new GuiCtrl();
        UltimateSchedule ultimateSchedule= new UltimateSchedule();*/
        VBox vBox = new VBox();
        vBox.getChildren().add(b1);
        Scene loginScene = new Scene(vBox, 345, 345);
        stage.setScene(loginScene);
        return loginScene;
    }

    public void addNewWindowHandler(EventHandler eventHandler){
        b1.setOnAction(eventHandler);

    }


}
