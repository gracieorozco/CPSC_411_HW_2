package com.csuf.a411_hw_2_part_ii.model;

import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();
    private ArrayList<Student> mStudentList;
    static public StudentDB getInstance() {
        return ourInstance;
    }

    public StudentDB() {
    }

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }
}
