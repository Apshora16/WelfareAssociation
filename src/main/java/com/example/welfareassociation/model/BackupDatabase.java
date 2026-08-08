package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BackupDatabase {

    private static final ObservableList<Backup> backupList =
            FXCollections.observableArrayList();

    public static void addBackup(Backup backup) {
        backupList.add(backup);
    }

    public static ObservableList<Backup> getBackupList() {
        return backupList;
    }
}
