package com.sunnyweather.android;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.sunnyweather.android.db.MyDBHelper;

public class RegisterActivity extends AppCompatActivity {
    private MyDBHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        dbHelper = new MyDBHelper(this,"UserStore.db",null,1);
    }
    public void ButtonClick_1(View view) {
        Intent intent = new Intent(RegisterActivity.this,LoginInterfaceActivity.class);
        startActivity(intent);
    }

    public void ButtonClick_2(View view) {
        EditText editText3 = (EditText) findViewById(R.id.account_1);
        EditText editText4 = (EditText) findViewById(R.id.password_1);
        String newname = editText3.getText().toString();
        String password = editText4.getText().toString();
        if (CheckIsDataAlreadyInDBorNot(newname)) {
            Toast.makeText(this, "该用户名已被注册，注册失败", Toast.LENGTH_SHORT).show();
        } else {
            if (register(newname, password)) {
                Toast.makeText(this, "插入数据表成功", Toast.LENGTH_SHORT).show();
            }
        }
    }
    public boolean register(String username,String password){
        SQLiteDatabase db= dbHelper.getWritableDatabase();
        ContentValues values=new ContentValues();
        values.put("name",username);
        values.put("password",password);
        db.insert("userData",null,values);
        db.close();
        return true;
    }
    //检验用户名是否已存在
    public boolean CheckIsDataAlreadyInDBorNot(String value){
        SQLiteDatabase db=dbHelper.getWritableDatabase();
        String Query = "Select * from userData where name =?";
        Cursor cursor = db.rawQuery(Query,new String[] { value });
        if (cursor.getCount()>0){
            cursor.close();
            return  true;
        }
        cursor.close();
        return false;
    }
}