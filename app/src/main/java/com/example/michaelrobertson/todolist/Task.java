package com.example.michaelrobertson.todolist;

import java.util.Date;

import static android.R.attr.priority;

/**
 * Created by michaelrobertson on 09/07/2017.
 */

public class Task {

    private String type;
    private Date date;
    private boolean done;
    private String description;

    public Task(String type, Date date, boolean done, String description) {
        this.type = type;
        this.date = date;
        this.done = done;
        this.description = description;
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
