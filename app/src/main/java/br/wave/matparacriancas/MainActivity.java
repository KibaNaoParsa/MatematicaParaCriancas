package br.wave.matparacriancas;


import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
public class MainActivity extends Activity {

    Button btnFace, btnEstrela;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFace = (Button) findViewById(R.id.btnFace);
        btnEstrela = (Button) findViewById(R.id.btnEstrela);

        btnFace.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://www.facebook.com/WAVE-Development-519975971719289";
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

        btnEstrela.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://play.google.com/store/apps/details?id=br.wave.matparacriancas";
                Uri uri = Uri.parse(url);
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);
            }
        });

    }

    public void abrirSoma(View view){

        Intent intent = new Intent(this, Soma.class);
        startActivity(intent);
    }

    public void abrirSubtracao(View view){

        Intent intent = new Intent(this, Subtracao.class);
        startActivity(intent);
    }

    public void abrirMultiplicacao(View view){

        Intent intent = new Intent(this, Multiplicacao.class);
        startActivity(intent);
    }

    public void abrirDivisao(View view){

        Intent intent = new Intent(this, Divisao.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed() {
        finish();
        System.exit(0);
    }
}
