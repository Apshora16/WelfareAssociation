package com.example.welfareassociation.model;

import java.io.Serializable;

public class Assistance implements Serializable {

    private static final long serialVersionUID=1L;

    private String assistanceType;
    private String description;
    private String amount;
    private String document;
    private String status;


    public Assistance(String assistanceType, String description, String amount, String document, String status) {
        this.assistanceType = assistanceType;
        this.description = description;
        this.amount = amount;
        this.document = document;
        this.status = status;
    }


    public String getAssistanceType() {
        return assistanceType;
    }

    public String getDescription() {
        return description;
    }

    public String getAmount() {
        return amount;
    }

    public String getDocument() {
        return document;
    }

    public String getStatus() {
        return status;
    }


    public void setAssistanceType(String assistanceType) {
        this.assistanceType = assistanceType;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Assistance{" +
                "assistanceType='" + assistanceType + '\'' +
                ", description='" + description + '\'' +
                ", amount='" + amount + '\'' +
                ", document='" + document + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
