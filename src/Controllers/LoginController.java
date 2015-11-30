package Controllers;

import Views.LoginView;

/**
 * Created by Kuba on 2015-11-28.
 */
public class LoginController {

    LoginView loginView= new LoginView();


    public void goBackToLoginView(){
        loginView.createLoginView();
    }




}
