package com.example.geobasedworker;

import android.telephony.SmsManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RequireAdapter extends RecyclerView.Adapter<RequireAdapter.ViewHolder> {


    ArrayList<Requirement> mList;
    private RequireAdapter.RecyclerViewClickListener listener;


    public RequireAdapter(ArrayList<Requirement> mList, RequireAdapter.RecyclerViewClickListener listener) {
        this.mList = mList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.data_list,parent,false);

        return new RequireAdapter.ViewHolder(v);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {


        Requirement vacancy1 = mList.get(position);
        holder.txtbname.setText("Name -"+vacancy1.getName());
        holder.txtaddress.setText("Number -"+vacancy1.getNumber());
        holder.txttype.setText("Address -"+vacancy1.getAddress());
        holder.txtadd.setText("Require -"+vacancy1.getRequire());

        holder.btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SmsManager sms= SmsManager.getDefault();
                sms.sendTextMessage(vacancy1.getNumber(), null, "I do This Job", null,null);
                Toast.makeText(view.getContext(), "Send Sms",Toast.LENGTH_SHORT).show();

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

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {

        ImageView img1;
        TextView txtbname,txtaddress,txttype,txtadd;
        ImageButton btn;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img1 =itemView.findViewById(R.id.img1);
            txtbname = itemView.findViewById(R.id.txtbname);
            txtaddress = itemView.findViewById(R.id.txtprofile);
            txttype = itemView.findViewById(R.id.txtaddress);
            txtadd = itemView.findViewById(R.id.txtrequire);

            btn = itemView.findViewById(R.id.send);

            itemView.setOnClickListener(this);

        }


        @Override
        public void onClick(View view) {
            listener.onClick(view,getAdapterPosition());
        }
    }
}
