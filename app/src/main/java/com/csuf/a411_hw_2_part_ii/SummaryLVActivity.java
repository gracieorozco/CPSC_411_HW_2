package com.csuf.a411_hw_2_part_ii;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.csuf.a411_hw_2_part_ii.adapter.SummaryListAdapter;
import com.csuf.a411_hw_2_part_ii.model.Student;
import com.csuf.a411_hw_2_part_ii.model.StudentDB;
import com.csuf.a411_hw_2_part_ii.model.Course;

import java.util.ArrayList;

public class SummaryLVActivity extends Activity {

    protected Menu detailMenu;
    protected ListView mSummaryView;
    protected SummaryListAdapter ad;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_list_lv);
        createStudentObjects();
        mSummaryView = findViewById(R.id.summary_list_id);
        ad = new SummaryListAdapter();
        mSummaryView.setAdapter(ad);
    }

    public void addCourse() {
        Button btn = findViewById(R.id.add_course_button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View list = findViewById(R.id.course_list_id);

            }
        });
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

        StudentDB.getInstance().setStudentList(students);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_screen_menu, menu);
        menu.findItem(R.id.action_edit).setVisible(true);
        menu.findItem(R.id.action_done).setVisible(false);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(getApplicationContext(), PersonDetailsActivity.class);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }



}
