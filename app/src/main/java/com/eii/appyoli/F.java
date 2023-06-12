package com.eii.appyoli;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Vibrator;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.List;

public class F extends AppCompatActivity {
    private Button boton1;
    private Button boton2;
    private Button boton3;
    private Button boton4;
    private Button boton5;
    private Button boton6;

    private Vibrator vibrator;
    private List<Button> botonesVibrantes;
    private boolean secuenciaCorrecta;

    private List<Button> botonesPulsados;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_f);

        boton1 = findViewById(R.id.button1);
        boton2 = findViewById(R.id.button2);
        boton3 = findViewById(R.id.button3);
        boton4 = findViewById(R.id.button4);
        boton5 = findViewById(R.id.button5);
        boton6 = findViewById(R.id.button6);

        vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);

        botonesVibrantes = new ArrayList<>();
        botonesVibrantes.add(boton1);
        botonesVibrantes.add(boton2);
        botonesVibrantes.add(boton3);
        botonesPulsados = new ArrayList<>();

        boton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrateForOneSecond();
                verificarSecuencia(boton1);
            }
        });

        boton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrateForOneSecond();
                verificarSecuencia(boton2);
            }
        });

        boton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                vibrateForOneSecond();
                verificarSecuencia(boton3);
            }
        });

        boton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSecuencia(boton4);
            }
        });

        boton5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSecuencia(boton5);
            }
        });

        boton6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                verificarSecuencia(boton6);
            }
        });
    }

    private void vibrateForOneSecond() {
        if (vibrator != null && vibrator.hasVibrator()) {
            // Vibrar durante un segundo (1000 milisegundos)
            vibrator.vibrate(500);
        }
    }

    private void verificarSecuencia(Button boton) {
        if (botonesVibrantes.contains(boton)) {
            if (!botonesPulsados.contains(boton)) {
                botonesPulsados.add(boton);
            }
            if (botonesPulsados.containsAll(botonesVibrantes)) {
                // Se han pulsado todos los botones que vibran
                Toast.makeText(F.this, "¡Lo has hecho bien! Sigue así.", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(F.this, Dificultad.class);
                startActivity(intent);
                finish();
            }
        } else {
            // Se pulsó un botón que no vibra
            Toast.makeText(F.this, "Esta no es la secuencia correcta. Sigue intentándolo.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(F.this, Dificultad.class);
            startActivity(intent);
            finish();
        }
    }
}
