package Controllers;

import View.UltimateSchedule;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Kuba on 2015-11-18.
 */
public class UltimateScheduleCtrl {

    UltimateSchedule ultimateSchedule= new UltimateSchedule();

    public Scene ctrGetUltimateSchedule(Stage stage){
        return ultimateSchedule.getUltimateSchedule(stage);

    }
}
