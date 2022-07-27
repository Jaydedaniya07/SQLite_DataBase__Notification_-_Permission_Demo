package com.jaydedaniya.sqlite_database__notification__permission_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.jaydedaniya.sqlite_database__notification__permission_demo.dbHelper.UserDataHandler;

public class SingleUserActivity extends AppCompatActivity {

    Context context;
    TextView userName, userNumber, userEmail;
    Button editBtn, deleteBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_user);
        context = this;

        userName = findViewById(R.id.singleUserActivity_UserName);
        userNumber = findViewById(R.id.singleUserActivity_UserNumber);
        userEmail = findViewById(R.id.singleUserActivity_UserEmail);
        editBtn = findViewById(R.id.singleUserActivity_UserEditBtn);
        deleteBtn = findViewById(R.id.singleUserActivity_UserDeleteBtn);

        Intent intent = getIntent();
        UserDataClass userDataClass = (UserDataClass) intent.getSerializableExtra("userDetails");

        if(intent.getSerializableExtra("userDetails")!= null){
            userName.setText(userDataClass.getUserName());
            userNumber.setText(userDataClass.getUserNumber());
            userEmail.setText(userDataClass.getUserEmail());
        }

        editBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SingleUserActivity.this,UpdateUserDetails.class);
                intent.putExtra("userDetails", userDataClass);
                startActivity(intent);
            }
        });

        deleteBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                UserDataHandler dataHandler = new UserDataHandler(context);
                dataHandler.deleteUserDetails(userDataClass);

                Intent intent = new Intent(SingleUserActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
    }
}