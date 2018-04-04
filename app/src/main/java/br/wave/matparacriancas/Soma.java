package br.wave.matparacriancas;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
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


        final Intent intent = new Intent(this, SomaNormal.class);

        AlertDialog.Builder builder = new AlertDialog.Builder(Soma.this);
        builder.setTitle("Modo Normal");
        builder.setMessage("No modo normal, aparecerá uma conta na sua tela. " +
                "\nVocê só precisa fazer essa conta, digitar o resultado e confirmar. \n" +
                "\nVocê vai resolver 15 contas.\n" +
                "\nNo final, você vai ver quantas perguntas você acertou.");
        builder.setPositiveButton("Começar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                startActivity(intent);
            }
        });
        builder.show();
    }




}
