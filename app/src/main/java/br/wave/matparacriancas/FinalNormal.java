package br.wave.matparacriancas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class FinalNormal extends Activity {

    TextView txtResultado;
    Intent rec, fim, vSoma, vDiv, vMult, vSub;
    int perguntas, acertos, tipo;
    String resultado;
    Button btnRefazer, btnFim;
    InterstitialAd mInterstitialAd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_normal);

        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());

        btnRefazer = (Button) findViewById(R.id.btnRepetir);
        btnFim = (Button) findViewById(R.id.btnFinalizar);
        txtResultado = (TextView) findViewById(R.id.txtResultado);

        Typeface typeface = Typeface.createFromAsset(getAssets(),"fonts/myriad_pro_bold.ttf");
        txtResultado.setTypeface(typeface);


        vSoma = new Intent(this, SomaNormal.class);
        vSub = new Intent(this, SubtracaoNormal.class);
        vDiv = new Intent(this, DivisaoNormal.class);
        vMult = new Intent(this, ModoNormalMult.class);

        fim = new Intent(this, MainActivity.class);

        rec = getIntent();
        perguntas = rec.getIntExtra("perguntas", 0);
        acertos = rec.getIntExtra("acertos", 0);

        resultado = String.valueOf(acertos) + " acertos em " + String.valueOf(perguntas) + " perguntas!";
        txtResultado.setText(resultado);

        tipo = rec.getIntExtra("tipo", 4);

        btnRefazer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }

                if (tipo == 0) {
                    startActivity(vSoma);
                }
                if (tipo == 1) {
                    startActivity(vSub);
                }
                if (tipo == 2) {
                    startActivity(vDiv);
                }
                if (tipo == 3) {
                    startActivity(vMult);
                }


            }
        });

        btnFim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (mInterstitialAd.isLoaded()) {
                    mInterstitialAd.show();
                }

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
