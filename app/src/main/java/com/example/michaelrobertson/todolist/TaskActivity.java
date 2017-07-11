package com.example.michaelrobertson.todolist;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Movie;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.example.michaelrobertson.todolist.R.id.checkbox;
import static com.example.michaelrobertson.todolist.R.id.done;

public class TaskActivity extends AppCompatActivity {



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
        TypeToken<ArrayList<Task>> taskArrayList = new TypeToken<ArrayList<Task>>() {
        };
        ArrayList<Task> listTaskItem = gson.fromJson(listTask, taskArrayList.getType());
        if (getIntent().getExtras() != null) {
            Task newTask = (Task) getIntent().getSerializableExtra("task");
            listTaskItem.add(newTask);
        }


//        for(Task task : listTaskItem){
//            if(task.getDone() != true){
////                Checkbox.isChecked();
//            }
//        }

        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("ListTask", gson.toJson(listTaskItem));
        editor.apply();

        TaskAdapter taskAdapter = new TaskAdapter(this, listTaskItem);

        ListView listView = (ListView) findViewById(R.id.list);

        listView.setAdapter(taskAdapter);
    }

    public void getTask(View listItem) {
        Task task = (Task) listItem.getTag();

        Intent intent = new Intent(this, ListActivity.class);
        intent.putExtra("task", task);
        startActivity(intent);
    }

    public void onAddClick(View view) {
        Intent intent = new Intent(this, AddTaskActivity.class);
        startActivity(intent);
    }
}
