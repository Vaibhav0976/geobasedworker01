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

public class TypeAdapter extends RecyclerView.Adapter<TypeAdapter.ViewHolder> {


    ArrayList<Workers> mList;
    Context context;

    public TypeAdapter(ArrayList<Workers> mList, Context context) {
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
        holder.txtbname.setText("Worker Name "+vacancy1.getName());
        holder.txtaddress.setText("Number "+vacancy1.getMobileno());
        holder.txttype.setText("Type "+vacancy1.getType());
        holder.txtchares.setText("Charges "+vacancy1.getCharges());
        Glide.with(holder.img1.getContext()).load(vacancy1.getImageurl()).into(holder.img1);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), WorkerDetails.class);

                intent.putExtra("name", vacancy1.getName());
                intent.putExtra("mobileno",vacancy1.getMobileno());

                intent.putExtra("address", vacancy1.getAddress());
                intent.putExtra("type",vacancy1.getType());
                intent.putExtra("charges", vacancy1.getCharges());
                intent.putExtra("hours",vacancy1.getHours());
                intent.putExtra("expe", vacancy1.getExpe());
                intent.putExtra("url",vacancy1.getImageurl());
                view.getContext().startActivity(intent);
            }

        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder
    {


        TextView txtbname,txtaddress,txttype,txtchares;
        RelativeLayout relativeLayout;
        ImageView img1;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtbname = itemView.findViewById(R.id.nametext);
            txtaddress = itemView.findViewById(R.id.coursetext);
            txttype = itemView.findViewById(R.id.emailtext);
            txtchares = itemView.findViewById(R.id.address);
            img1 = itemView.findViewById(R.id.img1);
            relativeLayout = itemView.findViewById(R.id.relative);




        }



    }

}
