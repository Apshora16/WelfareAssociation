package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class BenefitDatabase {


    private static final ObservableList<Benefit> benefitList =
            FXCollections.observableArrayList();

    public static ObservableList<Benefit> getBenefitList() {
        return benefitList;
    }

    public static void addBenefit(Benefit benefit) {
        benefitList.add(benefit);
    }
}
