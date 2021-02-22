package com.example.imcusuario.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface UsuarioDAO {
    @Query("SELECT * FROM usuario")
    public List<Usuario> findByAll();

    @Query("SELECT * FROM usuario where id IN (:ids)")
    public List<Usuario> findByIds(long[] ids);

    @Query("SELECT * FROM usuario where id = :id")
    public Usuario findById(long id);

    @Query("SELECT * FROM usuario where nome LIKE :nome LIMIT 1")
    public Usuario findByNome (String nome);

    @Query("SELECT * FROM usuario where login LIKE :login AND senha LIKE :senha LIMIT 1")
    public Usuario findByLoginAndSenha (String login, String senha);

    @Query("SELECT * FROM usuario where login LIKE :login  LIMIT 1")
    public Usuario findByLogin (String login);

    @Insert
    public void insertUsuarios(Usuario ... usuarios);

    @Update
    public void updateUsuarios(Usuario ... usuarios);

    @Delete
    public void deleteUsuarios(Usuario ... usuarios);
}


