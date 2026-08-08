package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ActivityDatabase {

    private static final ObservableList<ActivityLog> activityList =
            FXCollections.observableArrayList();

    public static void addActivity(ActivityLog activity) {

        activityList.add(activity);

    }

    public static ObservableList<ActivityLog> getActivityList() {

        return activityList;

    }

    public static void clearActivities() {

        activityList.clear();

    }


}
