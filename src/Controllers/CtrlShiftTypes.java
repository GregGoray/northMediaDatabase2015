package Controllers;


import Models.ShiftTypes;

/**
 * Created by Bob on 12/7/2015.
 */
public class CtrlShiftTypes {

    public ShiftTypes[] getShiftTypes() {
        ShiftTypes[] shiftTypes = new ShiftTypes[3];
         shiftTypes = ShiftTypes.values();

        return shiftTypes;
    }
}
