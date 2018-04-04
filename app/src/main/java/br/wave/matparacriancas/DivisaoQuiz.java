package br.wave.matparacriancas;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class DivisaoQuiz extends Activity {

    ImageView resA, resB, resC, resD;
    TextView txtA, txtB, txtC, txtD, txtPergunta;
    int n1, n2, teste, pos, resultado, div;
    Random rand;
    String resposta_letra;
    int perguntas, pontos, numero;
    double divisao;
    Intent it, voltar, continuar;
    Bundle res;
    long restante, tempo;
    CountDownTimer contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modo_quiz);

        voltar = getIntent();

        perguntas = voltar.getIntExtra("perguntas", 0);
        pontos = voltar.getIntExtra("pontos", 0);

        res = new Bundle();

        teste = 10;

        tempo = 20000;

        contador = this.contagem(tempo);

        it = new Intent(this, DivisaoQuiz.class);
        continuar = new Intent(this, FinalTempo.class);


        resA = (ImageView) findViewById(R.id.resA);
        resB = (ImageView) findViewById(R.id.resB);
        resC = (ImageView) findViewById(R.id.resC);
        resD = (ImageView) findViewById(R.id.resD);

        txtA = (TextView) findViewById(R.id.txtA);
        txtB= (TextView) findViewById(R.id.txtB);
        txtC = (TextView) findViewById(R.id.txtC);
        txtD = (TextView) findViewById(R.id.txtD);
        txtPergunta = (TextView) findViewById(R.id.txtPergunta);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/myriad_pro_bold.ttf");
        txtA.setTypeface(typeface);
        txtB.setTypeface(typeface);
        txtC.setTypeface(typeface);
        txtD.setTypeface(typeface);
        txtPergunta.setTypeface(typeface);

        rand = new Random();

        do {
            n1 = rand.nextInt(10);
            n2 = rand.nextInt(10);
        } while (n1 == 0 | n2 == 0);

        div = n1*n2;

        resultado = n2;

        pos = rand.nextInt(4);

        if (pos == 0) {
            resposta_letra = "A";

            txtA.setText(String.valueOf(resultado));

            numero = resultado + 1;
            txtB.setText(String.valueOf(numero));

            numero = resultado + 2;
            txtC.setText(String.valueOf(numero));

            numero = resultado + 3;
            txtD.setText(String.valueOf(numero));

        }

        if (pos == 1) {
            resposta_letra = "B";

            numero = resultado - 1;

            if (numero < 0)
                numero = 3;

            txtA.setText(String.valueOf(numero));

            txtB.setText(String.valueOf(resultado));

            numero = resultado + 1;
            txtC.setText(String.valueOf(numero));

            numero = resultado + 2;
            txtD.setText(String.valueOf(numero));
        }

        if (pos == 2) {
            resposta_letra = "C";

            numero = resultado - 2;

            if (numero < 0)
                numero = 3;

            txtA.setText(String.valueOf(numero));

            numero = resultado - 1;

            if (numero < 0)
                numero = 2;

            txtB.setText(String.valueOf(numero));

            txtC.setText(String.valueOf(resultado));

            numero = resultado + 1;
            txtD.setText(String.valueOf(numero));
        }

        if (pos == 3) {
            resposta_letra = "D";

            numero = resultado - 3;

            if (numero < 0)
                numero = 3;

            txtA.setText(String.valueOf(numero));

            numero = resultado - 2;

            if (numero < 0)
                numero = 2;

            txtB.setText(String.valueOf(numero));

            numero = resultado - 1;

            if (numero < 0)
                numero = 1;

            txtC.setText(String.valueOf(numero));

            txtD.setText(String.valueOf(resultado));
        }

        txtPergunta.setText(String.valueOf(div) + " / " + String.valueOf(n1) + " ?");

        resA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resposta_letra.equals("A")) {
                    contador.cancel();
                    divisao = ((double) restante / tempo)*100;
                    pontos += (int) divisao;

                    perguntas += 1;

                    res.putInt("pontos", pontos);
                    res.putInt("perguntas", perguntas);

                    it.putExtras(res);

                    if (perguntas != teste) {
                        startActivity(it);
                    } else {
                        res.putInt("tipo", 0);

                        continuar.putExtras(res);

                        startActivity(continuar);


                    }


                } else {

                    contador.cancel();

                    perguntas += 1;

                    res.putInt("pontos", pontos);
                    res.putInt("perguntas", perguntas);

                    it.putExtras(res);

                    if (perguntas != teste) {
                        startActivity(it);
                    } else {
                        res.putInt("tipo", 0);
                        continuar.putExtras(res);

                        startActivity(continuar);
                    }
                }
            }
        });

        resB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resposta_letra.equals("B")) {
                    contador.cancel();
                    divisao = ((double) restante / tempo)*100;
                    pontos += (int) divisao;

                    perguntas += 1;

                    res.putInt("pontos", pontos);
                    res.putInt("perguntas", perguntas);

                    it.putExtras(res);

                    if (perguntas != teste) {
                        startActivity(it);
                    } else {
                        res.putInt("tipo", 0);
                        continuar.putExtras(res);

                        startActivity(continuar);
                    }

                } else {

                    contador.cancel();

                    perguntas += 1;

                    res.putInt("pontos", pontos);
                    res.putInt("perguntas", perguntas);

                    it.putExtras(res);


                    if (perguntas != teste) {
                        startActivity(it);
                    } else {
                        res.putInt("tipo", 0);
                        continuar.putExtras(res);

                        startActivity(continuar);
                    }
                }
            }
        });

        resC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resposta_letra.equals("C")) {
                    contador.cancel();
                    divisao = ((double) restante / tempo)*100;
                    pontos += (int) divisao;

                    perguntas += 1;
                    res.putInt("pontos", pontos);
                    res.putInt("perguntas", perguntas);

                    it.putExtras(res);

                    if (perguntas != teste) {
                        startActivity(it);
                    } else {
                        res.putInt("tipo", 0);
                        continuar.putExtras(res);

                        startActivity(continuar);

                    }
                } else {

                    contador.cancel();

                    perguntas += 1;

                    res.putInt("pontos", pontos);
                    res.putInt("perguntas", perguntas);

                    it.putExtras(res);

                    if (perguntas != teste) {
                        startActivity(it);
                    } else {
                        res.putInt("tipo", 0);
                        continuar.putExtras(res);

                        startActivity(continuar);
                    }

                }
            }
        });

        resD.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (resposta_letra.equals("D")) {
                    contador.cancel();
                    divisao = ((double) restante / tempo)*100;
                    pontos += (int) divisao;

                    perguntas += 1;
                    res.putInt("pontos", pontos);
                    res.putInt("perguntas", perguntas);

                    it.putExtras(res);

                    if (perguntas != teste) {
                        startActivity(it);
                    } else {
                        res.putInt("tipo", 0);
                        continuar.putExtras(res);

                        startActivity(continuar);
                    }

                } else {

                    contador.cancel();

                    perguntas += 1;

                    res.putInt("pontos", pontos);
                    res.putInt("perguntas", perguntas);

                    it.putExtras(res);

                    if (perguntas != teste) {
                        startActivity(it);
                    } else {
                        res.putInt("tipo", 0);
                        continuar.putExtras(res);

                        startActivity(continuar);

                    }
                }
            }
        });

    }


    public CountDownTimer contagem(long segundos) {
        return new CountDownTimer(segundos, 1) {

            public void onTick(long millisUntilFinished) {
                restante = millisUntilFinished;

            }

            public void onFinish() {
                perguntas += 1;

                res.putInt("pontos", pontos);
                res.putInt("perguntas", perguntas);

                it.putExtras(res);

                if (perguntas != teste) {
                    startActivity(it);
                } else {
                    res.putInt("tipo", 0);
                    continuar.putExtras(res);

                    startActivity(continuar);
                }
            }
        }.start();

    }

    @Override
    public void onBackPressed() {
        contador.cancel();
        Intent it1 = new Intent(this, MainActivity.class);
        startActivity(it1);
        finish();
    }
}
