package com.example.climateaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class RgisterActivity extends AppCompatActivity {

    private EditText email, password;
    private Button createAccount;
    private  TextView alreadyHaveAnAccount;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rgister);

        fieldInitializer();

        createAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                registerUser();
            }
        });

        alreadyHaveAnAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendUserToLogInActivity();
            }
        });

    }

    private void registerUser() {

        String getEmail = email.getText().toString();
        String getPassword = password.getText().toString();

        firebaseAuth.createUserWithEmailAndPassword(getEmail,getPassword).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    sendUserToLogInActivity();
                    Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Something Went wrong. . . ",Toast.LENGTH_SHORT).show();

                }
            }
        });

    }

    private void sendUserToLogInActivity() {

        Intent LogInIntent = new Intent(getApplicationContext(),LogInActivity.class);
        startActivity(LogInIntent);

    }

    private void fieldInitializer() {


        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        createAccount = findViewById(R.id.CreateAccount);
        alreadyHaveAnAccount = findViewById(R.id.AlreadyHaveAnAccount);

    }
}