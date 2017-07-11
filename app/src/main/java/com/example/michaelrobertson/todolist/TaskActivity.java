package com.example.michaelrobertson.todolist;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import static com.example.michaelrobertson.todolist.R.id.date;
import static com.example.michaelrobertson.todolist.R.id.date_txt;
import static com.example.michaelrobertson.todolist.R.id.edit_query;
import static com.example.michaelrobertson.todolist.R.id.type_txt;

public class TaskActivity extends AppCompatActivity {

    EditText type_txt;
    EditText description_txt;
    EditText date_txt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.task_list);

        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.list_file_key), Context.MODE_PRIVATE);
//        SharedPreferences.Editor delete = sharedPreferences.edit();
//        delete.clear();
//        delete.apply();
        String listTask = sharedPreferences.getString("ListTask", new ArrayList<Task>().toString());

        Gson gson = new Gson();
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>(){};
        ArrayList<Task> listTaskItem = gson.fromJson(listTask, taskArrayList.getType());
        if (getIntent().getExtras() != null) {
            Task newTask = (Task) getIntent().getSerializableExtra("task");
            listTaskItem.add(newTask);
        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ListTask", gson.toJson(listTaskItem));
        editor.apply();

        TaskAdapter taskAdapter = new TaskAdapter(this, listTaskItem);

        ListView listView = (ListView)findViewById(R.id.list);

        listView.setAdapter(taskAdapter);
    }

    public void getTask(View listItem) {
        Task task = (Task)listItem.getTag();

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("task", task);
    }

    public void onAddClick(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }

    public void onListClick(View view) {
        Intent intent = new Intent(this, TaskActivity.class);
        startActivity(intent);
    }
}
