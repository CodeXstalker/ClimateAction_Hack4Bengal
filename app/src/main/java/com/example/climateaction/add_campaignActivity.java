package com.example.climateaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class add_campaignActivity extends AppCompatActivity {
    private EditText title_btn, date_btn, camp_description;
    private Button add_camp_btn;
    private String title,date,description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_campaign);
        findId();
        add_camp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                title=title_btn.getText().toString();
                date=date_btn.getText().toString();
                description=camp_description.getText().toString();
                Intent i=new Intent(getApplicationContext(), campaign_acticity.class);
                startActivity(i);
            }
        });
    }
    private void findId(){
        title_btn=findViewById(R.id.title_btn);
        date_btn=findViewById(R.id.date_btn);
        camp_description=findViewById(R.id.camp_description);
        add_camp_btn=findViewById(R.id.add_camp_btn);
    }
}