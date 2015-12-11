package Views;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * Created by Kuba on 2015-12-01.
 */
public class CreateEmployeeView {


    //when they are all in global scope the create employee view shows up only once and then it shows some error



// VBox createEmployeeBox= new VBox();
/*TextField fullNameTextField = new TextField();
    Label fullNameLabel= new Label("Full name");
    HBox fullNameHbox= new HBox();
    TextField cityTextField= new TextField();
    Label cityLabel= new Label("City");
    HBox cityHbox= new HBox();
    TextField mobileTextField= new TextField();
    Label mobileLabel= new Label("Mobile");
    HBox mobileHbox= new HBox();
    TextField addressTextField = new TextField();
    Label addressLabel= new Label("Address");
    HBox addressHbox= new HBox();
    TextField postCodeTextField= new TextField();
    Label postCodeLabe= new Label("Post code");
    HBox postCodeHbox= new HBox();
    TextField nationTextField= new TextField();
    Label nationLabel= new Label("Nation");
    HBox nationHbox= new HBox();
    ImageView pictureImageView= new ImageView();
    Label pictureLabel= new Label();
    HBox pictureHbox= new HBox();
    Button createEmployeeButton= new Button("Create account");
    Scene createEmployeeScene= new Scene(createEmployeeBox, 300, 300);
    Stage createEmployeeStage= new Stage();*/

    public void createEmployee(){
        VBox createEmployeeBox= new VBox();
        TextField fullNameTextField = new TextField();
        Label fullNameLabel= new Label("Full name");
        HBox fullNameHbox= new HBox();
        TextField cityTextField= new TextField();
        Label cityLabel= new Label("City");
        HBox cityHbox= new HBox();
        TextField mobileTextField= new TextField();
        Label mobileLabel= new Label("Mobile");
        HBox mobileHbox= new HBox();
        TextField addressTextField = new TextField();
        Label addressLabel= new Label("Address");
        HBox addressHbox= new HBox();
        TextField postCodeTextField= new TextField();
        Label postCodeLabe= new Label("Post code");
        HBox postCodeHbox= new HBox();
        TextField nationTextField= new TextField();
        Label nationLabel= new Label("Nation");
        HBox nationHbox= new HBox();
        ImageView pictureImageView= new ImageView();
        Label pictureLabel= new Label();
        HBox pictureHbox= new HBox();
        Button createEmployeeButton= new Button("Create account");
        Scene createEmployeeScene= new Scene(createEmployeeBox, 300, 300);
        Stage createEmployeeStage= new Stage();
        fullNameHbox.getChildren().addAll(fullNameTextField,fullNameLabel);
        cityHbox.getChildren().addAll(cityTextField,cityLabel);
        mobileHbox.getChildren().addAll(mobileTextField,mobileLabel);
        addressHbox.getChildren().addAll(addressTextField,addressLabel);
        postCodeHbox.getChildren().addAll(postCodeTextField, postCodeLabe);
        nationHbox.getChildren().addAll(nationTextField, nationLabel);

        pictureImageView= new ImageView(new Image(getClass().getResourceAsStream("picture.gif")));
        pictureImageView.setOnMouseClicked(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("Open Resource File");
            fileChooser.showOpenDialog(new Stage());
        });
        pictureHbox.getChildren().addAll(pictureImageView,pictureLabel);

        createEmployeeBox.getChildren().addAll(fullNameHbox,cityHbox,mobileHbox,addressHbox,postCodeHbox,nationHbox,pictureHbox,createEmployeeButton);
        createEmployeeStage.setScene(createEmployeeScene);
        createEmployeeStage.show();
    }
}
