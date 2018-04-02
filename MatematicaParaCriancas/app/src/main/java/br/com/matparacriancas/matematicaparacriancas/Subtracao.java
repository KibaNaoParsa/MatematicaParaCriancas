package br.com.matparacriancas.matematicaparacriancas;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Subtracao extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_subtracao);
    }

    public void abrirModoNormalSubtracao(View view){

        Intent intent = new Intent(this, SubtracaoNormal.class);
        startActivity(intent);
    }

}
