package View;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

/**
 * Created by Bob on 11/17/2015.
 */
public class UltimateSchedule {

    public Scene getUltimateSchedule() {
        VBox vBox = new VBox();
        Button b2 = new Button("ManagerSchedule");
        vBox.getChildren().add(b2);
        Scene ultimateSchedule = new Scene(vBox, 456, 265);


        return ultimateSchedule;
    }
}
