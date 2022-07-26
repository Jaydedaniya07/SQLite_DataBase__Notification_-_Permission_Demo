package com.jaydedaniya.sqlite_database__notification__permission_demo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class UserData_RecyclerAdapter extends RecyclerView.Adapter<UserData_RecyclerAdapter.ViewHolder> {

    Context context;
    ArrayList<UserDataClass> userDataClassArrayList;

    public UserData_RecyclerAdapter(Context context, ArrayList<UserDataClass> userDataClassArrayList) {
        this.context = context;
        this.userDataClassArrayList = userDataClassArrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(R.layout.userdata_cardview,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        UserDataClass userDataClass = userDataClassArrayList.get(position);
        if(userDataClass != null){
            holder.userName.setText(userDataClass.getUserName());
            holder.userCard.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context,SingleUserActivity.class);
                    intent.putExtra("userDetails", userDataClass);
                    context.startActivity(intent);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return userDataClassArrayList.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView userName;
        CardView userCard;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            userName = itemView.findViewById(R.id.cardView_UserNameText);
            userCard = itemView.findViewById(R.id.cardView_UserDataCard);

        }
    }
}
