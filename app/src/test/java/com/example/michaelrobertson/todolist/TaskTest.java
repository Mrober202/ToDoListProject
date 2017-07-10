package com.example.michaelrobertson.todolist;

import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.assertEquals;

/**
 * Created by michaelrobertson on 09/07/2017.
 */

public class TaskTest {

    Task task;
    Date date;

    @Before
    public void before () {
        date = new Date();
        task = new Task("Physical", date, true, "Get Milk");
    }

    @Test
    public void getTypeTest() throws Exception {
        assertEquals("Physical", task.getType());
    }

    @Test
    public void getDateTest() throws Exception {
        assertEquals(date, task.getDate());
    }

    @Test
    public void getDoneTest() throws Exception {
        assertEquals(true, task.getDone());
    }

    @Test
    public void getDescroptionTest() throws Exception {
        assertEquals("Get Milk", task.getDescription());
    }
}
