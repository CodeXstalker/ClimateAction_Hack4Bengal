package com.example.climateaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    private ExtendedFloatingActionButton FAB;
    private Button btn_add_item;
    private Toolbar toolbar;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fieldInitializer();
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("W'Clone");
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),check_carbon.class);
                startActivity(i);
            }
        });
        btn_add_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(getApplicationContext(), addItem.class);
                startActivity(add);
            }
        });
    }

    private void fieldInitializer() {

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        FAB = findViewById(R.id.check_carbon);
        toolbar = findViewById(R.id.AppBar);
        btn_add_item=findViewById(R.id.btn_add_item);

    }

    @NonNull
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.options_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        if (item.getItemId() == R.id.Setting) {

        }
        if (item.getItemId() == R.id.LogOut) {


        }
        return true;
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