package com.example.imcusuario.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.imcusuario.model.Imc;
import com.example.imcusuario.model.ImcDAO;
import com.example.imcusuario.model.Usuario;
import com.example.imcusuario.model.UsuarioDAO;

@Database(entities = {Usuario.class, Imc.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase {
    //persistencia da classe usuario
    public abstract UsuarioDAO usuarioDAO();

    //persistencia da classe imc
    public abstract ImcDAO imcDAO();
}
