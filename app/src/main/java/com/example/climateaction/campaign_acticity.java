package com.example.climateaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class campaign_acticity extends AppCompatActivity {
    private ExtendedFloatingActionButton check_carbon;
    private TextView item_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_acticity);
        check_carbon=findViewById(R.id.check_carbon);
        item_list=findViewById(R.id.Item_list);
        check_carbon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),check_carbon.class);
                startActivity(i);
            }
        });
        item_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(list);
            }
        });
    }
}