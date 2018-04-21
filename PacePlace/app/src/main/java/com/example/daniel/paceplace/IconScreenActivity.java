package com.example.daniel.paceplace;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class IconScreenActivity extends AppCompatActivity {

    ImageView mapIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_icon_screen);
        setIconClickListeners();

    }

    private void setIconClickListeners(){

        mapIcon = findViewById(R.id.mapImage);

        mapIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(IconScreenActivity.this, MapActivity.class);
                startActivity(intent);

            }
        });


    }
}
