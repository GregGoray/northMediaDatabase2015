package Views;

import Controllers.AvailabilitiesViewController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

/**
 * Created by Kuba on 2015-11-29.
 */
public class EditProfileView {

    VBox editProfileBox;
    Button submitChangesButton;
    Button backButton;
    Scene editProfileScene;
    Stage editProfileStage;
    AvailabilitiesViewController availabilityController;

   /* public void createEditProfileView(){
        editProfileBox= new VBox();
        submitChangesButton= new Button("Submit changes");
        submitChangesButton.setOnAction(event1 -> {
            hideWindow();
            availabilityController= new AvailabilitiesViewController();
            availabilityController.goToAvailabilityView();
            //----------------------i was not sure so maybe the controller
            // object should be instantiated up there after the declaration of the claa?

        });
        backButton= new Button("Back");
        backButton.setOnAction(event -> {
            hideWindow();
            availabilityController = new AvailabilitiesViewController();
            availabilityController.goToAvailabilityView();

        });

        editProfileBox.getChildren().addAll(submitChangesButton,backButton);
        editProfileScene= new Scene(editProfileBox, 300,300);
        editProfileStage= new Stage();
        editProfileStage.setScene(editProfileScene);
        editProfileStage.show();

    }*/

    public void hideWindow(){
        editProfileStage.hide();
    }

}
