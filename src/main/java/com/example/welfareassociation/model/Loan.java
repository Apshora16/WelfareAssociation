package com.example.welfareassociation.model;

import java.io.Serializable;

public class Loan implements Serializable {

    private static final long serialVersionUID=1L;

    private String loanAmount;
    private String purpose;
    private String repaymentPeriod;
    private String document;
    private String status;


    public Loan(String loanAmount, String purpose, String repaymentPeriod, String document, String status) {
        this.loanAmount = loanAmount;
        this.purpose = purpose;
        this.repaymentPeriod = repaymentPeriod;
        this.document = document;
        this.status = status;
    }


    public String getLoanAmount() {
        return loanAmount;
    }

    public String getPurpose() {
        return purpose;
    }

    public String getRepaymentPeriod() {
        return repaymentPeriod;
    }

    public String getDocument() {
        return document;
    }

    public String getStatus() {
        return status;
    }


    public void setLoanAmount(String loanAmount) {
        this.loanAmount = loanAmount;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public void setRepaymentPeriod(String repaymentPeriod) {
        this.repaymentPeriod = repaymentPeriod;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Loan{" +
                "loanAmount='" + loanAmount + '\'' +
                ", purpose='" + purpose + '\'' +
                ", repaymentPeriod='" + repaymentPeriod + '\'' +
                ", document='" + document + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
