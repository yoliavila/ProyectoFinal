package com.eii.appyoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button buttonAprender;
    private Button buttonJugar;

    private Button buttonporque;

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonAprender=findViewById(R.id.vamosBtn);
        buttonJugar=findViewById(R.id.jugamosBtn);
        imageView = findViewById(R.id.imageView);
        Animation rotationAnimation = AnimationUtils.loadAnimation(this, R.anim.rotate_animation);
        imageView.startAnimation(rotationAnimation);
        TextView textView = findViewById(R.id.Bienvenida);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        textView.startAnimation(animation);
buttonporque = findViewById(R.id.porqueBtn);

        buttonAprender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LetrasActivity.class);
                startActivity(intent);
            }

        });
        buttonJugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Dificultad.class);
                startActivity(intent1);
            }
        });
        buttonporque.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(MainActivity.this, Porque.class);
                startActivity(intent1);
            }
        });
 imageView.setOnClickListener(new View.OnClickListener() {
     @Override
     public void onClick(View v) {
         textView.startAnimation(animation);
         imageView.startAnimation(rotationAnimation);
     }
 });

    }
}