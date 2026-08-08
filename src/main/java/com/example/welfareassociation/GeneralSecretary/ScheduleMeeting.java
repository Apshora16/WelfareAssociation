package com.example.welfareassociation.GeneralSecretary;

import java.io.Serializable;
import java.time.LocalDate;

public class ScheduleMeeting implements Serializable {

    private String meetingTitle;
    private LocalDate meetingDate;
    private String meetingTime;
    private String participants;
    private String agenda;

    public ScheduleMeeting() {
    }

    public ScheduleMeeting(String meetingTitle,
                           LocalDate meetingDate,
                           String meetingTime,
                           String participants,
                           String agenda) {
        this.meetingTitle = meetingTitle;
        this.meetingDate = meetingDate;
        this.meetingTime = meetingTime;
        this.participants = participants;
        this.agenda = agenda;
    }

    public String getMeetingTitle() {
        return meetingTitle;
    }

    public void setMeetingTitle(String meetingTitle) {
        this.meetingTitle = meetingTitle;
    }

    public LocalDate getMeetingDate() {
        return meetingDate;
    }

    public void setMeetingDate(LocalDate meetingDate) {
        this.meetingDate = meetingDate;
    }

    public String getMeetingTime() {
        return meetingTime;
    }

    public void setMeetingTime(String meetingTime) {
        this.meetingTime = meetingTime;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getAgenda() {
        return agenda;
    }

    public void setAgenda(String agenda) {
        this.agenda = agenda;
    }

    @Override
    public String toString() {
        return meetingTitle + " - " + meetingDate;
    }
}