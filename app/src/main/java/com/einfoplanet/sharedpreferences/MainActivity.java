package com.einfoplanet.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btnSave,btnMoveToB;
    EditText etUsername,etPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initializing the button instances
        btnSave= (Button) findViewById(R.id.btnSave);
        btnMoveToB=(Button)findViewById(R.id.btnMove);

        //initializing the edit text
        etUsername=(EditText)findViewById(R.id.etSaveUsrname);
        etPassword=(EditText)findViewById(R.id.etSavePassword);
    }
    public void move(View view){
        startActivity(new Intent(this,B_Activity.class));
        Toast.makeText(this,"Moving to activity B.",Toast.LENGTH_SHORT).show();
    }
    public void saveData(View view){
        //intializing the sharedpreferences instance
        SharedPreferences sharedPreferences=getSharedPreferences("MyData",MODE_PRIVATE);
        //SharedPreferences.Editor class for editing the preferences.
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("username",etUsername.getText().toString());//editing the username
        editor.putString("password",etPassword.getText().toString());//editing the password

        //After editing the changes we should have to commit that changed
        editor.commit();
        etUsername.setText("");
        etPassword.setText("");

        Toast.makeText(this,"Data save successfully.",Toast.LENGTH_SHORT).show();
    }
}
