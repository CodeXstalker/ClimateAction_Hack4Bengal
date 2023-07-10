package com.example.climateaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

import de.hdodenhof.circleimageview.CircleImageView;

public class SettingActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    private ImageView profileImage;
    private EditText setUserName, email;
    private Button updateSettingsButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);

        fieldInitializer();

        updateSettingsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                gettingTheUserdetailsAndPushToDB();
            }
        });


    }

    private void gettingTheUserdetailsAndPushToDB() {

        String getName = setUserName.getText().toString();
        String getEmail =email.getText().toString();
        String UID = currentUser.getUid();

        HashMap<String, String> profileMap = new HashMap<>();
        profileMap.put("uid", UID);
        profileMap.put("name", getName);
        profileMap.put("email", getEmail);

        databaseReference.child("users").child(UID).setValue(profileMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()) {
                    sendToMainActivity();
                    Toast.makeText(getApplicationContext(), "Profile Updated", Toast.LENGTH_SHORT).show();
                }else{
                    String error = task.getException().toString();
                    Toast.makeText(getApplicationContext(), "Error :" + error, Toast.LENGTH_SHORT).show();

                }
            }
        });


    }

    private void sendToMainActivity() {

        Intent mainIntent = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainIntent);

    }

    private void fieldInitializer() {

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();

        profileImage = findViewById(R.id.profile_image);
        setUserName = findViewById(R.id.set_user_name);
        email = findViewById(R.id.Email);
        updateSettingsButton = findViewById(R.id.update_settings_button);

    }
}