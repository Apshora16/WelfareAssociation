package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class AssistanceDatabase {

    private static final ObservableList<Assistance> assistanceList =
            FXCollections.observableArrayList();

    public static ObservableList<Assistance> getAssistanceList() {
        return assistanceList;
    }

    public static void addAssistance(Assistance assistance) {
        assistanceList.add(assistance);
    }
}
