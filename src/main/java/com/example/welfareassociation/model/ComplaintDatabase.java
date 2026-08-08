package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ComplaintDatabase {

    private static final ObservableList<Complaint> complaintList =
            FXCollections.observableArrayList();

    public static ObservableList<Complaint> getComplaintList() {
        return complaintList;
    }

    public static void addComplaint(Complaint complaint) {
        complaintList.add(complaint);
    }
}
