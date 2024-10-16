package dev.praneeth.backend.nurse;

public class Nurse {
    private Integer nurseID;
    private String firstName;
    private String lastName;
    private String phone_number;
    private String email;
    private Shift shift;

    public enum Shift {
        Morning,
        Evening,
        Night
    }

    // Constructors
    public Nurse() {}

    public Nurse(String firstName, String lastName, String phone_number, String email, Shift shift) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone_number = phone_number;
        this.email = email;
        this.shift = shift;
    }

    // Getters and Setters
    public Integer getNurseID() {
        return nurseID;
    }

    public void setNurseID(Integer nurseID) {
        this.nurseID = nurseID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Shift getShift() {
        return shift;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    @Override
    public String toString() {
        return "Nurse{" +
                "nurseID=" + nurseID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", email='" + email + '\'' +
                ", shift=" + shift +
                '}';
    }
}
