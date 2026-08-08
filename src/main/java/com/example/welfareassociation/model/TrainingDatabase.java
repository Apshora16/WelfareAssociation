package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class TrainingDatabase {

    private static final ObservableList<Training> trainingList =
            FXCollections.observableArrayList();

    public static ObservableList<Training> getTrainingList() {
        return trainingList;
    }

    public static void addTraining(Training training) {
        trainingList.add(training);
    }

}
