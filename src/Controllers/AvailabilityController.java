package Controllers;

import Views.AvailabilityView;

/**
 * Created by Kuba on 2015-11-28.
 */
public class AvailabilityController {

    AvailabilityView availabilityView;


    public void goToAvailabilityView(){
        availabilityView= new AvailabilityView();
        availabilityView.createAvailabilityView();


    }

}
