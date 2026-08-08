package com.example.welfareassociation.model;

import java.io.Serializable;

public class Attendance implements Serializable {

    private static final long serialVersionUID=1L;

    private String date;
    private String checkIn;
    private String checkOut;
    private String status;
    private String hours;


    public Attendance(String date, String checkIn, String checkOut, String status, String hours) {
        this.date = date;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.status = status;
        this.hours = hours;
    }


    public String getDate() {
        return date;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public String getStatus() {
        return status;
    }

    public String getHours() {
        return hours;
    }


    public void setDate(String date) {
        this.date = date;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }


    @Override
    public String toString() {
        return "Attendance{" +
                "date='" + date + '\'' +
                ", checkIn='" + checkIn + '\'' +
                ", checkOut='" + checkOut + '\'' +
                ", status='" + status + '\'' +
                ", hours='" + hours + '\'' +
                '}';
    }
}
