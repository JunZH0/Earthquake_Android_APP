package com.example.proyectot2ad_junzhou.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proyectot2ad_junzhou.entity.PaisesAfectados;
import com.example.proyectot2ad_junzhou.entity.Terremotos;

import java.util.List;

@Dao
public interface PaisesAfectadosDao {

    @Query("SELECT * FROM PAISES_AFECTADOS")
    public List<PaisesAfectados> getAll();

    @Query("SELECT DISTINCT pais FROM PAISES_AFECTADOS")
    public List<String> selectPaises();

    @Insert
    public long insert(PaisesAfectados paisesAfectados);


}
