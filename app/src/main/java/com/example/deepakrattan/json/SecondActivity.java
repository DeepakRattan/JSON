package com.example.deepakrattan.json;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class SecondActivity extends AppCompatActivity {
    private ListView lv;
    private ArrayList<Employee> employeeArrayList;
    private Adapter_Employee adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        lv = (ListView) findViewById(R.id.lv);

        employeeArrayList = getIntent().getParcelableArrayListExtra("empArrayList");
        adapter = new Adapter_Employee(this,employeeArrayList);



        lv.setAdapter(adapter);


    }
}
