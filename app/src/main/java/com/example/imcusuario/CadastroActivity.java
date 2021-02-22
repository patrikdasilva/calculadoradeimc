package com.example.imcusuario;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.imcusuario.database.AppDataBase;
import com.example.imcusuario.model.Usuario;

public class CadastroActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);
    }
    public void onClickSalvar(View v){
        //cria os edits
        EditText editNome = findViewById(R.id.editUsuario);
        EditText editLogin = findViewById(R.id.editLogin);
        EditText editSenha = findViewById(R.id.editSenha);

        //pega os dados dos edits
        String nome = editNome.getText().toString();
        String login = editLogin.getText().toString();
        String senha = editSenha.getText().toString();

        //obriga o usuario a preencher os campos
        if(nome.equals("") || login.equals("") || senha.equals("")){
            Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
        } else
            try{
                AppDataBase db = Room.databaseBuilder(getApplicationContext(),
                        AppDataBase.class,"appbase_bd")
                        .allowMainThreadQueries()//permitir consultas em threads
                        .build();
                Usuario u = db.usuarioDAO().findByLogin(login);
                //verificar se o usuario ja existe
                if(u != null){
                    Toast.makeText(this, "Usuário já existe", Toast.LENGTH_SHORT).show();
                } else {
                    //criar objeto
                    Usuario usuario = new Usuario();
                    usuario.setNome(nome);
                    usuario.setLogin(login);
                    usuario.setSenha(senha);
                    //salvar objeto
                    db.usuarioDAO().insertUsuarios(usuario);
                    Toast.makeText(this, "Usuário salvo com sucesso.", Toast.LENGTH_SHORT).show();
                    finish();//fechar activity
                }
            } catch (Exception e){
                Toast.makeText(this, "Erro inesperado ao tentar salvar usuário.", Toast.LENGTH_SHORT).show();
            }
    }
    public void onClickVoltar(View v){
        finish();
    }
}

