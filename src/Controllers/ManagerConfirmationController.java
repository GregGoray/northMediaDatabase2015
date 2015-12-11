package Controllers;

import Models.DatabaseModel;
import Models.Employee;
import Views.ManagerConfirmationView;

import java.util.ArrayList;

/**
 * Created by Kuba on 2015-12-08.
 */
public class ManagerConfirmationController {



    ManagerConfirmationView managerConfirmationView= new ManagerConfirmationView();

    public void goToManagerConfirmationView(){
        managerConfirmationView.availabilitiesView();
    }

    public ArrayList<Employee> getEmployeesForShiftConfirmation(String date, String shiftType){
        DatabaseModel databaseModel= new DatabaseModel();
        return databaseModel.getEmployeesForShiftConfirmation(date,shiftType);
    }
}
