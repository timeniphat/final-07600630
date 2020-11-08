package com.example.speedrecords.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.speedrecords.R;
import com.example.speedrecords.model.User;
import com.example.speedrecords.until.DataFormatter;

public class UserAdapter extends RecyclerView.Adapter<UserAdapter.MyViewHolder> {

    private Context mContext;
    private User[] mUsers;

    public UserAdapter(Context context, User[] users) {
        this.mContext = context;
        this.mUsers = users;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_user, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        User user = mUsers[position];

        holder.countTextView.setText((int) user.count+" "+"KM/H");
        holder.secountTextView.setText((int) user.distance+" "+"METERS");

        holder.meterTextView.setText((int) user.time+" "+"SECONDS");

        holder.genderImageView.setImageResource(
                user.resultcount > 80 ? R.drawable.red_cow : R.drawable.red_cow
        );
    }

    @Override
    public int getItemCount() {
        return mUsers.length;
    }

    static class MyViewHolder extends RecyclerView.ViewHolder {
        TextView countTextView;
        TextView secountTextView;
        ImageView genderImageView;
        TextView meterTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            this.countTextView = itemView.findViewById(R.id.count_text_view);
            this.secountTextView = itemView.findViewById(R.id.second_text);
            this.genderImageView = itemView.findViewById(R.id.gender_image_view);
            this.meterTextView = itemView.findViewById(R.id.meter_text_view);
        }
    }
}
