package com.example.imcusuario;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import com.example.imcusuario.database.AppDataBase;
import com.example.imcusuario.model.Imc;

import java.util.List;

public class HistoricoActivity extends AppCompatActivity {
    private AppDataBase db;
    private List<Imc> imcs;
    private ArrayAdapter<Imc> adapter;
    private ListView lvImc;

    private long usuarioId;
    public static final String EXTRA_MESSAGE_USUARIOID = "br.com.ImcUsuario.EXTRA_MESSAGE_USUARIOID";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historico);

        db = Room.databaseBuilder(getApplicationContext(),
                AppDataBase.class,"appbase_bd")
                .allowMainThreadQueries()
                .build();
        Intent i = getIntent();
        usuarioId = i.getLongExtra(LoginActivity. EXTRA_MESSAGE_USUARIOID,1);

        imcs = db.imcDAO().findByUsuario(usuarioId);
        adapter = new ArrayAdapter<Imc>(this,R.layout.support_simple_spinner_dropdown_item, imcs);
        lvImc = findViewById(R.id.lvImc);
        lvImc.setAdapter(adapter);
        lvImc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(HistoricoActivity.this, "ID: "+id, Toast.LENGTH_SHORT).show();
            }
        }
        );
    }
    public void onClickNovo(View v){
        Intent iImc = new Intent(this, CalculoImcActivity.class);
        iImc.putExtra(EXTRA_MESSAGE_USUARIOID, usuarioId);
        startActivity(iImc);
        finish();
    }

}