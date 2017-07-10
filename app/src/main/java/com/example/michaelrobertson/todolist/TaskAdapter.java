package com.example.michaelrobertson.todolist;

import android.app.DatePickerDialog;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static android.R.attr.startYear;
import static android.os.Build.VERSION_CODES.M;

/**
 * Created by michaelrobertson on 10/07/2017.
 */

public class TaskAdapter extends ArrayAdapter<Task> implements View.OnTouchListener, DatePickerDialog.OnDateSetListener {

    Context context;
    EditText date;

    public TaskAdapter(Context context, ArrayList<Task> tasks) {
        super(context, 0, tasks);
        this.context = context;
    }

    @Override
    public View getView (int position, View listItemView, ViewGroup parent) {
        if(listItemView == null) {
            listItemView= LayoutInflater.from(getContext()).inflate(R.layout.task_item, parent, false);
        }

        Task currentTask = getItem(position);

        TextView type = (TextView)listItemView.findViewById(R.id.type);
        type.setText(currentTask.getType().toString());

        TextView description = (TextView)listItemView.findViewById(R.id.description);
        description.setText(currentTask.getDescription().toString());

        CheckBox done = (CheckBox)listItemView.findViewById(R.id.done);
        done.setChecked(currentTask.getDone());

        date = (EditText)listItemView.findViewById(R.id.date);
        String currentTaskDate = currentTask.getDate();

        date.setText(currentTaskDate.toString());

        date.setOnTouchListener(this);

        listItemView.setTag(currentTask);

        return listItemView;
    }

    @Override
    public boolean onTouch(View view, MotionEvent motionevent) {
        Log.d("ToDoApp", "Clicked");

        DatePickerDialog datePickerDialog = new DatePickerDialog(
                context, TaskAdapter.this, 2017, 07, 8);
        datePickerDialog.show();
        return true;
    }

    @Override
    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
        Log.d("ToDoApp1", "Clicked on date");
        Date newDate = new Date();
        newDate.setYear(year);
        newDate.setMonth(month);
        newDate.setDate(day);
        date.setText(newDate.toString());
        Log.d("DATE", date.getText().toString());

    }

}
