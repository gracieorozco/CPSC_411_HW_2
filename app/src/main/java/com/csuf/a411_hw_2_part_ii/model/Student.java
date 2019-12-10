package com.csuf.a411_hw_2_part_ii.model;

import java.util.ArrayList;

public class Student {
    protected String mFirstName;
    protected String mLastName;
    protected int mCWID;

    protected ArrayList<Course> mCourses;

    public Student() {

    }

    public Student(String fName, String lName, int cwid) {
        mFirstName = fName;
        mLastName = lName;
        mCWID = cwid;
    }

    public String getFirstName() {
        return mFirstName;
    }

    public void setFirstName(String firstName) {
        mFirstName = firstName;
    }

    public String getLastName() {
        return mLastName;
    }

    public void setLastName(String lastName) {
        mLastName = lastName;
    }

    public int getCWID() {
        return mCWID;
    }

    public void setCWID(int cwid) {
        mCWID = cwid;
    }

    public ArrayList<Course> getCourses() {
        return mCourses;
    }

    public Course getCourse(int i) {
        ArrayList<Course> c = getCourses();
        return c.get(i);
    }

    public void setCourses(ArrayList<Course> courses) {
        mCourses = courses;
    }
}
