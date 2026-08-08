package com.example.welfareassociation.model;

import java.io.Serializable;

public class Backup implements Serializable {

    private static final long serialVersionUID=1L;

    private String backupSource,backupLocation,backupData,backupStatus;


    public Backup(String backupSource, String backupLocation, String backupData, String backupStatus) {
        this.backupSource = backupSource;
        this.backupLocation = backupLocation;
        this.backupData = backupData;
        this.backupStatus = backupStatus;
    }

    public String getBackupSource() {
        return backupSource;
    }

    public String getBackupLocation() {
        return backupLocation;
    }

    public String getBackupData() {
        return backupData;
    }

    public String getBackupStatus() {
        return backupStatus;
    }


    public void setBackupSource(String backupSource) {
        this.backupSource = backupSource;
    }

    public void setBackupLocation(String backupLocation) {
        this.backupLocation = backupLocation;
    }

    public void setBackupData(String backupData) {
        this.backupData = backupData;
    }

    public void setBackupStatus(String backupStatus) {
        this.backupStatus = backupStatus;
    }


    @Override
    public String toString() {
        return "Backup{" +
                "backupSource='" + backupSource + '\'' +
                ", backupLocation='" + backupLocation + '\'' +
                ", backupData='" + backupData + '\'' +
                ", backupStatus='" + backupStatus + '\'' +
                '}';
    }
}
