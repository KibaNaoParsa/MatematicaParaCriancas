package br.com.matparacriancas.matematicaparacriancas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Divisao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisao);
    }

    public void abrirModoNormalDivisao(View view){

        Intent intent = new Intent(this, DivisaoNormal.class);
        startActivity(intent);
    }

    public void abrirModoQuizDivisao(View view){

        Intent intent = new Intent(this, DivisaoQuiz.class);
        startActivity(intent);
    }
}
