package Views;

import Controllers.AvailabilityController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends Application{
    AvailabilityController availabilityController;
    VBox loginVbox;
    VBox loginVbox2;
    HBox loginHbox;

    Label userNameLabel;
    Label passwordLabel;
    TextField loginTextField;
    TextField passwordTextField;
    Button loginButton;
    Button exitButton;
    Scene loginScene;
    Stage loginStage;
    BorderPane borderPane;

    public static void main(String[] args) {
    launch(args);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {

        createLoginView();
    }

    public void createLoginView() {
        loginVbox= new VBox();
        loginVbox2 = new VBox();
        loginHbox = new HBox();
        loginTextField= new TextField();
        passwordTextField= new TextField();
        userNameLabel = new Label("Insert User Name");
        userNameLabel.setStyle("-fx-font-size: 20px");
        passwordLabel = new Label("Insert Password");
        passwordLabel.setStyle("-fx-font-size: 20px");

        loginButton= new Button("Login");
        loginButton.setStyle("-fx-font-size: 20px");
        loginButton.setOnAction(event -> {
            hideWindow();
            availabilityController = new AvailabilityController();
            availabilityController.goToAvailabilityView();

        });

        exitButton = new Button("Exit");
        exitButton.setStyle("-fx-font-size: 20px");
        exitButton.setOnAction(event -> {
            loginStage.close();
        });
        loginVbox.getChildren().addAll(loginTextField, passwordTextField);
        loginVbox.setSpacing(25);
        loginVbox2.getChildren().addAll(userNameLabel, passwordLabel);
        loginVbox2.setSpacing(22);
        loginHbox.getChildren().addAll(loginButton, exitButton);


        borderPane = new BorderPane();

        borderPane.setLeft(loginVbox);
        borderPane.setCenter(loginVbox2);
        borderPane.setBottom(loginHbox);

        loginScene= new Scene(borderPane,340,160);
        loginStage= new Stage();
        loginStage.setTitle("Welcome to FK!");
        loginStage.setScene(loginScene);
        loginStage.show();
    }
    public void hideWindow(){
        loginStage.hide();
    }

}
