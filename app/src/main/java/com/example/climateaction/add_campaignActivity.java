package com.example.climateaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class add_campaignActivity extends AppCompatActivity {
    private EditText title_btn, date_btn, camp_description;
    private Button add_camp_btn;
    private String title,date,description;


    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_campaign);


        findId();
        add_camp_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               addCampaign();
            }
        });
    }

    private void addCampaign() {

        title=title_btn.getText().toString();
        date=date_btn.getText().toString();
        description=camp_description.getText().toString();
        String UID = currentUser.getUid();


        HashMap<String, String> campaignMap = new HashMap<>();
        campaignMap.put("uid", UID);
        campaignMap.put("title", title);
        campaignMap.put("date", date);
        campaignMap.put("description", description);

        databaseReference.child("users").child("campaign").child(UID).push().setValue(campaignMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    sendToMainActivity();
                    Toast.makeText(getApplicationContext(), "Campaign Added", Toast.LENGTH_SHORT).show();
                }else{
                    String error = task.getException().toString();
                    Toast.makeText(getApplicationContext(), "Error :" + error, Toast.LENGTH_SHORT).show();

                }
            }
        });


        Intent i=new Intent(getApplicationContext(), campaign_acticity.class);
        startActivity(i);


    }

    private void sendToMainActivity() {


        Intent mainIntent =new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainIntent);

    }

    private void findId(){
        title_btn=findViewById(R.id.title_btn);
        date_btn=findViewById(R.id.date_btn);
        camp_description=findViewById(R.id.camp_description);
        add_camp_btn=findViewById(R.id.add_camp_btn);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
    }
}