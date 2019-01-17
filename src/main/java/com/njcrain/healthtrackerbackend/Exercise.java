package com.njcrain.healthtrackerbackend;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Exercise {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    public long id;
    private String title;
    private int quantity;
    private String description;
    private String timestamp;

    public Exercise() {}
//
//    public Exercise(String title, int quantity, String description, String timestamp) {
//        this.title = title;
//        this.quantity = quantity;
//        this.description = description;
//        this.timestamp = timestamp;
//    }

    public String toString() {
        return this.title + ": " + this.description + " - " + this.timestamp;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getDescription() {
        return this.description;
    }

    public String getTitle() {
        return this.title;
    }

    public String getTimestamp() {
        return this.timestamp;
    }
}
