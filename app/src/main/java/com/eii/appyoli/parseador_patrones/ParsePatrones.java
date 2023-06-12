package com.eii.appyoli.parseador_patrones;

import android.content.Context;
import android.content.res.Resources;

import com.eii.appyoli.R;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParsePatrones {

    public static List<Tupla<String,String>> getLetrasPatrones(Context context){
        String texto =context.getString(R.string.patrones);
        String[] separadas = texto.split(" ");
        List<Tupla<String,String>> patrones = new ArrayList<>();
        for(int i=0; i<separadas.length; i++) {
            String[] valor = separadas[i].split(":");
            patrones.add(new Tupla<String, String>(valor[0], valor[1]));
        }
        return patrones;
    }


}
