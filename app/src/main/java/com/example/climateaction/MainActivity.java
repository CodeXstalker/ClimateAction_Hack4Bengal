package com.example.climateaction;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ExtendedFloatingActionButton FAB;
    private Button btn_add_item;
    private TextView campaign;
    private Toolbar toolbar;

    private FirebaseAuth firebaseAuth;
    private FirebaseUser currentUser;
    private RecyclerView reitem;
    ArrayList<addItemstructure> item = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fieldInitializer();
        reitem.setLayoutManager(new LinearLayoutManager(this));
//        setSupportActionBar(toolbar);
//        getSupportActionBar().setTitle("W'Clone");
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
        campaign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent camp = new Intent(getApplicationContext(), campaign_acticity.class);
                startActivity(camp);
            }
        });
        additem();
    }

    private void fieldInitializer() {

        firebaseAuth = FirebaseAuth.getInstance();
        currentUser = firebaseAuth.getCurrentUser();
        FAB = findViewById(R.id.check_carbon);
        toolbar = findViewById(R.id.AppBar);
        btn_add_item=findViewById(R.id.btn_add_item);
        campaign=findViewById(R.id.campaign);
        reitem=findViewById(R.id.re_item);


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
                sendToSettingACtivity();
        }
        if (item.getItemId() == R.id.LogOut) {

            firebaseAuth.signOut();
            sentToSignInActivity();


        }
        return true;
    }

    private void sentToSignInActivity() {
        Intent RegisterIntent = new Intent(getApplicationContext(),LogInActivity.class);
        startActivity(RegisterIntent);
    }

    private void sendToSettingACtivity() {
        Intent RegisterIntent = new Intent(getApplicationContext(),SettingActivity.class);
        startActivity(RegisterIntent);

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
    public void additem(){
        item.add(new addItemstructure(R.drawable.boxicon, "Laptop", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Mobile", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Plastic Bottle", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Metal Bottle", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Charger", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Laptop Charger", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Laptop", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Mobile", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Plastic Bottle", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Metal Bottle", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Charger", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Laptop Charger", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Laptop", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Mobile", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Plastic Bottle", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Metal Bottle", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Charger", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Laptop Charger", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Laptop", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Mobile", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Plastic Bottle", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Metal Bottle", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Charger", "old  to sell sell some one price negotiable"));
        item.add(new addItemstructure(R.drawable.boxicon, "Laptop Charger", "old  to sell sell some one price negotiable"));

        additemAdapter adapter = new additemAdapter(this, item);
        reitem.setAdapter(adapter);

    }


}