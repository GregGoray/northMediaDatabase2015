package Views;

import Controllers.ManagerConfirmationController;
import Models.DatabaseModel;
import Models.Employee;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;


/**
 * Created by Edgaras on 12/1/2015.
 */
public class ManagerConfirmationView{

    Calendar cal;
    ArrayList<Label> labels= new ArrayList<>();
    ArrayList<Button> buttons = new ArrayList<>();

    //this is for the changing week slide
    HBox availabilitiesView;
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


    GridPane gridPane;
    GridPane customTableGridPane= new GridPane();

    BorderPane borderPane= new BorderPane();
    Scene scene;
    Stage stage;

    int weekOfYear;

    public VBox createCustomTable() {

        VBox customTableView = new VBox();
        Label customTableLabel= new Label("Employees");
        Label customTableLabel1 = new Label("Phone number");
        Label customTableLable2 = new Label("Post");

        HBox customTableHbox= new HBox();
        customTableHbox.setSpacing(20);
        customTableHbox.getChildren().addAll(customTableLabel, customTableLabel1, customTableLable2);




        //for (all elements of the array)


        customTableView.getChildren().addAll( customTableHbox, customTableGridPane);


        return customTableView;
    }

    public void updateCustomTable(String date, String shiftType){
        customTableGridPane.getChildren().clear();
        ManagerConfirmationController managerConfirmationController= new ManagerConfirmationController();
        ArrayList<Employee> employeesForShiftConfirmation= new ArrayList<>();
        employeesForShiftConfirmation=managerConfirmationController.getEmployeesForShiftConfirmation(date,shiftType);

        for (int i=0; i<employeesForShiftConfirmation.size(); i++){
            Label employeesNameLabel= new Label(employeesForShiftConfirmation.get(i).getFullName());
            Label employeesPhoneLabel = new Label(employeesForShiftConfirmation.get(i).getMobileNumber());
            Label employeesPostLabel = new Label(employeesForShiftConfirmation.get(i).getPostcode());

            CheckBox cb= new CheckBox();
          //  cb.setId(String.valueOf(employeesForShiftConfirmation.get(i).getAvailabilityId())); // to be fixed - add getAvailabilityId() in Models/Employee

            cb.setSelected(employeesForShiftConfirmation.get(i).getAvailability());
            cb.setOnAction(event -> {
                System.out.println(cb.getId());
                int avalID = Integer.parseInt(cb.getId());
                boolean shiftTypeTemp = cb.isSelected();

                DatabaseModel dbModel = new DatabaseModel();
                dbModel.updateConfirmedRow(avalID, shiftTypeTemp);

            });
            customTableGridPane.setConstraints(cb, 8, i);
            customTableGridPane.setConstraints(employeesNameLabel, 5, i);
            customTableGridPane.setConstraints(employeesPhoneLabel,6, i);
            customTableGridPane.setConstraints(employeesPostLabel, 7, i);
            customTableGridPane.setHgap(10);
            customTableGridPane.getChildren().addAll(employeesNameLabel, employeesPhoneLabel, employeesPostLabel, cb);


        }



    }


    public void availabilitiesView() {
        cal = Calendar.getInstance();
        cal.setFirstDayOfWeek(Calendar.MONDAY);
        weekOfYear = cal.get(Calendar.WEEK_OF_YEAR);

        System.out.println(Calendar.DATE);


        gridPane = new GridPane();
        gridPane.setPadding(new Insets(10, 10, 10, 10));
        gridPane.setVgap(8);
        gridPane.setHgap(8);


        // currentDateLabels = createLabels(getArrayLabelDates());
        // setLabelsToGridPane(currentDateLabels);

        availabilitiesView = new HBox();

        decrementByOneButton = new Button("<");
        incrementByOneButton = new Button(">");
        weekLabel = new Label("WEEK: " + weekOfYear);

        availabilitiesView.getChildren().addAll(decrementByOneButton, weekLabel, incrementByOneButton);

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
        /*borderPane = new BorderPane();
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
        borderPane.setCenter(gridPane);
        borderPane.setRight(shit);
*/
        /**
         * end of Edgaras Table
         */

        borderPane.setTop(availabilitiesView);
        borderPane.setCenter(gridPane);
        borderPane.setRight(createCustomTable());
        scene = new Scene(borderPane, 1000, 600);
        stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Buttons methods
     */

    public void  createButtons() {  // probably for model
        String[] shiftTypes= {"N","D","E"};
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd");
        /***
         * buttons rely on labels text
         */
        int indexButton = 0; // initializing the reference to ArrayList<Button> buttons of the main scope

        for(int j=0; j<3; j++) {
            for(int i=0; i<7; i++) {

                String id = labels.get(i).getText() + shiftTypes[j]; // creating buttons Id
                Button button = new Button();
                button.setId(id);
                button.setOnAction(event -> {
                    System.out.println(id);
                    String date = id.substring(0,10);
                    String shiftType = id.substring(10, 11);
                    updateCustomTable(date, shiftType);
                });
                buttons.add(button);

                gridPane.getChildren().add(button);
                gridPane.setConstraints(button, i+1, j+2);
                indexButton++;
            }
        }
    }

    public void updateButtons() {
        String[] shiftTypes= {"N","D","E"};
        int indexButton = 0;

        for(int j=0; j<3; j++) {
            for (int i = 0; i < 7; i++) {

                String id = labels.get(i).getText() + shiftTypes[j];
                Button button = buttons.get(indexButton);
                button.setId(id);
                button.setOnAction(event -> {
                    System.out.println(id);
                    String date = id.substring(0,10);
                    String shiftType = id.substring(10, 11);
                    updateCustomTable(date, shiftType);
                });
                indexButton++;
            }
        }
    }

    public void incrementByOneButtonAction() {
        if(weekOfYear < 52) {
            weekOfYear = weekOfYear + 1;
            weekLabel.setText("WEEK: " + weekOfYear);
            updateDateLabels(labels);
            updateButtons();
            customTableGridPane.getChildren().clear();
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
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy/MM/dd"); // simpleDateFormat
        //labelsId= new ArrayList<>(); // labelsId array
        int[] weekDays = {2,3,4,5,6,7,1}; // because Sunday has number 1, we swap Monday(2) on that place - project requirements

        for(int i =0; i<7; i++) {    // 7 times we create a label, from MondayLable to SundayLabel

            //String weekDay = weekDays[i];
            cal.set(Calendar.WEEK_OF_YEAR, cal.get(Calendar.WEEK_OF_YEAR));
            cal.set(Calendar.DAY_OF_WEEK, weekDays[i]);
            String a= simpleDateFormat.format(cal.getTime());// labels Id format (date)
            Label label = new Label(); // creating a label
            label.setText(a);       // set tex to label
            labels.add(label);

            String id = String.valueOf(i+1); // prepare labelId (from 1 - Monay, to 7 - Sunday

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
