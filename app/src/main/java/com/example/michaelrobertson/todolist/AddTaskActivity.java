package com.example.michaelrobertson.todolist;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {

    EditText type_txt;
    EditText description_txt;
    EditText date_txt;
    Button save;
    String type;
    String description;
    String date;
    boolean done;
    Button btnDatePicker;
    int day, month, year;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_task);

        type_txt = (EditText)findViewById(R.id.type_txt);
        description_txt = (EditText)findViewById(R.id.description_txt);
        date_txt = (EditText)findViewById(R.id.date_txt);
        save = (Button)findViewById(R.id.save_button);
        btnDatePicker = (Button)findViewById(R.id.btnDatePicker);

        btnDatePicker.setOnClickListener(this);
    }


        @Override
    public void onClick(View button) {

            if (button == btnDatePicker) {

                final Calendar c = Calendar.getInstance();
                year = c.get(Calendar.YEAR);
                month = c.get(Calendar.MONTH);
                day = c.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog datePickerDialog = new DatePickerDialog(this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                date_txt.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                datePickerDialog.show();
            }

        }
            public void onSaveButtonClicked(View view) {
//            save info inputted by user.
                TaskList taskList = new TaskList();

                type =  type_txt.getText().toString();
                description = description_txt.getText().toString();
                date = date_txt.getText().toString();
                Date newDate = new Date(date);

                ArrayList<Task> newTasks = taskList.getList();
                Task newTask = new Task(type, newDate, description, done);
                newTasks.add(newTask);

                Intent intent = new Intent(this, TaskActivity.class);
                intent.putExtra("task", newTask);
                startActivity(intent);

                Toast.makeText(this, "You added a new task!", Toast.LENGTH_SHORT).show();
            }

    }

