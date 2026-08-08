package com.example.welfareassociation.GeneralSecretary;

import java.io.Serializable;

public class DocumentProcessing implements Serializable {

    private String document;
    private String documentOwner;
    private String documentDetails;
    private String decision;
    private String remarks;

    public DocumentProcessing() {
    }

    public DocumentProcessing(String document,
                              String documentOwner,
                              String documentDetails,
                              String decision,
                              String remarks) {
        this.document = document;
        this.documentOwner = documentOwner;
        this.documentDetails = documentDetails;
        this.decision = decision;
        this.remarks = remarks;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDocumentOwner() {
        return documentOwner;
    }

    public void setDocumentOwner(String documentOwner) {
        this.documentOwner = documentOwner;
    }

    public String getDocumentDetails() {
        return documentDetails;
    }

    public void setDocumentDetails(String documentDetails) {
        this.documentDetails = documentDetails;
    }

    public String getDecision() {
        return decision;
    }

    public void setDecision(String decision) {
        this.decision = decision;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    @Override
    public String toString() {
        return document + " - " + documentOwner;
    }
}