package com.eii.appyoli;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.eii.appyoli.parseador_patrones.ParsePatrones;
import com.eii.appyoli.parseador_patrones.Tupla;

import java.util.List;

public class LetrasActivity extends AppCompatActivity {
    GridLayout layoutBotonesLetras;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_letras);

        layoutBotonesLetras=findViewById(R.id.layoutLetras);
       textView = findViewById(R.id.aprendertxt);
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        textView.startAnimation(animation);
        List<Tupla<String,String>> patrones=ParsePatrones.getLetrasPatrones(getApplicationContext());
        for(Tupla<String,String> tupla: patrones){
            Button b=new Button(this);
            b.setText(tupla.getClave());
            Typeface typeface = getResources().getFont(R.font.verdana);
            b.setTypeface(typeface);
            GridLayout.LayoutParams layoutParams = new GridLayout.LayoutParams();
            int marginPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 5, getResources().getDisplayMetrics());
            layoutParams.setMargins(marginPixels, marginPixels, marginPixels, marginPixels);
            int widthPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, getResources().getDisplayMetrics());
            layoutParams.width = widthPixels;
            int heightPixels = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 70, getResources().getDisplayMetrics());
            layoutParams.height = heightPixels;
            int color = getResources().getColor(R.color.verdeOscuro);
            b.setTextColor(color);
            b.setLayoutParams(layoutParams);
            b.setBackgroundResource(R.drawable.rounded_button_background_green);
            b.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(LetrasActivity.this, AprenderPatronActivity.class);

                    Bundle bundle = new Bundle();
                    bundle.putString("letra", b.getText()+"");
                    intent.putExtras(bundle);

                    startActivity(intent);
                }
            });
            layoutBotonesLetras.addView(b);
        }
    }
}
