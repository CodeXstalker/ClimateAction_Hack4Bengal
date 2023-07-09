package com.example.climateaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private ExtendedFloatingActionButton FAB;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fieldInitializer();
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),check_carbon.class);
                startActivity(i);
            }
        });
    }

    private void fieldInitializer() {

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        FAB = findViewById(R.id.check_carbon);

    }

    @Override
    protected void onStart() {
        super.onStart();
        if(currentUser==null){
            sendToRegisterActivity();
        }
    }

    private void sendToRegisterActivity() {

        Intent RegisterIntent = new Intent(getApplicationContext(),RgisterActivity.class);
        startActivity(RegisterIntent);


    }

}