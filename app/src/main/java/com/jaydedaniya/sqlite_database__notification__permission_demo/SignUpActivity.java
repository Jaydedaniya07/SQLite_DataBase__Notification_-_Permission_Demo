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
import android.widget.Toast;

import java.util.regex.Pattern;

public class SignUpActivity extends AppCompatActivity {

    Context context;
    EditText userName, userNumber, userEmail, userPassWord, userConfirmPassWord;
    TextView userNameValidation, userNumberValidation, userEmailValidation, userPassWordValidation, userConfirmPassWordValidation, loginAccountText;
    Button createBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        context = this;

        userName = findViewById(R.id.userNameSignUpActivity);
        userNumber = findViewById(R.id.userNumberSignUpActivity);
        userEmail = findViewById(R.id.userEmailSignUpActivity);
        userPassWord = findViewById(R.id.userPassWordSignUpActivity);
        userConfirmPassWord = findViewById(R.id.userConfirmPassWordSignUpActivity);
        userNameValidation = findViewById(R.id.userNameValidationSignUpActivity);
        userNumberValidation = findViewById(R.id.userNumberValidationSignUpActivity);
        userEmailValidation = findViewById(R.id.userEmailValidationSignUpActivity);
        userPassWordValidation = findViewById(R.id.userPassWordValidationSignUpActivity);
        userConfirmPassWordValidation = findViewById(R.id.userConfirmPassWordValidationSignUpActivity);
        loginAccountText = findViewById(R.id.loginAccountTextSignUpActivity);
        createBtn = findViewById(R.id.createBtnSignUpActivity);

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

//        User PassWord Validation Checked
        TextWatcher userPassWordTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String pass = userPassWord.getText().toString();
                if (pass.isEmpty()) {
                    userPassWordValidation.setVisibility(View.GONE);
                } else if (Pattern.matches("^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,20}$", pass)) {
                    userPassWordValidation.setVisibility(View.VISIBLE);
                    userPassWordValidation.setText(R.string.valid);
                    userPassWordValidation.setTextColor(getResources().getColor(R.color.blue));
                } else {
                    userPassWordValidation.setVisibility(View.VISIBLE);
                    userPassWordValidation.setText(R.string.unValid);
                    userPassWordValidation.setTextColor(getResources().getColor(R.color.red));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        userPassWord.addTextChangedListener(userPassWordTextWatcher);

//        User Confirm PassWord Validation Checked
        TextWatcher userConfirmPassWordTextWatcher = new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                String confirmPass = userConfirmPassWord.getText().toString();
                String pass = userPassWord.getText().toString();
                String passValidation = userPassWordValidation.getText().toString();

                if (confirmPass.isEmpty()) {
                    userConfirmPassWordValidation.setVisibility(View.GONE);
                } else if (passValidation.equals("Valid!") && confirmPass.equals(pass)) {
                    userConfirmPassWordValidation.setVisibility(View.VISIBLE);
                    userConfirmPassWordValidation.setText(R.string.valid);
                    userConfirmPassWordValidation.setTextColor(getResources().getColor(R.color.blue));
                } else {
                    userConfirmPassWordValidation.setVisibility(View.VISIBLE);
                    userConfirmPassWordValidation.setText(R.string.unValid);
                    userConfirmPassWordValidation.setTextColor(getResources().getColor(R.color.red));
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        };
        userConfirmPassWord.addTextChangedListener(userConfirmPassWordTextWatcher);

//       OnClick Query To Login Account Text
        loginAccountText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SignUpActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

//       OnClick Query To Create Button
        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = userNameValidation.getText().toString();
                String number = userNumberValidation.getText().toString();
                String email = userEmailValidation.getText().toString();
                String pass = userPassWordValidation.getText().toString();
                String confirmPass = userConfirmPassWordValidation.getText().toString();

                if (name.equals("Valid!") && number.equals("Valid!") && email.equals("Valid!") && pass.equals("Valid!") && confirmPass.equals("Valid!")) {
                    Intent intent = new Intent(SignUpActivity.this, HomeActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(context, "\t\t\t\t\t\t\t\tUnValid Details \n Enter the correct details and try again!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}