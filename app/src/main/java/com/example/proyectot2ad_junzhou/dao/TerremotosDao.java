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

    // TODO Implementar query con filtros

    @Query("SELECT * FROM TERREMOTOS WHERE fecha_Hora = :fecha_Hora")
    public Terremotos selectByFechaHora(String fecha_Hora);

    @Insert
    public long insert(Terremotos terremotos);
}
