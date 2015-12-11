package Controllers;

import Models.DatabaseModel;
import Models.Employee;
import Views.LoginView;

/**
 * Created by Kuba on 2015-11-28.
 */
public class LoginController {
    DatabaseModel databaseModel= new DatabaseModel();

    LoginView loginView= new LoginView();


    public void goBackToLoginView(){
        loginView.createLoginView();
    }

    public Employee getAccesFromWithEmployeeInfo(String login, String password){
        return databaseModel.getAccesRetrieveEmployee(login,password);


    }

    public int getConfirmedEmpId() {
        return loginView.getConfirmedLoginIdToCtrl();
    }


    public String getConfirmedFullName() {
        return loginView.getConfirmedFullNameToCtrl();
    }










}
