package com.jaydedaniya.sqlite_database__notification__permission_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaydedaniya.sqlite_database__notification__permission_demo.dbHelper.UserDataHandler;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {

    Context context;
    RecyclerView homeRecyclerView;
    ArrayList<UserDataClass> userDataClassArrayList;
    UserDataHandler dataHandler;
    FloatingActionButton addNewUserBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        context = this;

        addNewUserBtn = findViewById(R.id.homeActivityFabBtn);
        homeRecyclerView = findViewById(R.id.homeActivityRecyclerView);

        dataHandler = new UserDataHandler(context);
        userDataClassArrayList = dataHandler.getAllUserDetails();

        if(userDataClassArrayList.size()>0){
            homeRecyclerView.setLayoutManager(new LinearLayoutManager(context,RecyclerView.VERTICAL,false));
            UserData_RecyclerAdapter recyclerAdapter = new UserData_RecyclerAdapter(context, userDataClassArrayList);
            homeRecyclerView.setAdapter(recyclerAdapter);
        }

        addNewUserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this,SignUpActivity.class);
                startActivity(intent);
            }
        });



    }
}