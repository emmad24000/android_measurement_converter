package com.example.hw6_converter;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ViewConversionActivity extends AppCompatActivity {
    int index;
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.view_conversion);
        Intent getConvertIndex =  getIntent();
        index = getConvertIndex.getIntExtra("INDEX",0);


        convertFragment convertFragment = null;
        if(index == 0){
            convertFragment = new convertFragment("Fahrenheit","Celsius");
        }else if(index == 1){
            convertFragment = new convertFragment("Miles","Kilometers");
        }else if(index ==2){
            convertFragment = new convertFragment("Yards","Meters");
        }else if(index == 3){
            convertFragment = new convertFragment("Gallons","Liters");
        }
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.frameLayout,convertFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
        fragmentTransaction.commit();


    }

}
