package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class FeedbackDatabase {

    private static final ObservableList<Feedback> feedbackList =
            FXCollections.observableArrayList();

    public static ObservableList<Feedback> getFeedbackList() {
        return feedbackList;
    }

    public static void addFeedback(Feedback feedback) {
        feedbackList.add(feedback);
    }
}
