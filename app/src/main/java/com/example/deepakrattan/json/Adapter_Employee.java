package com.example.deepakrattan.json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Deepak Rattan on 12-Apr-17.
 */

public class Adapter_Employee extends BaseAdapter {

    private Context context;
    private ArrayList<Employee> employeeArrayList;
    private LayoutInflater inflater;

    public Adapter_Employee(Context context, ArrayList<Employee> employeeArrayList) {
        this.context = context;
        this.employeeArrayList = employeeArrayList;
    }

    @Override
    public int getCount() {
        return employeeArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return employeeArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        view = inflater.inflate(R.layout.employee, parent, false);
        TextView txtName = (TextView) view.findViewById(R.id.txtName);
        TextView txtId = (TextView) view.findViewById(R.id.txtId);
        TextView txtSalary = (TextView) view.findViewById(R.id.txtSalary);

        Employee e = employeeArrayList.get(position);
        String name = e.getName();
        int id = e.getId();
        int salary = e.getSalary();

        txtName.setText(name);
        txtId.setText(String.valueOf(id));
        txtSalary.setText(String.valueOf(salary));
        return view;
    }
}
