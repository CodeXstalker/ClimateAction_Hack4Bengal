package com.example.climateaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecyclerCampaignAdapter extends RecyclerView.Adapter<RecyclerCampaignAdapter.ViewHolder> {
    Context context;
    ArrayList<RecyclerCampaignStructure> camp = new ArrayList<>();
    RecyclerCampaignAdapter(Context context, ArrayList<RecyclerCampaignStructure> camp){
        this.context = context;
        this.camp = camp;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.campaign_card, parent,false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return camp.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView title, quant, date_day;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title= itemView.findViewById(R.id.title);
            quant = itemView.findViewById(R.id.quant);
            date_day = itemView.findViewById(R.id.date_day);
        }
    }
}