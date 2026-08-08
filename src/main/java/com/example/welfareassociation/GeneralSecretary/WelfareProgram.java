package com.example.welfareassociation.GeneralSecretary;

import java.io.Serializable;
import java.time.LocalDate;

public class WelfareProgram implements Serializable {

    private String programName;
    private String description;
    private String eligibilityCriteria;
    private LocalDate deadline;
    private String welfareOfficer;

    public WelfareProgram() {
    }

    public WelfareProgram(String programName,
                          String description,
                          String eligibilityCriteria,
                          LocalDate deadline,
                          String welfareOfficer) {
        this.programName = programName;
        this.description = description;
        this.eligibilityCriteria = eligibilityCriteria;
        this.deadline = deadline;
        this.welfareOfficer = welfareOfficer;
    }

    public String getProgramName() {
        return programName;
    }

    public void setProgramName(String programName) {
        this.programName = programName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getEligibilityCriteria() {
        return eligibilityCriteria;
    }

    public void setEligibilityCriteria(String eligibilityCriteria) {
        this.eligibilityCriteria = eligibilityCriteria;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }

    public String getWelfareOfficer() {
        return welfareOfficer;
    }

    public void setWelfareOfficer(String welfareOfficer) {
        this.welfareOfficer = welfareOfficer;
    }

    @Override
    public String toString() {
        return programName + " - " + deadline;
    }
}