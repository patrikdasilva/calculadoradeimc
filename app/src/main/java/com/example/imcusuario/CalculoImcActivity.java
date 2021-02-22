package com.example.imcusuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.imcusuario.database.AppDataBase;
import com.example.imcusuario.model.Imc;

public class CalculoImcActivity extends AppCompatActivity {
    private AppDataBase db;
    private long usuarioId;
    private static final String EXTRA_MESSAGE_USUARIOID = "br.com.ImcUsuario.EXTRA_MESSAGE_USUARIOID";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo_imc);
        Intent i = getIntent();
        usuarioId = i.getLongExtra(MainActivity.EXTRA_MESSAGE_USUARIOID, 1);
        db = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class,"appbase_bd")
                .allowMainThreadQueries()
                .build();
    }

   public void onClickVoltar(View v){
        finish();
   }
   public void onClickAbrirHistorico(View v){
        Intent iHistorico = new Intent(getApplicationContext(),HistoricoActivity.class);
        iHistorico.putExtra(EXTRA_MESSAGE_USUARIOID, usuarioId);
        startActivity(iHistorico);
        finish();
   }
   public void onClickSalvar(View v){
        EditText editAltura = findViewById(R.id.editAltura);
        EditText editPeso = findViewById(R.id.editPeso);
        TextView editImc = findViewById(R.id.editImc);
        TextView editResultado = findViewById(R.id.editResultado);

    if(editAltura.getText().toString().equals("") || editPeso.getText().toString().equals("")){
        Toast.makeText(this, "Preencha todos os campos", Toast.LENGTH_SHORT).show();
    } else {
        try{
            double altura = Double.parseDouble(editAltura.getText().toString());
            double peso = Double.parseDouble(editPeso.getText().toString());

            Imc imc = new Imc();
            imc.setAltura(altura);
            imc.setPeso(peso);
            imc.calcularImc();
            imc.setUsuarioId(usuarioId);

           // Toast.makeText(this, "imc="+imc.getImc()+" Resultado="+imc.getResultado()+"usuario: "+imc.getUsuarioId(), Toast.LENGTH_SHORT).show();

            db.imcDAO().insertImcs(imc);

            String imc_texto = String.format("%.2f",imc.getImc());
            editImc.setText(imc_texto);
            editResultado.setText(imc.getResultado());

            Toast.makeText(this, "Cálculo realizado com sucesso.", Toast.LENGTH_SHORT).show();
        } catch (Exception e){
            Toast.makeText(this, "Erro inesperado."+e.getMessage()+"usuario "+usuarioId, Toast.LENGTH_SHORT).show();
        }
     }
   }
}

