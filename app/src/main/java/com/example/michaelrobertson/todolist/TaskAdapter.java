package com.example.michaelrobertson.todolist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
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

public class TaskAdapter extends ArrayAdapter<Task> {

    Context context;

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

        TextView date = (TextView)listItemView.findViewById(R.id.date);
        date.setText(currentTask.toString());

        listItemView.setTag(currentTask);

        return listItemView;
    }




}
