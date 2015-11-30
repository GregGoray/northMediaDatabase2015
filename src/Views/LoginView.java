package Views;

import Controllers.AvailabilityController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends Application{
    AvailabilityController availabilityController;
    VBox loginVbox;
    TextField loginTextField;
    TextField passwordTextField;
    Button loginButton;
    Scene loginScene;
    Stage loginStage;

    public static void main(String[] args) {
    launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        createLoginView();
    }

    public void createLoginView() {
        loginVbox= new VBox();
        loginTextField= new TextField();
        loginTextField.setPromptText("Login");
        passwordTextField= new TextField();
        passwordTextField.setPromptText("Password");
        loginButton= new Button("Login");
        loginButton.setOnAction(event -> {
            hideWindow();
            availabilityController= new AvailabilityController();
            availabilityController.goToAvailabilityView();

        });

        loginVbox.getChildren().addAll(loginTextField, passwordTextField, loginButton);
        loginScene= new Scene(loginVbox,300,300);
        loginStage= new Stage();
        loginStage.setScene(loginScene);
        loginStage.show();
    }
    public void hideWindow(){
        loginStage.hide();
    }

}
