package com.example.imcusuario.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "usuario")
public class Usuario {

    @PrimaryKey(autoGenerate = true)
    private long id;

    @ColumnInfo(name="nome")
    private String nome;

    @ColumnInfo(name = "login")

    private String login;


    @ColumnInfo(name = "senha")
    private String senha;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome( String nome) {
        this.nome = nome;
    }


    public String getLogin() {
        return login;
    }

    public void setLogin( String login) {
        this.login = login;
    }


    public String getSenha() {
        return senha;
    }

    public void setSenha( String senha) {
        this.senha = senha;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", login='" + login + '\'' +
                '}';
    }
}

