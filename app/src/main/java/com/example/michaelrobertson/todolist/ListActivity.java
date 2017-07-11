package com.example.michaelrobertson.todolist;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class ListActivity extends AppCompatActivity {

    TextView singleType;
    TextView singleDesc;
    TextView singleDate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        singleType = (TextView)findViewById(R.id.single_type);
        singleDesc = (TextView)findViewById(R.id.single_desc);
        singleDate = (TextView)findViewById(R.id.single_date);


        Task task = (Task)getIntent().getExtras().get("task");
        singleType.setText(task.getType());
        singleDesc.setText(task.getDescription());
        singleDate.setText(task.getDate());

    }
}
