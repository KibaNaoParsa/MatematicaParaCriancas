package br.wave.matparacriancas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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

        final Intent intent = new Intent(this, DivisaoNormal.class);

        AlertDialog.Builder builder = new AlertDialog.Builder(Divisao.this);
        builder.setTitle("Modo Normal");
        builder.setMessage("No modo normal, aparecerá uma conta na sua tela. " +
                "\nVocê só precisa fazer essa conta, digitar o resultado e confirmar. " +
                "\n\nVocê vai resolver 15 contas.\n" +
                "\nNo final, você vai ver quantas perguntas você acertou.");
        builder.setPositiveButton("Começar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });
        builder.show();
    }

    public void abrirModoQuizDivisao(View view){

        final Intent intent = new Intent(this, DivisaoQuiz.class);

        AlertDialog.Builder builder = new AlertDialog.Builder(Divisao.this);
        builder.setTitle("Modo Tempo");
        builder.setMessage("No modo tempo, aparecerá uma conta na sua tela. " +
                "\nEmbaixo da conta, você verá quatro alternativas. \n" +
                "\nClique na que você achar que é a resposta.\n" +
                "\nSe você não responder em 20 segundos, você não ganhará nenhum ponto naquela pergunta. \n" +
                "\nVocê vai resolver 10 contas.\n" +
                "\nNo final, você vai ver qual foi sua pontuação.");
        builder.setPositiveButton("Começar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });
        builder.show();
    }
}
