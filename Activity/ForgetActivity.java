package com.example.dell.quarterhour.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.dell.quarterhour.R;

public class ForgetActivity extends AppCompatActivity {

    private Button otherlogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        otherlogin = findViewById(R.id.otherlogin);
        otherlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(ForgetActivity.this, ChangeActivity.class);
                startActivity(intent);
            }
        });
    }


}
