package com.einfoplanet.sharedpreferences;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class B_Activity extends AppCompatActivity {
    Button btnLoadData,btnMoveBack;
    EditText etUsername,etPassword;
    public final String DEFAULT="N/A";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b_);

        btnLoadData=(Button)findViewById(R.id.btnLoadData);
        btnMoveBack=(Button)findViewById(R.id.btnMoveBack);

        //initialization of edittext
        etUsername=(EditText)findViewById(R.id.etLoadUsrname);
        etPassword=(EditText)findViewById(R.id.etLoadPassword);
    }

    public void loadData(View view){
        SharedPreferences sharedPreferences=getSharedPreferences("MyData", Context.MODE_PRIVATE);
        String username=sharedPreferences.getString("username", DEFAULT);
        String password=sharedPreferences.getString("password",DEFAULT);
        if (username.equals(DEFAULT) || password.equals(DEFAULT)){
            Toast.makeText(this,"Data not loaded successfully.",Toast.LENGTH_SHORT).show();
        }else {
            etUsername.setText(username);
            etPassword.setText(password);
            Toast.makeText(this,"Data load successfully.",Toast.LENGTH_SHORT).show();
        }
    }

    public void  moveBack(View view){
        startActivity(new Intent(this,MainActivity.class));
        Toast.makeText(this,"Moving to main Activity.",Toast.LENGTH_SHORT).show();
    }
}
