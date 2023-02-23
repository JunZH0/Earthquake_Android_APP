package com.example.proyectot2ad_junzhou.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proyectot2ad_junzhou.entity.Terremotos;

import java.util.List;

@Dao
public interface TerremotosDao {

    @Query("SELECT * FROM TERREMOTOS")
    public List<Terremotos> getAll();


    // Seleccionar por mes y año
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_Hora LIKE '%' ||:mes||  '%' AND fecha_Hora LIKE '%' ||:anio||  '%' ")
    public List<Terremotos> selectMesAnio(String mes, String anio);

    // Seleccionar por Año
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_Hora LIKE '%' ||:anio||  '%' ")
    public List<Terremotos> selectAnio(String anio);

    // Seleccionar por pais y año
    @Query("SELECT * FROM PAISES_AFECTADOS WHERE pais = :pais AND fecha_Hora LIKE '%' ||:anio||  '%' ")
    public List<Terremotos> selectPaisAnio(String pais, String anio);

    // Seleccionar por pais mes y año
    @Query("SELECT * FROM PAISES_AFECTADOS WHERE pais = :pais AND fecha_Hora LIKE '%' ||:mes||  '%' AND fecha_Hora LIKE '%' ||:anio||  '%' ")
    public List<Terremotos> selectPaisMesAnio(String pais, String mes, String anio);

    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes||  '%' ")
    public List<Terremotos> selectMes(String mes);

    @Insert
    public long insert(Terremotos terremotos);
}
