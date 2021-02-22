package com.example.imcusuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.imcusuario.database.AppDataBase;
import com.example.imcusuario.model.Usuario;

public class LoginActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_USUARIOID = "br.com.ImcUsuario.EXTRA_MESSAGE_USUARIOID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }
    public void onClickEntra(View v){
        EditText editNome = findViewById(R.id.editUsuario);
        EditText editSenha = findViewById(R.id.editSenha);

        String login = editNome.getText().toString();
        String senha = editSenha.getText().toString();
        if(login.equals("") || senha.equals("")){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else {
            try{
                AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                        AppDataBase.class,"appbase_bd")
                        .allowMainThreadQueries()//permitir consultas em thread
                        .build();
                Usuario usuario = db.usuarioDAO().findByLoginAndSenha(login,senha);
                if(usuario != null){
                    Intent iMain = new Intent(this,MainActivity.class);
                   iMain.putExtra(EXTRA_MESSAGE_USUARIOID, usuario.getId());
                    startActivity(iMain);
                    finish();
                } else {
                    Toast.makeText(this, "Usuário ou senha inválidos", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception e){
                Toast.makeText(this, "Ocorreu um erro inesperado ao tentar entrar.", Toast.LENGTH_SHORT).show();
            }
        }

        }
    public void onClickCadastrar(View v){
        Intent iCadastro = new Intent(this,CadastroActivity.class);
        startActivity(iCadastro);
    }
    public void onClickVoltar(View v){
        finish();
    }
}