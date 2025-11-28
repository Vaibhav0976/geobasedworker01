package com.example.geobasedworker;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class LocationAdapter extends RecyclerView.Adapter<LocationAdapter.ViewHolder> {



    ArrayList<Workers> mList;
    Context context;

    public LocationAdapter(ArrayList<Workers> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.useritem,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Workers vacancy1 = mList.get(position);
        holder.txtbname.setText("Name: "+vacancy1.getName());
        holder.txtaddress.setText("Address: "+vacancy1.getAddress());
        holder.txttype.setText("Exp: "+vacancy1.getExpe());
        holder.txtcate.setText("Type: "+vacancy1.getType());
        Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);

        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkerDetails.class);

                intent.putExtra("name", vacancy1.getName());
                intent.putExtra("address",vacancy1.getAddress());
                intent.putExtra("mobileno",vacancy1.getMobileno());
                intent.putExtra("type",vacancy1.getType());
                intent.putExtra("charges",vacancy1.getCharges());
                intent.putExtra("hours",vacancy1.getHours());
                intent.putExtra("url",vacancy1.getImageurl());
                intent.putExtra("expe",vacancy1.getExpe());

                view.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public interface RecyclerViewClickListener{
        void onClick(View v, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView img1;
        TextView txtbname,txtaddress,txttype,txtcate;

        RelativeLayout relativeLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 =itemView.findViewById(R.id.img1);
            txtbname = itemView.findViewById(R.id.nametext);
            txtaddress = itemView.findViewById(R.id.coursetext);
            txttype = itemView.findViewById(R.id.emailtext);
            relativeLayout = itemView.findViewById(R.id.relative);
            txtcate = itemView.findViewById(R.id.address);



        }


    }
}
