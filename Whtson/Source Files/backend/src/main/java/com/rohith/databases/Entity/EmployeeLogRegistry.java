package com.rohith.databases.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EmployeeLogRegistry {

    @JsonProperty
    private long personalNumber;

    @JsonProperty
    private String exitTime;

    @JsonProperty
    private String entryTime;

    public EmployeeLogRegistry(){}

    public EmployeeLogRegistry(long personalNumber, String exitTime, String entryTime) {
        this.personalNumber = personalNumber;
        this.exitTime = exitTime;
        this.entryTime = entryTime;
    }

    public EmployeeLogRegistry(long personalNumber, String entryTime) {
        this.personalNumber = personalNumber;
        this.entryTime = entryTime;
    }

    public long getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(long personalNumber) {
        this.personalNumber = personalNumber;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }
}

