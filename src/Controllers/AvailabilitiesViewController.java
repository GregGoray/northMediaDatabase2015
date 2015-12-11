package Controllers;

import Views.AvailabilitiesView;

/**
 * Created by Kuba on 2015-11-28.
 */
public class AvailabilitiesViewController {

    AvailabilitiesView availabilitiesView = new AvailabilitiesView();


    public void startAvailabilitiesView() {
        availabilitiesView.startAvailabilityView();
    }
}
