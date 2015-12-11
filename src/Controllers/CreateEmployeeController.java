package Controllers;

import Views.CreateEmployeeView;

/**
 * Created by Kuba on 2015-12-01.
 */
public class CreateEmployeeController {

    CreateEmployeeView createEmployeeView= new CreateEmployeeView();

    public void goToEditProfile(){

createEmployeeView.createEmployee();

    }
}
