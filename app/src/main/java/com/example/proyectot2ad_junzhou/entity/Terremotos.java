package com.example.proyectot2ad_junzhou.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "TERREMOTOS", indices = {@Index(value = {"nom_disp"}, unique = true)})
public class Terremotos {
    @PrimaryKey
    @NonNull
    public String fecha_Hora;

    @ColumnInfo (name = "magnitud")
    public Double magnitud;

    @ColumnInfo (name = "nom_disp")
    public String nom_disp;

    @ColumnInfo (name = "lugar")
    public String lugar;
    @ColumnInfo (name = "coordenadas")
    public String coordenadas;

    @ColumnInfo (name = "muertes")
    public String muertes;

    public Terremotos(String fecha_Hora, Double magnitud, String nom_disp, String lugar, String coordenadas, String muertes) {
        this.fecha_Hora = fecha_Hora;
        this.magnitud = magnitud;
        this.nom_disp = nom_disp;
        this.lugar = lugar;
        this.coordenadas = coordenadas;
        this.muertes = muertes;
    }

    public String getFecha_Hora() {
        return fecha_Hora;
    }

    public Double getMagnitud() {
        return magnitud;
    }

    public String getNom_disp() {
        return nom_disp;
    }

    public String getCoordenadas() {
        return coordenadas;
    }

    public String getLugar() {
        return lugar;
    }

    public String getMuertes() {
        return muertes;
    }

}
