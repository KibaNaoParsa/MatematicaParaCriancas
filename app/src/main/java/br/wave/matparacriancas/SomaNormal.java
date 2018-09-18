package br.wave.matparacriancas;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

import java.util.Random;

public class SomaNormal extends Activity {

    TextView imgPergunta;
    EditText edtResposta;
    Button btnResponder;
    Random rand;
    int n1, n2, resultado;
    String resposta;
    int acertos, perguntas;
    Bundle info;
    Intent it, continuar, voltar;
    private AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_normal);

        voltar = getIntent();
        MobileAds.initialize(this,
                "ca-app-pub-1594606495855009~4913483748");

        mAdView = findViewById(R.id.adView2);
        AdRequest adRequest = new AdRequest.Builder().addTestDevice(AdRequest.DEVICE_ID_EMULATOR).build();
        mAdView.loadAd(adRequest);

        perguntas = voltar.getIntExtra("perguntas", 0);
        acertos = voltar.getIntExtra("acertos", 0);

        info = new Bundle();

        imgPergunta = (TextView) findViewById(R.id.imgPergunta);
        edtResposta = (EditText) findViewById(R.id.modoZenText);
        btnResponder = (Button) findViewById(R.id.btnResponder);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/myriad_pro_bold.ttf");
        imgPergunta.setTypeface(typeface);
        edtResposta.setTypeface(typeface);
        btnResponder.setTypeface(typeface);

        it = new Intent(this, SomaNormal.class);
        continuar = new Intent(this, FinalNormal.class);

        rand = new Random();

        do {
            n1 = rand.nextInt(60);
            n2 = rand.nextInt(60);
        } while (n1 == 0 || n2 == 0);

        resultado = n1 + n2;

        imgPergunta.setText(String.valueOf(n1) + " + " + String.valueOf(n2) + " ?");

        btnResponder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resposta = String.valueOf(edtResposta.getText());

                if (resposta.equals(String.valueOf(resultado))) {
                    Toast.makeText(getApplicationContext(), "Resposta correta!", Toast.LENGTH_SHORT).show();
                    acertos+=1;
                } else {
                    Toast.makeText(getApplicationContext(), "Resposta errada! (" + String.valueOf(resultado) + ")", Toast.LENGTH_SHORT).show();
                }

                perguntas+=1;

                info.putInt("acertos", acertos);
                info.putInt("perguntas", perguntas);

                it.putExtras(info);

                if (perguntas != 15) {
                    startActivity(it);
                } else {
                    info.putInt("tipo", 0);
                    continuar.putExtras(info);

                    startActivity(continuar);
                }

            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent itM = new Intent(this, MainActivity.class);
        startActivity(itM);
    }
}
