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

    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes||  '%'")
    List<Terremotos> selectTerremotosMes(String mes);
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND fecha_hora LIKE '%' ||:anio|| '%'")
    List<Terremotos> selectTerremotosMesAnio(String mes, String anio);
    @Query("SELECT * FROM TERREMOTOS t, PAISES_AFECTADOS p WHERE t.fecha_hora = p.fecha_hora AND t.fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND pais LIKE '%' ||:pais|| '%'")
    List<Terremotos> selectTerremotosMesPais(String mes, String pais);
    @Query("SELECT * FROM TERREMOTOS t, PAISES_AFECTADOS p WHERE t.fecha_hora = p.fecha_hora AND t.fecha_hora LIKE '%' ||:mes|| '%' " +
            "AND t.fecha_hora LIKE '%' ||:anio|| '%' AND pais LIKE '%' ||:pais|| '%'")
    List<Terremotos> selectTerremotosMesAnioPais(String mes, String anio, String pais);
    @Query("SELECT * FROM TERREMOTOS WHERE fecha_hora LIKE '%' ||:anio|| '%'")
    List<Terremotos> selectTerremotosAnio(String anio);
    @Query("SELECT * FROM TERREMOTOS t, PAISES_AFECTADOS p WHERE t.fecha_hora = p.fecha_hora AND t.fecha_hora LIKE '%' ||:anio|| '%' " +
            "AND pais LIKE '%' ||:pais|| '%'")
    List<Terremotos> selectTerremotosAnioPais(String anio, String pais);
    @Query("SELECT * FROM TERREMOTOS t, PAISES_AFECTADOS p WHERE pais LIKE '%' ||:pais|| '%' AND t.fecha_hora = p.fecha_hora")
    List<Terremotos> selectTerremotosPais(String pais);


    @Insert
    public long insert(Terremotos terremotos);
}
