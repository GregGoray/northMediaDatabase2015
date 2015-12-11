package Models;

import java.sql.*;
import java.util.ArrayList;

/**
 * Created by Kuba on 2015-12-01.
 */
public class DatabaseModel {
    Connection connection = null;

    public DatabaseModel() {

        String DB_URL = "jdbc:mysql://localhost/northmediadatabase";
        String USER = "root";
        String PASS = "4ithrandir";
        try {
            connection = DriverManager.getConnection(DB_URL, USER, PASS);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connected");
    }

    public Employee getAccesRetrieveEmployee(String login, String password) {
        String sql = "SELECT * FROM employees WHERE login= ? AND password= ?";
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                String ifManager = resultSet.getString(1);
                String fullName = resultSet.getString(2);
                String address = resultSet.getString(3);
                String city = resultSet.getString(4);
                String nationality = resultSet.getString(5);
                String mobileNumber = resultSet.getString(6);
                String postcode = resultSet.getString(7);
                String sLogin = resultSet.getString(8);
                String sPassword = resultSet.getString(9);
                String cpr = resultSet.getString(10);
                String picture = resultSet.getString(11);
                employee = new Employee(ifManager, fullName, address, city, nationality, mobileNumber, postcode, sLogin, sPassword, cpr, picture, employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return employee;
    }


    public void saveEmployeeInfoToDatabase(boolean ifManager, String fullName, String address, String city, String nationality, String mobileNumber, String postcode,
                                           String login, String password, String cpr, String picture) {
        String sql = "INSERT INTO employees VALUES(null,?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, ifManager);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, nationality);
            preparedStatement.setString(6, mobileNumber);
            preparedStatement.setString(7, postcode);
            preparedStatement.setString(8, login);
            preparedStatement.setString(9, password);
            preparedStatement.setString(10, cpr);
            preparedStatement.setString(11, picture);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public Employee getEmployeeInfoFromDatabase(int employeeId) {
        String sql = "SELECT * FROM employees WHERE empId= ?";
        Employee employee = null;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, employeeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                String ifManager = resultSet.getString(1);
                String fullName = resultSet.getString(2);
                String address = resultSet.getString(3);
                String city = resultSet.getString(4);
                String nationality = resultSet.getString(5);
                String mobileNumber = resultSet.getString(6);
                String postcode = resultSet.getString(7);
                String login = resultSet.getString(8);
                String password = resultSet.getString(9);
                String cpr = resultSet.getString(10);
                String picture = resultSet.getString(11);
                employee = new Employee(ifManager, fullName, address, city, nationality, mobileNumber, postcode, login, password, cpr, picture, employee);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return employee;
    }

    public void updateEmployeeInfoToDatabase(boolean ifManager, String fullName, String address, String city, String nationality, String mobileNumber, String postcode,
                                             String login, String password, String cpr, String picture) {
        String sql = "UPDATE employees SET ifManager=?, fullName=?, address=?, city= ?, nationality=?, mobileNumber=?, postcode=?, login=?, password=?, cpr=?, picture=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setBoolean(1, ifManager);
            preparedStatement.setString(2, fullName);
            preparedStatement.setString(3, address);
            preparedStatement.setString(4, city);
            preparedStatement.setString(5, nationality);
            preparedStatement.setString(6, mobileNumber);
            preparedStatement.setString(7, postcode);
            preparedStatement.setString(8, login);
            preparedStatement.setString(9, password);
            preparedStatement.setString(10, cpr);
            preparedStatement.setString(11, picture);
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }

    public ArrayList<Employee> getEmployeesForShiftConfirmation(String date, String shiftType) {
        ArrayList<Employee> employees = new ArrayList<>();

        String sql = "SELECT employees.empId, employees.fullName, employees.mobileNumber, employees.postcode,availabilities.confirmed FROM employees " +
                "JOIN availabilities " +
                "ON availabilities.empId = employees.empId " +
                "WHERE availabilities.date= ? AND availabilities.shiftType=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, shiftType);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int sEmpId = resultSet.getInt(1);/// we ll do that later
                String sFullName = resultSet.getString(2);
                String sMobileNumber = resultSet.getString(3);
                String sPostCode = resultSet.getString(4);
                boolean sConfirmed = resultSet.getBoolean(5);
                employees.add(new Employee(sEmpId, sFullName, sMobileNumber, sPostCode, sConfirmed));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }


    public ArrayList<Employee> getEmployeesForUltimateSchedule(String date, String shiftType, boolean confirmed) {
        ArrayList<Employee> employees = null;

        String sql = "SELECT /*employees.empId, */employees.fullName, employees.mobileNumber, employees.postcode FROM employees " +
                "JOIN availabilities " +
                "ON availabilities.empId = employees.empId " +
                "WHERE availabilities.date= ? AND availabilities.shiftType=? AND availabilities.confirmed=?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, date);
            preparedStatement.setString(2, shiftType);
            preparedStatement.setBoolean(3, confirmed);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                /*String sEmpId= resultSet.getString(1);*/// we ll do that later
                String sFullName = resultSet.getString(1);
                String sMobileNumber = resultSet.getString(2);
                String sPostCode = resultSet.getString(3);
                employees.add(new Employee(sFullName, sMobileNumber, sPostCode));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return employees;
    }

    public void updateConfirmedRow(int availabilityId, boolean shiftType) {//try this
        String shiftTypeVal;
        if (shiftType)// same as  (shiftType==true)
            shiftTypeVal = "1";
        else
            shiftTypeVal = "0";
        //ManagerConfirmationController managerConfirmationController= new ManagerConfirmationController();
        //ArrayList<Employee> employeesForShiftConfirmation= new ArrayList<>();
        // employeesForShiftConfirmation=managerConfirmationController.getEmployeesForShiftConfirmation(date, shiftType);
        String sql66 = "UPDATE availabilities SET confirmed = ? where availiabilityId=?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql66);
            preparedStatement.setString(1, shiftTypeVal);
            preparedStatement.setInt(2, availabilityId);
            int numberOfRows = preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Wrong!");
        }

    }
}
