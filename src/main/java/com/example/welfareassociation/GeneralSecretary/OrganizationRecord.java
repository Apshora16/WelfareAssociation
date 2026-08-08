package com.example.welfareassociation.GeneralSecretary;

import java.io.Serializable;

public class OrganizationRecord implements Serializable {

    private String recordTitle;
    private String recordCategory;
    private String recordInformation;
    private String uploadDocument;

    public OrganizationRecord() {
    }

    public OrganizationRecord(String recordTitle,
                              String recordCategory,
                              String recordInformation,
                              String uploadDocument) {
        this.recordTitle = recordTitle;
        this.recordCategory = recordCategory;
        this.recordInformation = recordInformation;
        this.uploadDocument = uploadDocument;
    }

    public String getRecordTitle() {
        return recordTitle;
    }

    public void setRecordTitle(String recordTitle) {
        this.recordTitle = recordTitle;
    }

    public String getRecordCategory() {
        return recordCategory;
    }

    public void setRecordCategory(String recordCategory) {
        this.recordCategory = recordCategory;
    }

    public String getRecordInformation() {
        return recordInformation;
    }

    public void setRecordInformation(String recordInformation) {
        this.recordInformation = recordInformation;
    }

    public String getUploadDocument() {
        return uploadDocument;
    }

    public void setUploadDocument(String uploadDocument) {
        this.uploadDocument = uploadDocument;
    }

    @Override
    public String toString() {
        return recordTitle + " - " + recordCategory;
    }
}