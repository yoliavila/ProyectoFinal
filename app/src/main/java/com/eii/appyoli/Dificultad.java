package com.eii.appyoli;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.eii.appyoli.parseador_patrones.ParsePatrones;
import com.eii.appyoli.parseador_patrones.Tupla;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
public class Dificultad extends AppCompatActivity {
    SeekBar miSeekBar;
    Button done;

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dificultad);

        miSeekBar = findViewById(R.id.seekBar);
        done = findViewById(R.id.done);
        textView = findViewById(R.id.textView);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        textView.startAnimation(animation);



        done.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (miSeekBar.getProgress() == 0) {
                    Intent intent = new Intent(Dificultad.this, C.class);
                    Toast.makeText(getApplicationContext(), "¡Muestra tu estilo en los botones!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                } else if (miSeekBar.getProgress() == 1) {
                    Intent intent = new Intent(Dificultad.this, E.class);
                    Toast.makeText(getApplicationContext(), "¡Siguiente nivel!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                } else if (miSeekBar.getProgress() == 2) {
                    Intent intent = new Intent(Dificultad.this, A.class);
                    Toast.makeText(getApplicationContext(), "¡Empecemos por algo sencillo!", Toast.LENGTH_SHORT).show();
                    startActivity(intent);

                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(Dificultad.this, MainActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finishAffinity();
    }


}
