package com.example.welfareassociation.GeneralSecretary;

import java.io.Serializable;

public class Announcement implements Serializable {

    private String announcementId;
    private String title;
    private String details;
    private String targetAudience;
    private String attachment;
    private String publishDate;
    private String status;

    public Announcement() {
    }

    public Announcement(String announcementId, String title,
                        String details, String targetAudience,
                        String attachment, String publishDate,
                        String status) {

        this.announcementId = announcementId;
        this.title = title;
        this.details = details;
        this.targetAudience = targetAudience;
        this.attachment = attachment;
        this.publishDate = publishDate;
        this.status = status;
    }

    public String getAnnouncementId() {
        return announcementId;
    }

    public void setAnnouncementId(String announcementId) {
        this.announcementId = announcementId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getTargetAudience() {
        return targetAudience;
    }

    public void setTargetAudience(String targetAudience) {
        this.targetAudience = targetAudience;
    }

    public String getAttachment() {
        return attachment;
    }

    public void setAttachment(String attachment) {
        this.attachment = attachment;
    }

    public String getPublishDate() {
        return publishDate;
    }

    public void setPublishDate(String publishDate) {
        this.publishDate = publishDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return announcementId + " - " + title;
    }
}