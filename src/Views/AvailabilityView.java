package Views;

import Controllers.EditProfileController;
import Controllers.UltimateScheduleController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.Calendar;

/**
 * Created by Kuba on 2015-11-28.
 */
public class AvailabilityView {
    VBox availabilityBox;
    Button goToUltimateScheduleButton;
    Button editProfileButton;
    Scene availabilityViewScene;
    Stage availabilityViewStage;
    UltimateScheduleController ultimateScheduleController;
    EditProfileController editProfileController;


    public void createAvailabilityView(){

        availabilityBox= new VBox();
        DatePicker datePicker = new DatePicker();
        CheckBox checkbox= new CheckBox();
        checkbox.setId("box");

        goToUltimateScheduleButton= new Button("See your schedule");
        goToUltimateScheduleButton.setOnAction(event -> {
            hideWindow();
            ultimateScheduleController= new UltimateScheduleController();
            ultimateScheduleController.goToUltimateScheduleView();
        });
        editProfileButton= new Button("Edit your profile");
        editProfileButton.setId("but");
        editProfileButton.setOnAction(event -> {
            hideWindow();
            editProfileController = new EditProfileController();
            editProfileController.goToEditProfileView();

        });
        availabilityBox.getChildren().addAll(datePicker, checkbox, goToUltimateScheduleButton, editProfileButton);
        availabilityViewScene= new Scene(availabilityBox,300,300);
        availabilityViewScene.getStylesheets().add(AvailabilityView.class.getResource("style.css").toExternalForm());
        availabilityViewStage= new Stage();
        availabilityViewStage.setScene(availabilityViewScene);
        availabilityViewStage.show();
    }

    public void hideWindow(){
        availabilityViewStage.hide();
    }

}
