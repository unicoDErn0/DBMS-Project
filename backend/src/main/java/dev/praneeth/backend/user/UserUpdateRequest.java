package dev.praneeth.backend.user;

import java.time.LocalDate;
import java.time.Period;

import dev.praneeth.backend.user.User.Gender;

import jakarta.persistence.*;

public class UserUpdateRequest {
    
    private String firstName;
    private String lastName;
    private String dob;

    @Transient
    private Integer age;
    private Gender gender;
    private String address;
    private String phone_number;
    private String email;


    // Getters and setters
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

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public Integer getAge() {
        LocalDate parsedDob = LocalDate.parse(this.dob);
        return Period.between(parsedDob, LocalDate.now()).getYears();
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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
}

