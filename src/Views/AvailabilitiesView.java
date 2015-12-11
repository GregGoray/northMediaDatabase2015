package Views;

import Controllers.CtrlShiftTypes;
import Controllers.EditProfileController;
import Controllers.LoginController;
import Controllers.UltimateScheduleController;
import Models.ShiftTypes;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 * Created by Kuba on 2015-11-28.
 */
public class AvailabilitiesView {

    public void startAvailabilityView() {

        availabilitiesView();
    }

    public void hideWindow(){
        availabilityViewStage.hide();
    }


    VBox availabilityBox;
    Button goToUltimateScheduleButton;
    Button editProfileButton;
    Scene availabilityViewScene;
    Stage availabilityViewStage;
    UltimateScheduleController ultimateScheduleController;
    EditProfileController editProfileController;

    /**
     * Gregory - availability view
     */
    CtrlShiftTypes ctrlShiftTypes = new CtrlShiftTypes();
    LoginController loginCtrl = new LoginController();
    Connection conn;
    Calendar cal;
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
    ArrayList<Label> labels= new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();

    //this is for the changing week slide
    HBox hBox;
    Label weekLabel;
    Button incrementByOneButton;
    Button decrementByOneButton;

    TableView table;

    Label windowLabel;

    Label typeOfShiftLabel;
    Label mondayLabel;
    Label tuesdayLabel;
    Label wednesdayLabel;
    Label thursdayLabel;
    Label fridayLabel;
    Label saturdayLabel;
    Label sundayLabel;

    Label nightShiftLabel;
    Label dayShiftLabel;
    Label eveningShiftLabel;

    Label ifLoggedInLabel;


    GridPane gridPane;
    BorderPane borderPane;


    int weekOfYear;

    public void availabilitiesView() {

        connection(); //connection with database


        cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);
        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(8);


        // currentDateLabels = createLabels(getArrayLabelDates());
        // setLabelsToGridPane(currentDateLabels);

        hBox = new HBox();

        decrementByOneButton = new Button("<");
        incrementByOneButton = new Button(">");
        weekLabel = new Label("WEEK: " + weekOfYear);

        ifLoggedInLabel = new Label();
        String confirmedFullName = loginCtrl.getConfirmedFullName();
        if(confirmedFullName != null) {
            ifLoggedInLabel.setText("Logged in as: " + confirmedFullName);
        }

        hBox.getChildren().addAll(decrementByOneButton, weekLabel, incrementByOneButton, ifLoggedInLabel);

        incrementByOneButton.setOnAction(event1 -> {
            incrementByOneButtonAction();
        });

        decrementByOneButton.setOnAction(event1 -> {
            decrementByOneButtonAction();
        });

        typeOfShiftLabel = new Label("Shift");
        mondayLabel = new Label("Monday");
        mondayLabel.setId("monday");
        tuesdayLabel = new Label("Tuesday");
        wednesdayLabel = new Label("Wednesday");
        thursdayLabel = new Label("Thursday");
        fridayLabel = new Label("Friday");
        saturdayLabel = new Label("Saturday");
        sundayLabel = new Label("Sunday");

        gridPane.setConstraints(typeOfShiftLabel, 0, 0);
        gridPane.setConstraints(mondayLabel, 1, 0);
        gridPane.setConstraints(tuesdayLabel, 2, 0);
        gridPane.setConstraints(wednesdayLabel, 3, 0);
        gridPane.setConstraints(thursdayLabel, 4, 0);
        gridPane.setConstraints(fridayLabel, 5, 0);
        gridPane.setConstraints(saturdayLabel, 6, 0);
        gridPane.setConstraints(sundayLabel, 7, 0);
        gridPane.getChildren().addAll(typeOfShiftLabel, mondayLabel,tuesdayLabel, wednesdayLabel, thursdayLabel, fridayLabel,
                saturdayLabel, sundayLabel);

        nightShiftLabel = new Label("Night");
        dayShiftLabel = new Label("Day");
        eveningShiftLabel = new Label("Evening");

        gridPane.setConstraints(nightShiftLabel, 0, 2);
        gridPane.setConstraints(dayShiftLabel, 0, 3);
        gridPane.setConstraints(eveningShiftLabel, 0, 4);
        gridPane.getChildren().addAll(nightShiftLabel, dayShiftLabel, eveningShiftLabel);

        createLabels();  // CREATING LABELS AND SETTING THEM TO GRID AT ROW 1 POSITIONS 1-7
        createButtons();



        /**
         * Edgaras table
         */
        borderPane = new BorderPane();
        table = new TableView();
        table.setStyle("-fx-font-size: 20px");
        windowLabel = new Label("Available employyes");
        windowLabel.setStyle("-fx-font-size: 35px");
        table.setEditable(true);
        TableColumn firstColumn = new TableColumn("ID");
        TableColumn secondColumn = new TableColumn("Name");
        TableColumn thirdColumn = new TableColumn("Phone");
        TableColumn fourthColumn = new TableColumn("Post");
        table.getColumns().addAll(firstColumn, secondColumn, thirdColumn, fourthColumn);

        Label labelOfWindow = new Label("List of available employees");
        labelOfWindow.setFont(javafx.scene.text.Font.font("Arial"));
        labelOfWindow.setStyle("-fx-font-size: 28px");


        VBox shit = new VBox();
        shit.getChildren().addAll(labelOfWindow, table);
       // borderPane.setCenter(gridPane);
        borderPane.setRight(shit);

        /**
         * end of Edgaras Table
         */

        borderPane.setTop(hBox);
        borderPane.setCenter(gridPane);
        availabilityViewStage = new Stage();
        availabilityViewScene = new Scene(borderPane, 1000, 600);
        availabilityViewScene.getStylesheets().add("Availability_CSS.css");
        availabilityViewStage.setScene(availabilityViewScene);
        availabilityViewStage.show();

    }




    /**
     * Buttons methods
     */

    public void  createButtons() {  // probably for model
        ShiftTypes[] shiftTypes= ctrlShiftTypes.getShiftTypes(); // getting values from Enum of ShiftTypes (via Controller)
        /***
         * buttons rely on labels text
         */
        int indexButton = 0; // initializing the reference to ArrayList<Button> buttons of the main scope

        for(int j=0; j<3; j++) {
            for(int i=0; i<7; i++) {
                String dates = labels.get(i).getText();
                String id = dates + shiftTypes[j]; // creating buttons Id
                Button button = new Button();
                /*ToggleButton button = new ToggleButton();
                     Image unselected = new Image("button.jpg");
                     Image selected = new Image("button.jpg");
                     ImageView    buttonImage = new ImageView(unselected);
                    button.setGraphic(buttonImage);*/
                    /*buttonImage.imageProperty().bind(Bindings
                                    .when(button.selectedProperty())
                                    .then(selected)
                                    .otherwise(unselected)
                    );*/
                button.setId(id);
                Date sqlDate = Date.valueOf(dates); // asigning a date of sql type Date
                String shiftType = shiftTypes[j].toString();
                boolean booked = ifAvailable(sqlDate, shiftTypes[j].toString(), 1);
                System.out.println(booked + id);
                if(booked == true) {

                    //button.setStyle("-fx-base: #00b300"); // green


                }

                button.setOnAction(event -> {
                    // check if(ifAvailable() != true) -> button is gray(person haven't clicked 'available for work' yet
                    if(ifAvailable(sqlDate, shiftType, 1 ) != true) { // then add availability
                        button.setStyle("-fx-base: #00b300"); // green
                        System.out.println(sqlDate.toString() + " " +shiftType);
                        addAvailability(sqlDate, shiftType, 1); // adding entry to availabilities table
                        System.out.println("green");
                    }
                    else {
                        removeAvailability(sqlDate, shiftType, 1); // remove entry
                        button.setStyle("-fx-base: #CCFFCC"); // gray

                    }
                    // send an update request for the particular button

                });
                buttons.add(button);
                gridPane.getChildren().add(button);
                gridPane.setConstraints(button, i+1, j+2);
                indexButton++;
            }
        }
    }

    public void updateButtons() {
        ShiftTypes[] shiftTypes = ctrlShiftTypes.getShiftTypes(); // getting values from Enum of ShiftTypes (via Controller)

        int indexButton = 0;

        for(int j=0; j<3; j++) {
            for (int i = 0; i < 7; i++) {

                String id = labels.get(i).getText() + shiftTypes[j];
                Button button = buttons.get(indexButton);
                button.setId(id);
                button.setOnAction(event -> {
                    System.out.println(id);

                });
                indexButton++;
            }
        }
    }

    /**
     * DATABASE Connection and METHODS:
     */

    public void addAvailability(Date dates, String shiftType, int empId) {
        // sql - INSERT INTO `northmediadatabase`.`availabilities` (`availabilityId`, `dates`, `shiftType`, `empId`) VALUES ('3', '2015-12-08', 'E', '1');

        String sql = "INSERT INTO availabilities (dates, shiftType, empId) " + "VALUES (?,?,?)";
        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDate(1, dates);
            preparedStatement.setString(2, shiftType);
            preparedStatement.setInt(3, empId);
            preparedStatement.executeUpdate();
            System.out.println("availability updated");
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }
    public void removeAvailability(Date dates, String shiftType, int empId) {

        String sql = "DELETE FROM availabilities WHERE dates = ? AND shiftType = ? AND empId = ?";

        try
        {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDate(1, dates);
            preparedStatement.setString(2, shiftType);
            preparedStatement.setInt(3, empId);
            preparedStatement.execute();
            System.out.println("removed");

        } catch (SQLException e)
        {
            e.printStackTrace();
        }
    }


    public boolean ifAvailable(Date dates, String shiftType, int empId) {
        boolean out = true;

        String sql = "SELECT confirmed FROM availabilities WHERE dates = ? AND shiftType = ? AND empId = ?";
        try {
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setDate(1, dates);
            preparedStatement.setString(2, shiftType);
            preparedStatement.setInt(3, empId);
            //preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.executeQuery();

           /* while(resultSet.next())
            {
                out = true;
                System.out.println("ResultSet" + resultSet.getString("availabilityId"));
            }*/

            if(resultSet.next() == false) {
                out = false;
            }
        } catch (SQLException e){
            e.printStackTrace();
        }catch (NullPointerException e){
            e.printStackTrace(); // if employee is working - then the record is not null, its present.
        }

        return out;
    }


    public void connection() {
        try {
            String DB_URL = "jdbc:mysql://localhost/northmediadatabase";
            String USER = "root";
            String PASS = "4ithrandir";
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            System.out.println("All Good");
            System.out.println("conn obj created" + conn + " message: ");
        } catch (SQLException e) {

            System.out.println("db errorrrrrr" + e.getMessage());
        }

    }



    public void incrementByOneButtonAction() {
        if(weekOfYear < 52) {
            weekOfYear = weekOfYear + 1;
            weekLabel.setText("WEEK: " + weekOfYear);
            updateDateLabels(labels);
            updateButtons();
            //String id = String.valueOf(weekOfYear);   // optionally setUp Id to the label to create connection with buttons...
            //weekLabel.setId(id);
        }
    }
    public void decrementByOneButtonAction() {
        if(weekOfYear > 1) {
            weekOfYear = weekOfYear - 1;
            weekLabel.setText("WEEK: " + weekOfYear);
            updateDateLabels(labels);
            updateButtons();
            //String id = String.valueOf(weekOfYear);  // optionally setUp Id to the label to create connection with buttons...
            //weekLabel.setId(id);
        }
    }

    /**
     *
     * Labels methods
     *
     */
    public void createLabels (){
        int[] weekDays = {2,3,4,5,6,7,1}; // because Sunday has number 1, we swap Monday(2) on that place - project requirements

        for(int i =0; i<7; i++) {    // 7 times we create a label, from MondayLable to SundayLabel

            //String weekDay = weekDays[i];
            cal.set(Calendar.WEEK_OF_YEAR, cal.get(Calendar.WEEK_OF_YEAR));
            cal.set(Calendar.DAY_OF_WEEK, weekDays[i]);
            String a= simpleDateFormat.format(cal.getTime());// labels Id format (date)
            Label label = new Label(); // creating a label
            label.setText(a);       // set tex to label
            labels.add(label);

            String id = String.valueOf(i+1); // prepare labelId (from 1 - Monday, to 7 - Sunday

            gridPane.getChildren().add(label); // put label to grid
            gridPane.setConstraints(label, i + 1, 1); // position label at column 1...7, row 1
        }


    }

    public void updateDateLabels (ArrayList<Label> labels) {
        weekLabel.setText("WEEK: " + weekOfYear);
        int[] weekDays = {2, 3, 4, 5, 6, 7, 1};
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd"); // sdf
        cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);


        //for (Label newDates : dates) {
        for (int i = 0; i < labels.size(); i++) {
            cal.set(Calendar.WEEK_OF_YEAR, weekOfYear);
            cal.set(Calendar.DAY_OF_WEEK, weekDays[i]);
            String a = sdf.format(cal.getTime());
            labels.get(i).setText(a);
        }
    }




}
