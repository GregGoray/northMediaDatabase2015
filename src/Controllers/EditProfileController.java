package Controllers;

import Views.EditProfileView;

/**
 * Created by Kuba on 2015-11-29.
 */
public class EditProfileController {

    EditProfileView editProfileView;

    public void goToEditProfileView(){
        editProfileView= new EditProfileView();
        editProfileView.createEditProfileView();

    }
}
