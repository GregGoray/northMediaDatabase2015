package Controllers;
import Run.Run;
import View.UltimateSchedule;
import View.LoginWindow;
import javafx.scene.Scene;
import javafx.stage.Stage;


/**
 * Created by Bob on 11/14/2015.
 */
public class GuiCtrl {
    Run run = new Run();
    /*UltimateSchedule ultimateSchedule= new UltimateSchedule();*/
    /*LoginWindow loginWindow= new LoginWindow();*/

    /*public Scene ctrGetUltimateSchedule(Stage stage){
        return ultimateSchedule.getUltimateSchedule(stage);

    }*/

    /*public Scene ctrGetLoginWindow(Stage stage){
        return loginWindow.setLoginScene(stage);

    }
*/
    public Stage setPrimaryStage() {

        return run.passPStage2Controller();
    }



}
