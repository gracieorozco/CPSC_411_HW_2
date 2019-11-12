package com.csuf.a411_hw_2_part_ii;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.csuf.a411_hw_2_part_ii.model.Student;
import com.csuf.a411_hw_2_part_ii.model.StudentDB;

public class PersonDetailsActivity extends AppCompatActivity {

    protected Menu detailMenu;
    protected int studentIndx;
    protected Student sObj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_person_details);
        studentIndx = getIntent().getIntExtra("StudentIndex", 0);
        TextView tv = findViewById(R.id.display_string_id);
        String origStr = (String) tv.getText();
        tv.setText(origStr + studentIndx);
        tv.setTextSize(24);
        sObj = StudentDB.getInstance().getStudentList().get(studentIndx);
        EditText editView = findViewById(R.id.p_first_name_id);
        editView.setText(sObj.getFirstName());
        editView.setEnabled(false);
        editView = findViewById(R.id.p_last_name_id);
        editView.setText(sObj.getLastName());
        editView.setEnabled(false);
        editView = findViewById(R.id.p_cwid);
        editView.setText(String.valueOf(sObj.getCWID()));
        editView.setEnabled(false);
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
        if (item.getItemId() == R.id.action_edit) {
            EditText editView = findViewById(R.id.p_first_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.p_last_name_id);
            editView.setEnabled(true);
            editView = findViewById(R.id.p_cwid);
            editView.setEnabled(true);
            item.setVisible(false);
            detailMenu.findItem(R.id.action_done).setVisible(true);
        } else if (item.getItemId() == R.id.action_done) {
            EditText editView = findViewById(R.id.p_first_name_id);
            StudentDB.getInstance().getStudentList().get(studentIndx).setFirstName(editView.getText().toString());
            editView.setEnabled(false);
            editView = findViewById(R.id.p_last_name_id);
            StudentDB.getInstance().getStudentList().get(studentIndx).setLastName(editView.getText().toString());
            editView.setEnabled(false);
            editView = findViewById(R.id.p_cwid);
            StudentDB.getInstance().getStudentList().get(studentIndx).setCWID(Integer.valueOf(editView.getText().toString()));
            editView.setEnabled(false);
            item.setVisible(false);
            detailMenu.findItem(R.id.action_edit).setVisible(true);
        }
        return super.onOptionsItemSelected(item);
    }

}
