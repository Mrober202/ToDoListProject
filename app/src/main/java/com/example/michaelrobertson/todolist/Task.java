package com.example.michaelrobertson.todolist;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by michaelrobertson on 09/07/2017.
 */

public class Task implements Serializable {

    private String type;
    private Date date;
    private boolean done;
    private String description;

    public Task(String type, Date date, String description, boolean done) {
        this.type = type;
        this.date = date;
        this.description = description;
        this.done = done;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDate() {
        return date.toString();
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public boolean getDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
