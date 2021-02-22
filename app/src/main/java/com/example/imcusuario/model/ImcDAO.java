package com.example.imcusuario.model;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface ImcDAO {
    @Query("SELECT * FROM imc")
    public List<Imc> findByAll();

    @Query("SELECT * FROM imc where usuarioId IN (:id)")
    public List<Imc> findByUsuario(long id);

    @Insert
    public void insertImcs(Imc ... imcs);

    @Update
    public void updateImcs(Imc ... imcs);

    @Delete
    public void deleteImcs(Imc ... imcs);
}

