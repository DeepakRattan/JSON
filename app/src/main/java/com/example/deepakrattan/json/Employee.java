package com.example.deepakrattan.json;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Deepak Rattan on 12-Apr-17.
 */

public class Employee implements Parcelable{
    private String name;
    private int id, salary;

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    protected Employee(Parcel in) {
        name = in.readString();
        id = in.readInt();
        salary = in.readInt();
    }

    public static final Creator<Employee> CREATOR = new Creator<Employee>() {
        @Override
        public Employee createFromParcel(Parcel in) {
            return new Employee(in);
        }

        @Override
        public Employee[] newArray(int size) {
            return new Employee[size];
        }
    };

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(id);
        dest.writeInt(salary);
    }
}
