package com.example.welfareassociation.model;

import java.io.Serializable;

public class Feedback implements Serializable {

    private static final long serialVersionUID=1L;

    private String category;
    private String topic;
    private String description;
    private String status;


    public Feedback(String category, String topic, String description, String status) {
        this.category = category;
        this.topic = topic;
        this.description = description;
        this.status = status;
    }


    public String getCategory() {
        return category;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }


    public void setCategory(String category) {
        this.category = category;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setStatus(String status) {
        this.status = status;
    }


    @Override
    public String toString() {
        return "Feedback{" +
                "category='" + category + '\'' +
                ", topic='" + topic + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }
}
