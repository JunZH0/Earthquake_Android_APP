package com.example.proyectot2ad_junzhou.dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.proyectot2ad_junzhou.entity.PaisesAfectados;

import java.util.List;

@Dao
public interface PaisesAfectadosDao {

    @Query("SELECT * FROM PAISES_AFECTADOS")
    public List<PaisesAfectados> getAll();

    // TODO Implementar query con filtros

    @Query("SELECT * FROM PAISES_AFECTADOS WHERE pais = :pais")
    public PaisesAfectados selectByPais(String pais);

    @Query("SELECT * FROM PAISES_AFECTADOS WHERE fecha_Hora = :fecha_Hora")
    public PaisesAfectados selectByFechaHora(String fecha_Hora);

    @Insert
    public long insert(PaisesAfectados paisesAfectados);


}
