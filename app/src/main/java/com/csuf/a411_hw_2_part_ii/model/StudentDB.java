package com.csuf.a411_hw_2_part_ii.model;


import java.util.ArrayList;

public class StudentDB {
    private static final StudentDB ourInstance = new StudentDB();

    private ArrayList<Student> mStudentList;

    static public StudentDB getInstance() {
        return ourInstance;
    }

    public StudentDB() {
        createStudentObjects();
    }

    public ArrayList<Student> getStudentList() {
        return mStudentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        mStudentList = studentList;
    }

    protected void createStudentObjects() {
        Student student = new Student("Gracie", "Orozco", 333);
        ArrayList<Course> courses = new ArrayList<Course>();
        courses.add(new Course("CPSC 333", "B"));
        courses.add(new Course("MATH 150B", "C"));
        student.setCourses(courses);
        ArrayList<Student> students = new ArrayList<Student>();
        students.add(student);

        student = new Student("John", "Chang", 331111);
        courses = new ArrayList<Course>();
        courses.add(new Course("ENGL 101", "A"));
        student.setCourses(courses);
        students.add(student);
    }
}
