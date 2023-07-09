package com.example.climateaction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fieldInitializer();
    }

    private void fieldInitializer() {

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();

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