package Models;

/**
 * Created by Kuba on 2015-12-01.
 */
public class Employee {

    public String getIfManager() {
        return ifManager;
    }

    public void setIfManager(String ifManager) {
        this.ifManager = ifManager;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCpr() {
        return cpr;
    }

    public void setCpr(String cpr) {
        this.cpr = cpr;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
    private int empId;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    String ifManager; // later boolean
    String fullName;
    String address;
    String city;
    String nationality;
    String mobileNumber;
    String postcode;
    String login;
    String password;
    String cpr;
    String picture;
    Employee employee;

    public Boolean getAvailability() {
        return availability;
    }

    public void setAvailability(Boolean availability) {
        this.availability = availability;
    }

    Boolean availability;



    public Employee(String ifManager, String fullName, String address, String city, String nationality, String mobileNumber, String postcode, String login, String password, String cpr, String picture, Employee employee) {
        this.ifManager = ifManager;
        this.fullName = fullName;
        this.address = address;
        this.city = city;
        this.nationality = nationality;
        this.mobileNumber = mobileNumber;
        this.postcode = postcode;
        this.login = login;
        this.password = password;
        this.cpr = cpr;
        this.picture = picture;
        this.employee = employee;
    }

    public Employee(String fullName, String mobileNumber, String postcode) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.postcode = postcode;
    }

    public Employee(String fullName, String mobileNumber, String postcode,boolean availability) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.postcode = postcode;
        this.availability= availability;
    }
    public Employee(int empId,String fullName, String mobileNumber, String postcode,boolean availability) {
        this.empId=empId;
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;
        this.postcode = postcode;
        this.availability= availability;
    }
}
