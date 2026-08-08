package com.example.welfareassociation.model;

import java.io.Serializable;

public class Complaint implements Serializable {

    private static final long serialVersionUID=1L;

    private String category;
    private String subject;
    private String description;
    private String evidence;
    private String status;


    public Complaint(String category, String subject, String description, String evidence, String status) {
        this.category = category;
        this.subject = subject;
        this.description = description;
        this.evidence = evidence;
        this.status = status;
    }


    public String getCategory() {
        return category;
    }

    public String getSubject() {
        return subject;
    }

    public String getDescription() {
        return description;
    }

    public String getEvidence() {
        return evidence;
    }

    public String getStatus() {
        return status;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setEvidence(String evidence) {
        this.evidence = evidence;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Complaint{" +
                "category='" + category + '\'' +
                ", subject='" + subject + '\'' +
                ", description='" + description + '\'' +
                ", evidence='" + evidence + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
