package com.example.sqliteloadimg;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class readAdapters extends RecyclerView.Adapter<readAdapters.viewHolder> {

    Context context;
    ArrayList<ReadModels> list;

    public readAdapters(Context context, ArrayList<ReadModels> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bike_layout, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        ReadModels orderModels = list.get(position);
        holder.bikenames.setText(orderModels.getName());
        holder.bikeimages.setImageURI(Uri.parse(orderModels.getUserimg()));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView bikenames;
        ImageView bikeimages;

        public viewHolder(@NonNull View itemView) {
            super(itemView);

            bikenames = itemView.findViewById(R.id.bikenames);
            bikeimages = itemView.findViewById(R.id.bikeimages);
        }
    }
}
