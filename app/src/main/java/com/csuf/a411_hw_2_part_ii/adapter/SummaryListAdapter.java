package com.csuf.a411_hw_2_part_ii.adapter;


import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.csuf.a411_hw_2_part_ii.PersonDetailsActivity;
import com.csuf.a411_hw_2_part_ii.R;
import com.csuf.a411_hw_2_part_ii.model.Student;
import com.csuf.a411_hw_2_part_ii.model.StudentDB;

public class SummaryListAdapter extends BaseAdapter {
    @Override
    public int getCount() {
        return StudentDB.getInstance().getStudentList().size();
    }

    @Override
    public Object getItem(int i) {
        return StudentDB.getInstance().getStudentList().get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View row_view;
        if (view == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            row_view = inflater.inflate(R.layout.person_row, viewGroup, false);
        } else row_view = view;
        Student s = StudentDB.getInstance().getStudentList().get(i);
        ((TextView) row_view.findViewById(R.id.first_name)).setText(s.getFirstName() + " ");
        ((TextView) row_view.findViewById(R.id.last_name)).setText(s.getLastName() + " ");
        ((TextView) row_view.findViewById(R.id.cwid)).setText(String.valueOf(s.getCWID()));
        row_view.setTag(new Integer(i));
        row_view.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(view.getContext(), PersonDetailsActivity.class);
                        intent.putExtra("StudentIndex", ((Integer)view.getTag()).intValue());
                        view.getContext().startActivity(intent);
                    }
                }
        );
        return row_view;
    }
}
