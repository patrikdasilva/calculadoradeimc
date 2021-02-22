package com.example.imcusuario.model;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;



@Entity(tableName = "imc",
    foreignKeys =   @ForeignKey(entity = Usuario.class,
                    parentColumns = "id",
                    childColumns = "usuarioId",
                    onDelete = ForeignKey.CASCADE))

public class  Imc {
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="id")
    private long  id;

    @ColumnInfo(name="usuarioId")
    private long usuarioId;

    @ColumnInfo(name = "imc")
    private double imc;

    @ColumnInfo(name = "altura")
    private double altura;

    @ColumnInfo(name = "peso")
    private double peso;

    @ColumnInfo(name = "resultado")
    private String resultado;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public double getImc() {
        return imc;
    }

    public void setImc(double imc) {
        this.imc = imc;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura( double altura) {
        this.altura = altura;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso( double peso) {
        this.peso = peso;
    }
    public void calcularImc(){

        this.imc = this.peso / (Math.pow(this.altura, 2));
        if(imc < 18.5){
            this.resultado = "A baixo do peso.";
        } else if(imc >= 18.5 && imc < 25.0){
            this.resultado = "Peso saudável.";
        } else if(imc >= 25.0 && imc < 30.0){
            this.resultado = "Obesidade tipo I.";
        } else if(imc >= 30 && imc < 40.0){
            this.resultado = "Obesidade tipo II.";
        } else {
            this.resultado = "Obesidade tipo III.";
        }
    }


    public String getResultado() {
        return resultado;
    }

    public void setResultado(String resultado) {
        this.resultado = resultado;
    }

    @Override
    public String toString() {
        return "Altura = "+String.format("%.2f",altura)+"\nPeso = "+String.format("%.2f",peso)+ "\nImc = "+ String.format("%.2f",imc)+ ":"+ resultado;
    }
}