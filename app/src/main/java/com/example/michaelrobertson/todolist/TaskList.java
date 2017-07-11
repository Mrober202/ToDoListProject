package com.example.michaelrobertson.todolist;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by michaelrobertson on 09/07/2017.
 */

public class TaskList {

    private ArrayList<Task> list;

    public TaskList() {
        Date date = new Date();
        list = new ArrayList<Task>();
        list.add(new Task("Physical", date, "Fix fense", true));
    }

    public ArrayList<Task> getList() {
        return new ArrayList<Task>(list);
    }
}
