package com.example.climateaction;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import java.util.ArrayList;

public class check_carbon extends AppCompatActivity {
    private AutoCompleteTextView actview;
    String Sdata;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_carbon);
        actview = findViewById(R.id.actview);



        ArrayList<String> arrItem = new ArrayList<>();
        arrItem.add("Plastic Bottle");
        arrItem.add("Metal Bottle");
        arrItem.add("Mobile Charger");
        arrItem.add("Laptop Charger");
        arrItem.add("Mobile");
        arrItem.add("Laptop");
        arrItem.add("Tablet");
        arrItem.add("Shoes");
        arrItem.add("Slipper");
        arrItem.add("Jeans");
        arrItem.add("Shirt");

        ArrayAdapter<String> actvAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,arrItem);
            actview.setAdapter(actvAdapter);
            actview.setThreshold(1);
            Sdata = actview.getText().toString();
    }
}