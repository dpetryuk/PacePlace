package com.example.daniel.paceplace;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class CourseListDisplayActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private ListView courseListView;
    private String[] course = new String[] { "Algorithms & Computing Theory", "Artificial Intelligence",
            "Mobile Application Development", "Data Mining"};
    private String[] professor = new String[] { "Miguel Mosteiro", "David Benjamin", "Kachi Nwaobasi", "David Benjamin"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_courses_listview);
        CourseData.addAllData();
        courseListView = (ListView) findViewById(R.id.courseList);
        CourseAdapter adapter = new CourseAdapter(this, course, professor);
        courseListView.setAdapter(adapter);
        courseListView.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(this, CourseRatingsActivity.class);
        intent.putExtra("course",view.getTag().toString().trim());
        if (view.getTag().toString().trim().equalsIgnoreCase("Algorithms & Computing Theory")){
            intent.putExtra("prof",professor[0]);
        }else if(view.getTag().toString().trim().equalsIgnoreCase("Artificial Intelligence")){
            intent.putExtra("prof",professor[1]);
        }else if(view.getTag().toString().trim().equalsIgnoreCase("Mobile Application Development")){
            intent.putExtra("prof",professor[2]);
        }else{
            intent.putExtra("prof",professor[3]);
        }
        startActivity(intent);
    }
}
