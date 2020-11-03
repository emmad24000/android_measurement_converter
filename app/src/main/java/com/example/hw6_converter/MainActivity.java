package com.example.hw6_converter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView mainList;
    ArrayList<String> options = new ArrayList<>();
    ArrayAdapter<String> arrayAdapter;
    View view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        final boolean isTablet = getResources().getBoolean(R.bool.isTablet);
        options.add("Fahrenheit to Celsius");
        options.add("Miles to Kilometers");
        options.add("Yards to Meters");
        options.add("Gallons to Liters");

        mainList = findViewById(R.id.convertLists);
        arrayAdapter= new ArrayAdapter<String>(getApplicationContext(),android.R.layout.simple_list_item_1, options);
        mainList.setAdapter(arrayAdapter);

        mainList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                if (!isTablet) {
                    Intent startConvertActivity = new Intent(getApplicationContext(), ViewConversionActivity.class);
                    startConvertActivity.putExtra("INDEX", i);
                    startActivity(startConvertActivity);
                } else {
                    convertFragment convertFragment = null;
                    if(i == 0){
                        convertFragment = new convertFragment("Fahrenheit","Celsius");

                    }else if(i == 1){
                        convertFragment = new convertFragment("Miles","Kilometers");
                    }else if(i ==2){
                        convertFragment = new convertFragment("Yards","Meters");
                    }else if(i == 3){
                        convertFragment = new convertFragment("Gallons","Liters");
                    }
                    FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
                    fragmentTransaction.replace(R.id.frameLayoutTablet,convertFragment);
                    fragmentTransaction.addToBackStack(null);
                    fragmentTransaction.commit();
                }
            }
        });

    }
}