package com.example.daniel.paceplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

public class CourseRatingsActivity extends Activity {

    private ListView listView;
    private TextView courseName;
    private RatingAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings_listview);
        final String course = getIntent().getExtras().getString("course").trim();
        final String prof = getIntent().getExtras().getString("prof").trim();
        listView = (ListView) findViewById(R.id.ratingList);
        courseName = (TextView) findViewById(R.id.courseName);
        courseName.setText(course);
        if(course.equalsIgnoreCase("Algorithms & Computing Theory")){
            adapter = new RatingAdapter(this, CourseData.algoList);
        }else if(course.equalsIgnoreCase("Artificial Intelligence")){
            adapter = new RatingAdapter(this, CourseData.aIList);
        }else if(course.equalsIgnoreCase("Mobile Application Development")){
            adapter = new RatingAdapter(this, CourseData.mobList);
        }else if(course.equalsIgnoreCase("Data Mining")){
            adapter = new RatingAdapter(this, CourseData.dmList);
        }

        listView.setAdapter(adapter);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(CourseRatingsActivity.this, RateACourseActivity.class);
                intent.putExtra("course",course);
                intent.putExtra("prof",prof);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.notifyDataSetChanged();
    }
}
