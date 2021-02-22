package com.example.imcusuario;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {
    private static final int TEMPO_PARA_ABRIR = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        Handler handler = new Handler();
        handler.postDelayed(
                new Runnable() {
                    @Override
                    public void run() {
                        abrirLogin();
                    }
                }, TEMPO_PARA_ABRIR

        );
    }
    private void abrirLogin(){
        Intent iLogin = new Intent(this,LoginActivity.class);
        startActivity(iLogin);
        finish();
    }
}