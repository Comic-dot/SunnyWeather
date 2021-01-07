package com.sunnyweather.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginInterfaceActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_interface);
    }

    public void senf(View view) {
        Intent intent = new Intent(LoginInterfaceActivity.this, MainActivity.class);
        startActivity(intent);
    }
}