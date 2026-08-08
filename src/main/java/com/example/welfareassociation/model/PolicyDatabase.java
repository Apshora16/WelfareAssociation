package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class PolicyDatabase {

    private static final ObservableList<Policy> policyList =
            FXCollections.observableArrayList();

    public static ObservableList<Policy> getPolicyList() {
        return policyList;
    }

    public static void addPolicy(Policy policy) {
        policyList.add(policy);
    }
}
