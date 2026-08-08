package com.example.welfareassociation.model;

import java.io.Serializable;

public class ActivityLog implements Serializable {

    private static final long serialVersionUID=1L;

    private String activity,transaction,abnormalActivity;


    public ActivityLog() {
    }


    public ActivityLog(String activity, String transaction, String abnormalActivity) {
        this.activity = activity;
        this.transaction = transaction;
        this.abnormalActivity = abnormalActivity;
    }


    public String getActivity() {
        return activity;
    }

    public String getTransaction() {
        return transaction;
    }

    public String getAbnormalActivity() {
        return abnormalActivity;
    }


    public void setActivity(String activity) {
        this.activity = activity;
    }

    public void setTransaction(String transaction) {
        this.transaction = transaction;
    }

    public void setAbnormalActivity(String abnormalActivity) {
        this.abnormalActivity = abnormalActivity;
    }


    @Override
    public String toString() {

        return "ActivityLog{}";
    }
}
