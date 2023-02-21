package com.example.proyectot2ad_junzhou.rvutils.db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.proyectot2ad_junzhou.dao.PaisesAfectadosDao;
import com.example.proyectot2ad_junzhou.dao.TerremotosDao;
import com.example.proyectot2ad_junzhou.entity.PaisesAfectados;
import com.example.proyectot2ad_junzhou.entity.Terremotos;

@Database(entities = {Terremotos.class, PaisesAfectados.class}, version = 1)
public abstract class TerremotosDB extends RoomDatabase {
// Clase para la creacion de la base de datos y la conexion con los DAOs
        public abstract TerremotosDao terremotosDao();
        public abstract PaisesAfectadosDao paisesAfectadosDao();

        private static TerremotosDB terremotosDB;

public static TerremotosDB getDatabase(Context context) {
            if (terremotosDB == null) {
                terremotosDB = Room.databaseBuilder(
                                context.getApplicationContext(),
                                TerremotosDB.class, "TERREMOTOS_DB")
                        .allowMainThreadQueries()
                        .build();
            }
            return terremotosDB;
        }
}
