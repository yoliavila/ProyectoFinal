package com.eii.appyoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class A extends AppCompatActivity {
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;

    private List<Button> botonesVibrantes;
    private List<Button> botonesPulsados;

    private Vibrator vibrator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);

        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);

        botonesVibrantes = new ArrayList<>();
        botonesVibrantes.add(button1);

        botonesPulsados = new ArrayList<>();

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrateForOneSecond();
                verificarSecuencia(button1);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSecuencia(button2);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSecuencia(button3);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSecuencia(button4);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSecuencia(button5);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSecuencia(button6);
            }
        });
    }

    private void vibrateForOneSecond() {
        if (vibrator != null && vibrator.hasVibrator()) {
            vibrator.vibrate(500);
        }
    }

    private void verificarSecuencia(Button boton) {
        if (botonesVibrantes.contains(boton)) {
            if (!botonesPulsados.contains(boton)) {
                botonesPulsados.add(boton);
            }
            if (botonesPulsados.containsAll(botonesVibrantes)) {
                Toast.makeText(A.this, "¡Secuencia correcta! Sigue adelante.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(A.this, G.class);
                startActivity(intent);
                finish();
            }
        } else {
            botonesPulsados.clear();
            Toast.makeText(A.this, "Esta no es la secuencia correcta. Sigue intentándolo.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(A.this, Dificultad.class);
            startActivity(intent);
            finish();
        }
    }
}
