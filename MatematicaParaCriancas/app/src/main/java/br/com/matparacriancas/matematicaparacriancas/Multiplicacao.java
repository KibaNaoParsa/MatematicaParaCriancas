package br.com.matparacriancas.matematicaparacriancas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Multiplicacao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplicacao);
    }

    public void abrirModoNormalMultiplicacao(View view){

        Intent intent = new Intent(this, ModoNormalMult.class);
        startActivity(intent);
    }

    public void abrirModoQuizMultiplicacao(View view){

        Intent intent = new Intent(this, ModoQuizMult.class);
        startActivity(intent);
    }
}
