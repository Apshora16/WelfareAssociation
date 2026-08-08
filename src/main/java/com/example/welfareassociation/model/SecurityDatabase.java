package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class SecurityDatabase {

    private static final ObservableList<SecurityLog> securityLogs =
            FXCollections.observableArrayList();

    public static void addLog(SecurityLog log) {
        securityLogs.add(log);
    }

    public static ObservableList<SecurityLog> getSecurityLogs() {
        return securityLogs;
    }


    public static SecurityLog getLatestLog() {

        if (securityLogs.isEmpty()) {
            return null;
        }

        return securityLogs.get(securityLogs.size() - 1);
    }

}
