package com.example.welfareassociation.GeneralSecretary;

import java.io.Serializable;

public class ActivityMonitoring implements Serializable {

    private String activityId;
    private String activityName;
    private String activityStatus;
    private String completionPercentage;
    private String activitySummary;

    public ActivityMonitoring() {
    }

    public ActivityMonitoring(String activityId, String activityName,
                              String activityStatus, String completionPercentage,
                              String activitySummary) {
        this.activityId = activityId;
        this.activityName = activityName;
        this.activityStatus = activityStatus;
        this.completionPercentage = completionPercentage;
        this.activitySummary = activitySummary;
    }

    public String getActivityId() {
        return activityId;
    }

    public void setActivityId(String activityId) {
        this.activityId = activityId;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityStatus() {
        return activityStatus;
    }

    public void setActivityStatus(String activityStatus) {
        this.activityStatus = activityStatus;
    }

    public String getCompletionPercentage() {
        return completionPercentage;
    }

    public void setCompletionPercentage(String completionPercentage) {
        this.completionPercentage = completionPercentage;
    }

    public String getActivitySummary() {
        return activitySummary;
    }

    public void setActivitySummary(String activitySummary) {
        this.activitySummary = activitySummary;
    }

    @Override
    public String toString() {
        return activityId + " - " + activityName;
    }
}