package com.example.climateaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class addItem extends AppCompatActivity {
    private EditText item_name;
    private EditText item_discription;
    private Button add_btn;
    private String product_name,product_discription;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        founder();
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                product_name=item_name.getText().toString();
                product_discription=item_discription.getText().toString();
                Intent i =new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

    }
    private void founder(){
        item_name=findViewById(R.id.item_name);
        item_discription=findViewById(R.id.item_discription);
        add_btn=findViewById(R.id.add_btn);
    }

}