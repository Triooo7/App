package com.rohith.databases.Entity;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VisitorLogRegistry {

    @JsonProperty
    private String visitorName;

    @JsonProperty
    private long hostId;

    @JsonProperty
    private String entryTime;

    @JsonProperty
    private String exitTime;

    public VisitorLogRegistry(){}

    public VisitorLogRegistry(String visitorName, long hostId, String entryTime) {
        this.visitorName = visitorName;
        this.hostId = hostId;
        this.entryTime = entryTime;
    }

    public VisitorLogRegistry(String visitorName, long hostId, String entryTime, String exitTime) {
        this.visitorName = visitorName;
        this.hostId = hostId;
        this.entryTime = entryTime;
        this.exitTime = exitTime;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public long getHostId() {
        return hostId;
    }

    public void setHostId(long hostId) {
        this.hostId = hostId;
    }

    public String getEntryTime() {
        return entryTime;
    }

    public void setEntryTime(String entryTime) {
        this.entryTime = entryTime;
    }

    public String getExitTime() {
        return exitTime;
    }

    public void setExitTime(String exitTime) {
        this.exitTime = exitTime;
    }
}
