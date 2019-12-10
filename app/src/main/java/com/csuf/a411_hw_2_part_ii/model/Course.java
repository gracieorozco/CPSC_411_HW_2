package com.csuf.a411_hw_2_part_ii.model;

public class Course {
    protected String mCID;
    protected String mGrade;

    public Course() {

    }

    public Course(String cid, String grade) {
        mCID = cid;
        mGrade = grade;
    }

    public String getCID() {
        return mCID;
    }

    public void setCID(String cid) {
        mCID = cid;
    }

    public String getGrade() {
        return mGrade;
    }

    public void setGrade(String grade) {
        mGrade = grade;
    }

}
