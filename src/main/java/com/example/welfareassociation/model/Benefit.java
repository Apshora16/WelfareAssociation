package com.example.welfareassociation.model;

import java.io.Serializable;

public class Benefit implements Serializable {

    private static final long serialVersionUID=1L;

    private String benefitName;
    private String eligibility;
    private String status;


    public Benefit(String benefitName, String eligibility, String status) {
        this.benefitName = benefitName;
        this.eligibility = eligibility;
        this.status = status;
    }


    public String getBenefitName() {
        return benefitName;
    }

    public String getEligibility() {
        return eligibility;
    }

    public String getStatus() {
        return status;
    }


    public void setBenefitName(String benefitName) {
        this.benefitName = benefitName;
    }

    public void setEligibility(String eligibility) {
        this.eligibility = eligibility;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Benefit{" +
                "benefitName='" + benefitName + '\'' +
                ", eligibility='" + eligibility + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
