package Controllers;

import Views.UltimateScheduleView;

/**
 * Created by Kuba on 2015-11-29.
 */
public class UltimateScheduleController {

    UltimateScheduleView ultimateScheduleView;

    public void goToUltimateScheduleView(){
        ultimateScheduleView= new UltimateScheduleView();
        ultimateScheduleView.createUltimateScheduleView();


    }


}
