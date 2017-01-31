package com.rohith.databases.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Employee {

    @JsonProperty
    private long personalNumber;

    @JsonProperty
    private String firstName;

    @JsonProperty
    private String lastName;

    public Employee(){}

    public Employee(long personalNumber, String firstName, String lastName) {
        this.personalNumber = personalNumber;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public Employee(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public Employee(long personalNumber, String firstName) {
        this.personalNumber = personalNumber;
        this.firstName = firstName;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
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
}
