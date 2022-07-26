package com.jaydedaniya.sqlite_database__notification__permission_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.jaydedaniya.sqlite_database__notification__permission_demo.dbHelper.UserDataHandler;

public class UpdateUserDetails extends AppCompatActivity {

    Context context;
    EditText userName, userNumber, userEmail;
    TextView userNameValidation, userNumberValidation, userEmailValidation;
    Button updateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user_details);
        context = this;

        userName = findViewById(R.id.userNameUpdateUserDetailsActivity);
        userNumber = findViewById(R.id.userNumberUpdateUserDetailsActivity);
        userEmail = findViewById(R.id.userEmailUpdateUserDetailsActivity);
        userNameValidation = findViewById(R.id.userNameValidationUpdateUserDetailsActivity);
        userNumberValidation = findViewById(R.id.userNumberValidationUpdateUserDetailsActivity);
        userEmailValidation = findViewById(R.id.userEmailValidationUpdateUserDetailsActivity);
        updateBtn = findViewById(R.id.updateBtnUpdateUserDetailsActivity);


        Intent intent = getIntent();
        UserDataClass userDataClass = (UserDataClass) intent.getSerializableExtra("userDetails");
        if (intent.getSerializableExtra("userDetails") != null){
            userName.setText(userDataClass.getUserNumber());
            userNumber.setText(userDataClass.getUserNumber());
            userEmail.setText(userDataClass.getUserEmail());
        }
        else{
            userDataClass = new UserDataClass();
        }


        //        User Name Validation Checked
        TextWatcher userNameTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String name = userName.getText().toString();
                if (name.isEmpty()) {
                    userNameValidation.setVisibility(View.GONE);
                } else if (name.length() < 6) {
                    userNameValidation.setVisibility(View.VISIBLE);
                    userNameValidation.setText(R.string.unValid);
                    userNameValidation.setTextColor(getResources().getColor(R.color.red));
                } else {
                    userNameValidation.setVisibility(View.VISIBLE);
                    userNameValidation.setText(R.string.valid);
                    userNameValidation.setTextColor(getResources().getColor(R.color.blue));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        };
        userName.addTextChangedListener(userNameTextWatcher);

//        User Number Validation Checked
        TextWatcher userNumberTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String number = userNumber.getText().toString();
                if (number.isEmpty()) {
                    userNumberValidation.setVisibility(View.GONE);
                } else if (number.length() == 10) {
                    userNumberValidation.setVisibility(View.VISIBLE);
                    userNumberValidation.setText(R.string.valid);
                    userNumberValidation.setTextColor(getResources().getColor(R.color.blue));
                } else {
                    userNumberValidation.setVisibility(View.VISIBLE);
                    userNumberValidation.setText(R.string.unValid);
                    userNumberValidation.setTextColor(getResources().getColor(R.color.red));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        userNumber.addTextChangedListener(userNumberTextWatcher);

//        User Email Validation Checked
        TextWatcher userEmailTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String email = userEmail.getText().toString();
                if (email.isEmpty()) {
                    userEmailValidation.setVisibility(View.GONE);
                } else if (Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                    userEmailValidation.setVisibility(View.VISIBLE);
                    userEmailValidation.setText(R.string.valid);
                    userEmailValidation.setTextColor(getResources().getColor(R.color.blue));
                } else {
                    userEmailValidation.setVisibility(View.VISIBLE);
                    userEmailValidation.setText(R.string.unValid);
                    userEmailValidation.setTextColor(getResources().getColor(R.color.red));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        userEmail.addTextChangedListener(userEmailTextWatcher);

        UserDataClass finalUserDataClass = userDataClass;
        updateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finalUserDataClass.setUserName(userName.getText().toString());
                finalUserDataClass.setUserNumber(userNumber.getText().toString());
                finalUserDataClass.setUserEmail(userEmail.getText().toString());

                UserDataHandler dataHandler = new UserDataHandler(context);
                dataHandler.saveUserDetails(finalUserDataClass);

                Intent intent = new Intent(UpdateUserDetails.this,SingleUserActivity.class);
                startActivity(intent);

            }
        });


    }
}