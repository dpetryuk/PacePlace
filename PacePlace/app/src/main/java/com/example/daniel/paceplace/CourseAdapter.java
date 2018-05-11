package com.example.daniel.paceplace;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class CourseAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] courseList, profList;
    private int mSelectedPosition;

    public CourseAdapter(@NonNull Context context, String[] courseList, String[] profList) {
        super(context, -1, courseList);
        this.context = context;
        this.courseList = courseList;
        this.profList = profList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if (convertView == null) {
            convertView = View.inflate(context, R.layout.course_list_item, null);
            ViewHolder viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        final ViewHolder viewHolder = (ViewHolder) convertView.getTag();

        //String[] data= list[position].split("//|");
        viewHolder.mCourseView.setText(courseList[position]);
        viewHolder.mProfessorView.setText(profList[position]);
        convertView.setTag(courseList[position]);
        return convertView;
    }

    // Sets position of clicked item in listview
    void setSelectedPosition(int position) {
        mSelectedPosition = position;
    }

    //Gets position of clicked item in listview
    int getSelectedPosition() {
        return mSelectedPosition;
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHolder{
        TextView mCourseView;
        TextView mProfessorView;

        ViewHolder(View item) {
            //Add All views for an item in the view holder
            mCourseView = item.findViewById(R.id.courseID);
            mProfessorView = item.findViewById(R.id.profName);


        }

    }

}
