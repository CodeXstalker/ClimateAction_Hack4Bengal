package com.example.climateaction;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class additemAdapter extends RecyclerView.Adapter<additemAdapter.ViewHolder> {
    Context context;
    ArrayList<addItemstructure> item;
    additemAdapter(Context context, ArrayList<addItemstructure> item){
        this.context = context;
        this.item = item;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.item_list_card, parent, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//         holder.item_image.setImageResource(R.drawable.profile_picture);
//         holder.item_name.setText("test2");
//         holder.item_description.setText("test");
    }

    @Override
    public int getItemCount() {
        return item.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView item_name, item_description;
        ImageView item_image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_name = itemView.findViewById(R.id.item_name);
            item_description = itemView.findViewById(R.id.item_discription);
            item_image = itemView.findViewById(R.id.item_image);
        }
    }

}
