package com.example.dell.quarterhour.Activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.example.dell.quarterhour.R;

public class LoginActivity extends AppCompatActivity {

    private TextView login;
    private SharedPreferences chenggong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        chenggong = getSharedPreferences("chenggong", MODE_PRIVATE);
        login = findViewById(R.id.login);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(LoginActivity.this,OtherloginActivity.class);
                startActivity(intent);
                chenggong.edit().clear().commit();
                finish();
            }
        });
    }
}
