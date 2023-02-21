package com.example.proyectot2ad_junzhou.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "PAISES_AFECTADOS",
        foreignKeys = {@ForeignKey(entity = Terremotos.class,
        parentColumns = "fecha_Hora",
        childColumns = "fecha_Hora",
        onDelete = ForeignKey.CASCADE)},
        indices = {@Index(value = {"pais"},unique = true)})

public class PaisesAfectados {

    @PrimaryKey
    @NonNull
    public String fecha_Hora;

    @ColumnInfo(name = "pais")
    public String pais;

    public PaisesAfectados(String fecha_Hora, String pais) {
        this.fecha_Hora = fecha_Hora;
        this.pais = pais;
    }
}


