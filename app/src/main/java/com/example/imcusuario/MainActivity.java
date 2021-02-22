package com.example.imcusuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private long usuarioId;
    public static final String EXTRA_MESSAGE_USUARIOID = "br.com.ImcUsuario.EXTRA_MESSAGE_USUARIOID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent i = getIntent();
        usuarioId = i.getLongExtra(LoginActivity.EXTRA_MESSAGE_USUARIOID,1);
    }
    public void onClickEntrar(View v){
        Intent iImc = new Intent(this, CalculoImcActivity.class);
        iImc.putExtra(EXTRA_MESSAGE_USUARIOID, usuarioId);
        startActivity(iImc);
        finish();
    }
        public void onClickHistorico(View v){
        Intent iHistorico = new Intent(this, HistoricoActivity.class);
        iHistorico.putExtra(EXTRA_MESSAGE_USUARIOID, usuarioId);
        startActivity(iHistorico);
    }
}