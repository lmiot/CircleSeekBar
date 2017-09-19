package com.lmiot.circleseekbar;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.lmiot.circleseekbarlibrary.CircleSeekBar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CircleSeekBar circleSeekBar= (CircleSeekBar) findViewById(R.id.id_circle_seekbar);
        circleSeekBar.setAngle(270);
    }
}
