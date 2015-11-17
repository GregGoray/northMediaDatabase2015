package Controllers;
import Run.Run;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Bob on 11/14/2015.
 */
public class GuiCtrl {
    Run run = new Run();

    public Stage setPrimaryStage() {

        return run.passPStage2Controller();
    }



}
