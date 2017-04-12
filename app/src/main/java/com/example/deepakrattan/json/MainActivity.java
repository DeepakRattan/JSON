package com.example.deepakrattan.json;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button btnCreateJson, btnParseJson, btnShowJsonInNextScreen;
    private TextView txtShow;
    private String jsonString, name;
    private int id, salary;
    private Employee emp;
    private ArrayList<Employee> employeeArrayList;
    private StringBuffer buffer;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //findViewByID
        btnCreateJson = (Button) findViewById(R.id.btnCreateJson);
        btnParseJson = (Button) findViewById(R.id.btnParseJson);
        txtShow = (TextView) findViewById(R.id.txtShow);
        btnShowJsonInNextScreen = (Button) findViewById(R.id.btnShowJsonInNextScreen);

        btnParseJson.setOnClickListener(this);
        btnCreateJson.setOnClickListener(this);
        btnShowJsonInNextScreen.setOnClickListener(this);
        employeeArrayList = new ArrayList<Employee>();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnCreateJson:
                try {
                    JSONObject object1 = new JSONObject();
                    object1.put("id", 101);
                    object1.put("name", "Deepak Rattan");
                    object1.put("salary", 50000);

                    JSONObject object2 = new JSONObject();
                    object2.put("id", 102);
                    object2.put("name", "Vikas Goyal");
                    object2.put("salary", 80000);

                    JSONArray employeeArray = new JSONArray();
                    employeeArray.put(object1);
                    employeeArray.put(object2);

                    JSONObject jsonObject = new JSONObject();
                    jsonObject.put("Employee", employeeArray);

                    jsonString = jsonObject.toString();
                    txtShow.setText(jsonString);

                } catch (JSONException e) {
                    e.printStackTrace();
                }


                break;
            case R.id.btnParseJson:
                //Parsing the JSON

                buffer = new StringBuffer();
                try {
                    JSONObject object = new JSONObject(jsonString);
                    JSONArray employee = object.getJSONArray("Employee");
                    for (int i = 0; i < employee.length(); i++) {
                        JSONObject jsonObject = (JSONObject) employee.get(i);
                        name = jsonObject.getString("name");
                        id = jsonObject.getInt("id");
                        salary = jsonObject.getInt("salary");

                        buffer.append(name + " " + id + " " + salary + "\n");

                        emp = new Employee(name, id, salary);
                        employeeArrayList.add(emp);

                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

                for(int i=0;i<employeeArrayList.size();i++){
                    Employee e= employeeArrayList.get(i);
                    int id = e.getId();
                    int salary = e.getSalary();
                    String name = e.getName();
                }

                txtShow.setText(buffer.toString());
                break;

            case R.id.btnShowJsonInNextScreen:
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putParcelableArrayListExtra("empArrayList",employeeArrayList);
                startActivity(intent);
        }

    }
}
