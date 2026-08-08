package com.example.welfareassociation.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class ProfileDatabase {

    private static final ObservableList<Profile> profileList =
            FXCollections.observableArrayList();

    public static ObservableList<Profile> getProfileList() {
        return profileList;
    }

    public static void addProfile(Profile profile) {
        profileList.add(profile);
    }


}
