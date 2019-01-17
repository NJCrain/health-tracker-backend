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
    public String title;
    public int quantity;
    public String description;
    public String timestamp;

    public Exercise(String title, int quantity, String description, String timestamp) {
        this.title = title;
        this.quantity = quantity;
        this.description = description;
        this.timestamp = timestamp;
    }

    public String toString() {
        return this.title + ": " + this.description + " - " + this.timestamp;
    }
}
