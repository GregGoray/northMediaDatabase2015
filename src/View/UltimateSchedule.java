package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Bob on 11/17/2015.
 */
public class UltimateSchedule {

    public Scene getUltimateSchedule(Stage stage) {
        VBox vBox = new VBox();
        Button b2 = new Button("ManagerSchedule");
        vBox.getChildren().add(b2);
        Scene ultimateSchedule = new Scene(vBox, 456, 265);
        stage.setScene(ultimateSchedule);

        return ultimateSchedule;
    }
}
