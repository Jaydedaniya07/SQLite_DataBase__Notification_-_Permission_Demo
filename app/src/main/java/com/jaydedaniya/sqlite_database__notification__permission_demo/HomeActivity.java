package com.jaydedaniya.sqlite_database__notification__permission_demo;

import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContract;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.jaydedaniya.sqlite_database__notification__permission_demo.dbHelper.UserDataHandler;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class HomeActivity extends AppCompatActivity {

    ActivityResultLauncher<String[]> PermissionResultLauncher;

    private boolean isReadExternalStoragePermissionGranted = false;
    private boolean isWriteExternalStoragePermissionGranted = false;
    private boolean isManageExternalStoragePermissionGranted = false;
    private boolean isPhoneCallPermissionGranted = false;
    private boolean isCameraPermissionGranted = false;
    private boolean isAccessBackgroundLocationPermissionGranted = false;

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

        PermissionResultLauncher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback<Map<String, Boolean>>() {
            @Override
            public void onActivityResult(Map<String, Boolean> result) {

                if(result.get(Manifest.permission.READ_EXTERNAL_STORAGE) != null){
                    isReadExternalStoragePermissionGranted = result.get(Manifest.permission.READ_EXTERNAL_STORAGE);
                }
                if(result.get(Manifest.permission.WRITE_EXTERNAL_STORAGE) != null){
                    isWriteExternalStoragePermissionGranted = result.get(Manifest.permission.WRITE_EXTERNAL_STORAGE);
                }
                if(result.get(Manifest.permission.MANAGE_EXTERNAL_STORAGE) != null){
                    isManageExternalStoragePermissionGranted = result.get(Manifest.permission.MANAGE_EXTERNAL_STORAGE);
                }
                if(result.get(Manifest.permission.CALL_PHONE)!= null){
                    isPhoneCallPermissionGranted=result.get(Manifest.permission.CALL_PHONE);
                }
                if (result.get(Manifest.permission.CAMERA)!=null){
                    isCameraPermissionGranted=result.get(Manifest.permission.CAMERA);
                }
                if(result.get(Manifest.permission.ACCESS_BACKGROUND_LOCATION) != null){
                    isManageExternalStoragePermissionGranted = result.get(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
                }

            }
        });
        requestPermission();



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

    private void requestPermission(){

        isReadExternalStoragePermissionGranted = ContextCompat.checkSelfPermission(context,Manifest.permission.READ_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        isWriteExternalStoragePermissionGranted = ContextCompat.checkSelfPermission(context,Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        isManageExternalStoragePermissionGranted = ContextCompat.checkSelfPermission(context,Manifest.permission.MANAGE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

        isPhoneCallPermissionGranted = ContextCompat.checkSelfPermission(context, Manifest.permission.CALL_PHONE) == PackageManager.PERMISSION_GRANTED;

        isCameraPermissionGranted = ContextCompat.checkSelfPermission(context, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED;

        isAccessBackgroundLocationPermissionGranted = ContextCompat.checkSelfPermission(context, Manifest.permission.ACCESS_BACKGROUND_LOCATION) == PackageManager.PERMISSION_GRANTED;


        List<String> permissionRequest = new ArrayList<>();
        if( ! isReadExternalStoragePermissionGranted){
            permissionRequest.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if( ! isWriteExternalStoragePermissionGranted){
            permissionRequest.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if( ! isManageExternalStoragePermissionGranted){
            permissionRequest.add(Manifest.permission.MANAGE_EXTERNAL_STORAGE);
        }
        if( ! isPhoneCallPermissionGranted){
            permissionRequest.add(Manifest.permission.CALL_PHONE);
        }
        if( ! isCameraPermissionGranted){
            permissionRequest.add(Manifest.permission.CAMERA);
        }
        if( ! isAccessBackgroundLocationPermissionGranted){
            permissionRequest.add(Manifest.permission.ACCESS_BACKGROUND_LOCATION);
        }

        if( ! permissionRequest.isEmpty()){
            PermissionResultLauncher.launch(permissionRequest.toArray(new String[0]));
        }

    }

}