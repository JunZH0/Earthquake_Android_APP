package com.example.proyectot2ad_junzhou.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Index;
import androidx.room.PrimaryKey;

@Entity(tableName = "TERREMOTOS", indices = {@Index(value = {"nom_disp"}, unique = true)})
public class Terremotos {
    @PrimaryKey()
    public String fecha_Hora;

    @ColumnInfo (name = "magnitud")
    public Double magnitud;

    @ColumnInfo (name = "nom_disp")
    public String nom_disp;

    @ColumnInfo (name = "coordenadas")
    public String coordenadas;

    @ColumnInfo (name = "lugar")
    public String lugar;

    @ColumnInfo (name = "muertes")
    public String muertes;

    public Terremotos(String fecha_Hora, Double magnitud, String nom_disp, String coordenadas, String lugar, String muertes) {
        this.fecha_Hora = fecha_Hora;
        this.magnitud = magnitud;
        this.nom_disp = nom_disp;
        this.coordenadas = coordenadas;
        this.lugar = lugar;
        this.muertes = muertes;
    }
}
