package com.example.daniel.paceplace;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.sunfusheng.marqueeview.MarqueeView;

import java.util.ArrayList;
import java.util.List;

public class MapActivity extends AppCompatActivity {

    TouchImageView map;
    Drawable nycMapId;
    Drawable westchesterMapId;
    MarqueeView marqueeView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        map = findViewById(R.id.map);
        nycMapId = getResources().getDrawable(R.drawable.nyc_campus_map);
        westchesterMapId = getResources().getDrawable(R.drawable.westchester_campus_map);
        map.setImageDrawable(nycMapId);
        marqueeView = findViewById(R.id.marqueeView);

        configureSpinner();
        configureMarqueeViewWithFunFacts();





    }

    private void configureSpinner(){
        Spinner spinner = findViewById(R.id.mapSpinner);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.maps_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(onItemSelectedListener);

    }



    AdapterView.OnItemSelectedListener onItemSelectedListener = new AdapterView.OnItemSelectedListener() {
        @Override
        public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

            switch(i){
                case 0:
                    map.setImageDrawable(nycMapId);
                    Log.i("Clicked nyc:", "index = 0");
                    break;
                case 1:
                    map.setImageDrawable(westchesterMapId);
                    Log.i("Clicked westchester:", "index = 1");
                    break;
            }

        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

    private void configureMarqueeViewWithFunFacts(){
        List<String> funFacts = new ArrayList<>();
        int flipIntervalInMs = 4000;
        funFacts.add("Number of countries represented in student body – 136");
        funFacts.add("Clubs – 61 in PLV, 88 in NYC");
        funFacts.add("Student faculty ratio (as of 2016) – 16:1");
        funFacts.add("Gender: Female - 61%   Male - 39%");
        marqueeView.setFlipInterval(flipIntervalInMs); // 4s flip interval
        marqueeView.startWithList(funFacts);

    }

    @Override
    public void onStart() {
        super.onStart();
        marqueeView.startFlipping();
    }

    @Override
    public void onStop() {
        super.onStop();
        marqueeView.stopFlipping();
    }

}
