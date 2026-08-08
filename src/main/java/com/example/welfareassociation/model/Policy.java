package com.example.welfareassociation.model;

import java.io.Serializable;

public class Policy implements Serializable {

    private static final long serialVersionUID=1L;

    private String document,status,effectiveData;


    public Policy(String document, String status, String effectiveData) {
        this.document = document;
        this.status = status;
        this.effectiveData = effectiveData;
    }


    public String getDocument() {
        return document;
    }

    public String getStatus() {
        return status;
    }

    public String getEffectiveData() {
        return effectiveData;
    }


    public void setDocument(String document) {
        this.document = document;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setEffectiveData(String effectiveData) {
        this.effectiveData = effectiveData;
    }


    @Override
    public String toString() {
        return "Policy{" +
                "document='" + document + '\'' +
                ", status='" + status + '\'' +
                ", effectiveData='" + effectiveData + '\'' +
                '}';
    }
}
