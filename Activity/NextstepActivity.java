package com.example.dell.quarterhour.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.VideoView;

import com.example.dell.quarterhour.R;

public class NextstepActivity extends AppCompatActivity {

    private VideoView videoview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nextstep);
        videoview = findViewById(R.id.videoview);

    }



}
