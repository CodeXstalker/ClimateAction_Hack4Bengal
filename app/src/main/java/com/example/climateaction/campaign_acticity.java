package com.example.climateaction;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;

public class campaign_acticity extends AppCompatActivity {
    private ExtendedFloatingActionButton check_carbon;
    private TextView item_list;
    Button btn_addcamp;
    ArrayList<RecyclerCampaignStructure> campaign = new ArrayList<>();
    private RecyclerView reitem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_campaign_acticity);
        check_carbon=findViewById(R.id.check_carbon);
        item_list=findViewById(R.id.Item_list);
        btn_addcamp=findViewById(R.id.btn_addcamp);
        check_carbon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),check_carbon.class);
                startActivity(i);
            }
        });
        item_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent list = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(list);
            }
        });
       btn_addcamp.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View view) {
               Intent addcamp =new Intent(getApplicationContext(), add_campaignActivity.class);
               startActivity(addcamp);
           }
       });
       reitem = findViewById(R.id.re_item);
       reitem.setLayoutManager(new LinearLayoutManager(this));

       campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));
        campaign.add(new RecyclerCampaignStructure("Plantation","100","10/05/2023-Monday"));

        RecyclerCampaignAdapter adapter = new RecyclerCampaignAdapter(this, campaign);
        reitem.setAdapter(adapter);

    }
}