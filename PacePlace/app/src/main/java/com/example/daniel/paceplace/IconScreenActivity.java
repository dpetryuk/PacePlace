package com.example.daniel.paceplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class IconScreenActivity extends AppCompatActivity {

    RelativeLayout mapLayout;
    RelativeLayout bookFinderLayout;
    RelativeLayout courseRaterLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_screen);
        setIconClickListeners();

    }

    private void setIconClickListeners(){

        mapLayout = findViewById(R.id.mapLayout);
        bookFinderLayout = findViewById(R.id.bookFinderLayout);
        courseRaterLayout = findViewById(R.id.courseRaterLayout);

        mapLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mapIntent = new Intent(IconScreenActivity.this, MapActivity.class);
                startActivity(mapIntent);
            }
        });

        bookFinderLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent bookIntent = new Intent(IconScreenActivity.this, BookFinderActivity.class);
                startActivity(bookIntent);
            }
        });

        courseRaterLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent courseIntent = new Intent(IconScreenActivity.this, CourseListDisplayActivity.class);
                startActivity(courseIntent);
            }
        });


    }
}
