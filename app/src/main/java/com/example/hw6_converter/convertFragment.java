package com.example.hw6_converter;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class convertFragment extends Fragment implements View.OnClickListener {

    private int index;
    private TextView convertFrom;
    private TextView convertTo;
    private String convertFromString;
    private String convertToString;
    View view;
    Button convertButton;
    EditText editTextConvertFrom;
    EditText editTextConvertTo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_convert,container,false);
        convertFrom = view.findViewById(R.id.convertFrom);
        convertTo = view.findViewById(R.id.convertTo);
        convertButton = view.findViewById(R.id.convertButton);
        convertButton.setOnClickListener((View.OnClickListener) this);
        editTextConvertFrom = view.findViewById(R.id.editTextConvertFrom);
        editTextConvertTo = view.findViewById(R.id.editTextConvertTo);

        convertFrom.setText(convertFromString);
        convertTo.setText(convertToString);


        return view;
    }
    public convertFragment(){

    }

    public convertFragment(String convertFromString, String convertToString){
        this.convertFromString = convertFromString;
        this.convertToString = convertToString;
    }

    @Override
    public void onClick(View view){
        String convertNumb = editTextConvertFrom.getText().toString();
        double convertFromDouble = Double.parseDouble(convertNumb);
        if(convertFromString.equals("Fahrenheit")){
            double celcius = (convertFromDouble - 32.0)*(5.0/9.0);
            editTextConvertTo.setText(String.format("%.2f",celcius));
        }else if(convertFromString.equals("Miles")){
            double kilometers = convertFromDouble * 1.609;
            editTextConvertTo.setText(String.format("%.2f",kilometers));
        }else if(convertFromString.equals("Yards")){
            double meters = convertFromDouble * 1.094;
            editTextConvertTo.setText(String.format("%.2f",meters));
        }else if(convertFromString.equals("Gallons")){
            double liters = convertFromDouble * 3.785;
            editTextConvertTo.setText(String.format("%.2f",liters));
        }

    }

}