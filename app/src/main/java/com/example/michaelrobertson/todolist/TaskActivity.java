package com.example.michaelrobertson.todolist;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

import static com.example.michaelrobertson.todolist.R.id.date;
import static com.example.michaelrobertson.todolist.R.id.date_txt;
import static com.example.michaelrobertson.todolist.R.id.type_txt;

public class TaskActivity extends AppCompatActivity {

    EditText type_txt;
    EditText description_txt;
    EditText date_txt;
    String type;
    String description;
    String date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        TaskList taskList = new TaskList();
        ArrayList<Task> list = taskList.getList();

        TaskAdapter taskAdapter = new TaskAdapter(this, list);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(taskAdapter);


        type = SavedPreferences.getStoredText(this);
        description = SavedPreferences.getStoredText(this);
        date = SavedPreferences.getStoredText(this);


    }


    public void onAddClick(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }
}
