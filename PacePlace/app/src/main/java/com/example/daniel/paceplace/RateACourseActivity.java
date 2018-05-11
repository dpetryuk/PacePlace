package com.example.daniel.paceplace;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

public class RateACourseActivity extends Activity implements View.OnClickListener {

    private TextView course, prof;
    private RatingBar rate;
    private EditText comments;
    private Button submit;
    private String courseIntent, profIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rate_a_course);
        courseIntent = getIntent().getExtras().getString("course").trim();
        profIntent = getIntent().getExtras().getString("prof").trim();
        course = (TextView) findViewById(R.id.course);
        prof = (TextView) findViewById(R.id.prof);
        rate = (RatingBar) findViewById(R.id.ratingBar);
        comments = (EditText) findViewById(R.id.commentBox);
        submit = (Button) findViewById(R.id.submit);
        submit.setOnClickListener(this);
        course.setText(courseIntent);
        prof.setText(profIntent);
    }

    @Override
    public void onClick(View v) {
        rate.setIsIndicator(true);
        String comment = comments.getText().toString().trim();
        float rating = rate.getRating();
        switch (courseIntent){
            case "Algorithms & Computing Theory":
                CourseData.algoList.add(rating+"|"+comment);
                break;
            case "Artificial Intelligence":
                CourseData.aIList.add(rating+"|"+comment);
                break;
            case "Mobile Application Development":
                CourseData.mobList.add(rating+"|"+comment);
                break;
            case "Data Mining":
                CourseData.dmList.add(rating+"|"+comment);
                break;
        }

        Toast.makeText(this,"Ratings submitted", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(RateACourseActivity.this,CourseRatingsActivity.class);
        i.putExtra("course",courseIntent);
        i.putExtra("prof",profIntent);
        startActivity(i);
    }
}
