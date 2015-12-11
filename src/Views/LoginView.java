package Views;

import Controllers.AvailabilitiesViewController;
import Controllers.LoginController;
import Controllers.ManagerConfirmationController;
import Models.Employee;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class LoginView extends Application{

    ManagerConfirmationController managerConfirmationController= new ManagerConfirmationController();

    LoginController loginController;
    private int confirmedLoginId;
    private String confirmedFullName;

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
        AvailabilitiesViewController availabilitiesCtrl= new AvailabilitiesViewController();
        loginController= new LoginController(); // when i put it in global scope it runs over and over again

        loginVbox= new VBox();
        loginTextField= new TextField();
        loginTextField.setText("man"); // so we dont have to write it every time
        loginTextField.setPromptText("Login");
        passwordTextField= new TextField();
        passwordTextField.setText("1");// so we dont have to write it every time
        passwordTextField.setPromptText("Password");
        loginButton= new Button("Login");
        loginButton.setOnAction(event -> {

                    Employee employee = loginController.getAccesFromWithEmployeeInfo(loginTextField.getText(), passwordTextField.getText());
                    confirmedLoginId = employee.getEmpId();
                    confirmedFullName = employee.getFullName();
                    availabilitiesCtrl.startAvailabilitiesView();
          /*  if((employee!=null))
            {
                hideWindow();
                if(employee.getIfManager().equals("1")){


                    //managerConfirmationController.goToManagerConfirmationView();


                }
                else {
                    System.out.println("Incorrect login or passwd");

                }
            }
        });*/
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

    public int getConfirmedLoginIdToCtrl() {
        return confirmedLoginId;
    }

    public String getConfirmedFullNameToCtrl() {
        return confirmedFullName;
    }

    public void swapScene(Scene scene) {
        loginStage.setScene(scene);
    }

}
