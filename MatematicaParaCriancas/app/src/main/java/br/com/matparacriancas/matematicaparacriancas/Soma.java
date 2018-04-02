package br.com.matparacriancas.matematicaparacriancas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Soma extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soma);
    }

    public void abrirModoNormalSoma(View view){

        Intent intent = new Intent(this, SomaNormal.class);
        startActivity(intent);
    }




}
