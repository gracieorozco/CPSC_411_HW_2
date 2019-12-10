package com.csuf.a411_hw_2_part_ii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.csuf.a411_hw_2_part_ii.model.Course;
import com.csuf.a411_hw_2_part_ii.model.Student;
import com.csuf.a411_hw_2_part_ii.model.StudentDB;

import java.util.ArrayList;


public class PersonDetailsActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected int studentIndx;
    protected Student sObj = new Student();

    protected ArrayList<Student> students;
    protected boolean exist;
    protected String test;
    protected int testID;
    protected Course c;
    protected ArrayList<Course> courses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        studentIndx = getIntent().getIntExtra("StudentIndex", 0);
        exist = getIntent().getBooleanExtra("flag", true);
        TextView tv = findViewById(R.id.display_string_id);
        String origStr = (String) tv.getText();
        tv.setText(origStr + studentIndx);
        tv.setTextSize(24);

        add_course();

        students = StudentDB.getInstance().getStudentList();
        for (int i = 0; i < studentIndx; i++) {
            Log.d("Testing Log", "Name: " + StudentDB.getInstance().getStudentList().get(i).getFirstName() + "; ");
        }
    }

    protected void add_course() {
        Button btn = (Button) findViewById(R.id.add_course_button);
        btn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                View list = findViewById(R.id.course_list_id);
                list.setVisibility(View.VISIBLE);
            }
        });
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.detail_screen_menu, menu);
        menu.findItem(R.id.action_edit).setVisible(false);
        menu.findItem(R.id.action_done).setVisible(true);
        detailMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.p_first_name_id);
            editView.setEnabled(true);

            editView = findViewById(R.id.p_last_name_id);
            editView.setEnabled(true);

            editView = findViewById(R.id.p_cwid);
            editView.setEnabled(true);

            item.setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        }
        if (item.getItemId() == R.id.action_done) {
            sObj = new Student();
            EditText editView = findViewById(R.id.p_first_name_id);
            test = editView.getText().toString();
            if (test.matches("")) {
                test = "Default";
            }
            sObj.setFirstName(test);
            editView.setEnabled(false);

            editView = findViewById(R.id.p_last_name_id);
            test = editView.getText().toString();
            if (test.matches("")) {
                test = "Name";
            }
            sObj.setLastName(test);
            editView.setEnabled(false);

            editView = findViewById(R.id.p_cwid);
            test = editView.getText().toString();
            if (test.matches("")) {
                testID = 0;
                sObj.setCWID(testID);
            } else {
                sObj.setCWID(Integer.valueOf(editView.getText().toString()));
            }
            editView.setEnabled(false);

            editView = findViewById(R.id.course_id);
            c = new Course();
            test = editView.getText().toString();
            if (test.matches("")) {
                test = "No class";
            }
            c.setCID(test);
            editView.setEnabled(false);

            editView = findViewById(R.id.grade_id);
            test = editView.getText().toString();
            if (test.matches("")) {
                test = "No Grade";
            }
            c.setGrade(test);
            courses = new ArrayList<Course>();
            courses.add(c);
            sObj.setCourses(courses);
            editView.setEnabled(false);

            item.setVisible(false);
            detailMenu.findItem(R.id.action_edit).setVisible(true);

            students.add(sObj);
            StudentDB.getInstance().setStudentList(students);
            studentIndx = students.size();
            for (int i = 0; i < studentIndx; i++) {
                Log.d("Testing Log", "Name: " + StudentDB.getInstance().getStudentList().get(i).getFirstName() + "; ");
            }

            Intent intent = new Intent(getApplicationContext(), SummaryLVActivity.class);
            intent.putExtra("flag", exist);
            startActivity(intent);

        }
        return super.onOptionsItemSelected(item);
    }

}
