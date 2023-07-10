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

public class addItem extends AppCompatActivity {
    private EditText item_name;
    private EditText item_discription;
    private Button add_btn;
    private String product_name,product_discription;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_item);
        feildInitializer();

        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               AddingItem();
            }
        });

    }

    private void AddingItem() {

        product_name=item_name.getText().toString();
        product_discription=item_discription.getText().toString();
        String UID = currentUser.getUid();

        HashMap<String, String> itemMap = new HashMap<>();
        itemMap.put("uid", UID);
        itemMap.put("product_name", product_name);
        itemMap.put("product_description", product_discription);


        databaseReference.child("users").child("items").child(UID).push().setValue(itemMap).addOnCompleteListener(new OnCompleteListener<Void>() {
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

        Intent mainIntent =new Intent(getApplicationContext(), MainActivity.class);
        startActivity(mainIntent);

    }

    private void feildInitializer() {
        item_name=findViewById(R.id.item_name);
        item_discription=findViewById(R.id.item_discription);
        add_btn=findViewById(R.id.add_btn);

        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference();

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
    }


}