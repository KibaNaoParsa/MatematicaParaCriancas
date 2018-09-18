package br.wave.matparacriancas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalTempo extends Activity {

    TextView txtResultado;
    Intent rec;
    int resultado, tipo;
    Button btnRepetir, btnFinalizar;
    Intent fim, vDiv, vMult;
    //InterstitialAd mInterstitialAd;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_tempo);

        txtResultado = (TextView) findViewById(R.id.txtResultado);
        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/myriad_pro_bold.ttf");
        txtResultado.setTypeface(typeface);

        /*Typeface font = Typeface.createFromAsset(getAssets(), "fonts/myriad_pro_bold.ttf");
        txtResultado.setTypeface(font);*/

        /*
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        */

        rec = getIntent();

        fim = new Intent(this, MainActivity.class);
        vMult = new Intent(this, ModoQuizMult.class);
        vDiv = new Intent(this, DivisaoQuiz.class);


        resultado = rec.getIntExtra("pontos", 0);
        tipo = rec.getIntExtra("tipo", 2);

        txtResultado.setText(String.valueOf(resultado) + " pontos");


        btnRepetir = (Button) findViewById(R.id.btnRepetir);
        btnFinalizar = (Button) findViewById(R.id.btnFinalizar);

        btnRepetir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

               if (tipo == 0)
                   startActivity(vDiv);
               if (tipo == 1)
                   startActivity(vMult);

            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                startActivity(fim);

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent itM = new Intent(this, MainActivity.class);
        startActivity(itM);
    }

}
