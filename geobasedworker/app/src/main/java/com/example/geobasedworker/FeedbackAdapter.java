package com.example.geobasedworker;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;


public class FeedbackAdapter  extends RecyclerView.Adapter<FeedbackAdapter.ViewHolder>{



    ArrayList<Userfeedback> mList;
    Context context;

    public FeedbackAdapter(ArrayList<Userfeedback> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.feedbacklist,parent,false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        Userfeedback vacancy1 = mList.get(position);
        holder.txtbname.setText("User Name "+vacancy1.getUname());
        holder.txtaddress.setText("Number "+vacancy1.getNumber());
        holder.txttype.setText("Feedback "+vacancy1.getFeedback());
        holder.txtrating.setText("Rating "+vacancy1.getRating());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{


        TextView txtbname,txtaddress,txttype,txtrating;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);


            txtbname = itemView.findViewById(R.id.txtbname);
            txtaddress = itemView.findViewById(R.id.txtprofile);
            txttype = itemView.findViewById(R.id.txtaddress);

            txtrating = itemView.findViewById(R.id.txtrating);


        }
    }

}
