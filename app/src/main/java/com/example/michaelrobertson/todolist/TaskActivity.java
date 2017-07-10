package com.example.michaelrobertson.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class TaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        TaskList taskList = new TaskList();
        ArrayList<Task> list = taskList.getList();

        TaskAdapter taskAdapter = new TaskAdapter(this, list);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(taskAdapter);

    }
}
