package com.eii.appyoli;

import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Vibrator;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import com.eii.appyoli.parseador_patrones.ParsePatrones;

import java.util.Locale;

public class AprenderPatronActivity extends AppCompatActivity {
    private String letra;
    private String patron;
    private GridLayout layoutBotonesPatron;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aprender_patron);

        layoutBotonesPatron=findViewById(R.id.layoutAprenderPatrones);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            letra = bundle.getString("letra");
        }else{
            throw new RuntimeException("No se pasó ninguna letra en el Bundle");
        }
        char letraMayus=letra.toUpperCase().charAt(0);
        int posicion = letraMayus - 'A';

        patron = ParsePatrones.getLetrasPatrones(getApplicationContext()).get(posicion).getValor();

        dibujarPatron();

    }

    private void dibujarPatron(){
        char[] patronArray=patron.toCharArray();
        for(int i=0;i<patronArray.length;i++){
            Button b=new Button(this);

            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            layoutParams.width = 0;
            layoutParams.columnSpec = GridLayout.spec(GridLayout.UNDEFINED, 1f); // Peso relativo de 1
            int heightPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 213, getResources().getDisplayMetrics());
            layoutParams.height = heightPixels;
            int marginPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 8, getResources().getDisplayMetrics());
            layoutParams.setMargins(marginPixels, marginPixels, marginPixels, marginPixels);

            b.setLayoutParams(layoutParams);
            if(patronArray[i]=='1'){
                b.setBackgroundResource(R.drawable.rounded_button_background_blue);
                b.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        vibrar();
                    }
                });
            }else{
                b.setBackgroundResource(R.drawable.rounded_button_background_green);
            }
            layoutBotonesPatron.addView(b);
        }
    }


    private void vibrar(){
        Vibrator vibrator = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
        if (vibrator.hasVibrator()) {
            long duracion = 500; // 1/2 segundo
            vibrator.vibrate(duracion);
        }
    }
}
