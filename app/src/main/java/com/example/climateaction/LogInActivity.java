package com.example.climateaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

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

public class LogInActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;
    private EditText email, password;
    private TextView forgotPassword,needNewAccount, logInUsingPhoneNumber;
    private Button phone, logIn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

        fieldInitializers();

        logIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                userLogging();
            }
        });
    }

    private void userLogging() {

        String getEmail = email.getText().toString();
        String getPassword = password.getText().toString();

        firebaseAuth.signInWithEmailAndPassword(getEmail,getPassword).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    sendUserToMainActivity();
                    Toast.makeText(getApplicationContext(),"Welcome . . . ",Toast.LENGTH_SHORT).show();
                }else{
                    String error = task.getException().toString();
                    Toast.makeText(getApplicationContext(),"Error: " + error,Toast.LENGTH_SHORT).show();

                }

            }
        });


    }

    private void sendUserToMainActivity() {
        Intent mainIntent = new Intent(getApplicationContext(),MainActivity.class);
        startActivity(mainIntent);
    }

    private void fieldInitializers() {

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        email = findViewById(R.id.Email);
        password = findViewById(R.id.Password);
        forgotPassword = findViewById(R.id.ForgotPassword);
        needNewAccount = findViewById(R.id.NeedNewAccount);
        logInUsingPhoneNumber = findViewById(R.id.LogInUsingPhoneNumber);
        phone = findViewById(R.id.Phone);
        logIn = findViewById(R.id.LogIn);


    }
}