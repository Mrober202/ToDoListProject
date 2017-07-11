package com.example.michaelrobertson.todolist;

import android.app.DatePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.example.michaelrobertson.todolist.R.id.date;
import static com.example.michaelrobertson.todolist.R.id.date_txt;
import static com.example.michaelrobertson.todolist.R.id.description;

public class AddTaskActivity extends AppCompatActivity implements View.OnClickListener {

    EditText type_txt;
    EditText description_txt;
    EditText date_txt;
    Button save;
    String type;
    String description;
    String date;
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
                Task newTask = new Task(type, newDate, description);
                newTasks.add(newTask);

                Intent intent = new Intent(this, TaskActivity.class);
                intent.putExtra("task", newTask);
                startActivity(intent);
            }

    }
//        public boolean onTouch (View view){
//            DatePickerDialog datePickerDialog = new DatePickerDialog(
//                    this, AddTaskActivity.this, 2017, 07, 8);
//            datePickerDialog.show();
//            return true;
//        }
//
//
//        @Override
//        public void onDateSet (DatePicker datePicker,int year, int month, int day){
//            Date newDate = new Date();
//            newDate.setYear(year);
//            newDate.setMonth(month);
//            newDate.setDate(day);
//            date_txt.setText(newDate.toString());
//        }

