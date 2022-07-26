package com.jaydedaniya.sqlite_database__notification__permission_demo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class LoginActivity extends AppCompatActivity {

    Context context;
    EditText userName, userPassWord;
    TextView userNameValidation, userPassWordValidation, createNewAccount;
    Button submitBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        context = this;

        userName = findViewById(R.id.userNameUpdateUserDetailsActivity);
        userPassWord = findViewById(R.id.userPassWordSignUpActivity);
        userNameValidation = findViewById(R.id.userNameValidationUpdateUserDetailsActivity);
        userPassWordValidation = findViewById(R.id.userPassWordValidationSignUpActivity);
        createNewAccount = findViewById(R.id.loginAccountTextSignUpActivity);
        submitBtn = findViewById(R.id.updateBtnUpdateUserDetailsActivity);

//        User Name Validation Checked
//        TextWatcher userNameTextWatcher = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String name = userName.getText().toString();
//                if (name.isEmpty()) {
//                    userNameValidation.setVisibility(View.GONE);
//                } else if (name.length() < 6) {
//                    userNameValidation.setVisibility(View.VISIBLE);
//                    userNameValidation.setText(R.string.unValid);
//                    userNameValidation.setTextColor(getResources().getColor(R.color.red));
//                } else {
//                    userNameValidation.setVisibility(View.VISIBLE);
//                    userNameValidation.setText(R.string.valid);
//                    userNameValidation.setTextColor(getResources().getColor(R.color.blue));
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//
//            }
//        };
//        userName.addTextChangedListener(userNameTextWatcher);

//        User PassWord Validation Checked
//        TextWatcher userPassWordTextWatcher = new TextWatcher() {
//            @Override
//            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
//            }
//
//            @Override
//            public void onTextChanged(CharSequence s, int start, int before, int count) {
//                String pass = userPassWord.getText().toString();
//                if (pass.isEmpty()) {
//                    userPassWordValidation.setVisibility(View.GONE);
//                } else if (Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", pass)) {
//                    userPassWordValidation.setVisibility(View.VISIBLE);
//                    userPassWordValidation.setText(R.string.valid);
//                    userPassWordValidation.setTextColor(getResources().getColor(R.color.blue));
//                } else {
//                    userPassWordValidation.setVisibility(View.VISIBLE);
//                    userPassWordValidation.setText(R.string.unValid);
//                    userPassWordValidation.setTextColor(getResources().getColor(R.color.red));
//                }
//            }
//
//            @Override
//            public void afterTextChanged(Editable s) {
//            }
//        };
//        userPassWord.addTextChangedListener(userPassWordTextWatcher);

//       OnClick Query to Submit Button
        submitBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userNameValidation.getText().toString();
                String pass = userPassWordValidation.getText().toString();
                if (name.equals("Valid!") && pass.equals("Valid!")) {
                    Intent intent = new Intent(LoginActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(context, "\t\t\t\t\t\t\t\tUnValid Details \n Enter the correct details and try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });

//        OnClick Query to Create New Account Text
        createNewAccount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,SignUpActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}