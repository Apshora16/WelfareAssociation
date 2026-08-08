package com.example.welfareassociation.model;

import java.io.Serializable;

public class Training implements Serializable {

    private static final long serialVersionUID=1L;

    private String programName;
    private String programDate;
    private String status;


    public Training(String programName, String programDate, String status) {
        this.programName = programName;
        this.programDate = programDate;
        this.status = status;
    }


    public String getProgramName() {
        return programName;
    }

    public String getProgramDate() {
        return programDate;
    }

    public String getStatus() {
        return status;
    }


    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public void setProgramDate(String programDate) {
        this.programDate = programDate;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Training{" +
                "programName='" + programName + '\'' +
                ", programDate='" + programDate + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
