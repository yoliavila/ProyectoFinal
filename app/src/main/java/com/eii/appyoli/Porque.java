package com.eii.appyoli;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Porque extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_porque);

        TextView textView = findViewById(R.id.texto);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        textView.startAnimation(animation);
    }
}