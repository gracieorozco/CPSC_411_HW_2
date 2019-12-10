package com.csuf.a411_hw_2_part_ii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.csuf.a411_hw_2_part_ii.adapter.SummaryListAdapter;
import com.csuf.a411_hw_2_part_ii.model.Course;
import com.csuf.a411_hw_2_part_ii.model.Student;
import com.csuf.a411_hw_2_part_ii.model.StudentDB;

import java.util.ArrayList;

public class SummaryLVActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected ListView mSummaryView;
    protected SummaryListAdapter ad;
    protected boolean existing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.person_list_lv);
        mSummaryView = findViewById(R.id.summary_list_id);
        existing = getIntent().getBooleanExtra("flag", false);
        if (!existing) {
            createStudentObjects();
            existing = true;
            ad = new SummaryListAdapter();
            mSummaryView.setAdapter(ad);
        } else {
            ad = new SummaryListAdapter();
            mSummaryView.setAdapter(ad);
        }
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
        intent.putExtra("flag", existing);
        startActivity(intent);
        return super.onOptionsItemSelected(item);
    }

}
