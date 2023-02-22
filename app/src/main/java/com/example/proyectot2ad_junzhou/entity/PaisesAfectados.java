package com.example.proyectot2ad_junzhou.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "PAISES_AFECTADOS",
        primaryKeys = {"fecha_Hora", "pais"},
        foreignKeys = {@ForeignKey(entity = Terremotos.class,
                parentColumns = "fecha_Hora",
                childColumns = "fecha_Hora",
                onDelete = ForeignKey.CASCADE)})
public class PaisesAfectados {

    @NonNull
    public String fecha_Hora;

    @NonNull
    @ColumnInfo(name = "pais")
    public String pais;

    public PaisesAfectados(String fecha_Hora, String pais) {
        this.fecha_Hora = fecha_Hora;
        this.pais = pais;
    }

    public String getFecha_Hora() {
        return fecha_Hora;
    }

    public String getPais() {
        return pais;
    }

}

