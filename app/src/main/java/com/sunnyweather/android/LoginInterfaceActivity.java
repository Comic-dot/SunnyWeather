package com.sunnyweather.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.sunnyweather.android.db.MyDBHelper;

public class LoginInterfaceActivity extends AppCompatActivity {
    private MyDBHelper dbHelper;
    private EditText username;
    private EditText userpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);//去掉标题栏
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);//去掉信息栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_interface);
        dbHelper = new MyDBHelper(this,"UserStore.db",null,1);
    }


    public void signinClick(View view) {
        username=findViewById(R.id.account);
        userpassword=findViewById(R.id.password);
        String userName=username.getText().toString();
        String passWord=userpassword.getText().toString();
        if (login(userName,passWord)) {
            Toast.makeText(LoginInterfaceActivity.this, "登陆成功", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(LoginInterfaceActivity.this,MainActivity.class);
            startActivity(intent);
        }
        else {
            Toast.makeText(LoginInterfaceActivity.this, "登陆失败", Toast.LENGTH_SHORT).show();
        }
    }

    public void registerClick(View view) {
        Intent intent = new Intent(LoginInterfaceActivity.this,RegisterActivity.class);
        startActivity(intent);

    }
    public boolean login(String username,String password) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        String sql = "select * from userData where name=? and password=?";
        Cursor cursor = db.rawQuery(sql, new String[] {username, password});
        if (cursor.moveToFirst()) {
            cursor.close();
            return true;
        }
        return false;
    }


}