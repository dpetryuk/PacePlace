package com.example.daniel.paceplace;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MapActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        configureSpinner();

        FirstMapFrag firstFrag = new FirstMapFrag();
        getFragmentManager().beginTransaction() //Lets android know that something will happen to a fragment
                .add(R.id.mapContainer, firstFrag).commit(); // add fragment A to activity at runtime

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
            //String[] mapStringArray = getResources().getStringArray(R.array.maps_array);
            if(i == 0){
                getFragmentManager().beginTransaction() //Lets android know that something will happen to a fragment
                        .replace(R.id.mapContainer, new FirstMapFrag()).commit();
            }else{
                getFragmentManager().beginTransaction() //Lets android know that something will happen to a fragment
                        .replace(R.id.mapContainer, new SecondMapFrag()).commit();
            }
        }

        @Override
        public void onNothingSelected(AdapterView<?> adapterView) {

        }
    };

}
