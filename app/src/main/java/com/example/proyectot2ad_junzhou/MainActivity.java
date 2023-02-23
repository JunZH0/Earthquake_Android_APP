package com.example.proyectot2ad_junzhou;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Filter;
import android.widget.TextView;

import com.example.proyectot2ad_junzhou.dao.TerremotosDao;
import com.example.proyectot2ad_junzhou.entity.PaisesAfectados;
import com.example.proyectot2ad_junzhou.entity.Terremotos;
import com.example.proyectot2ad_junzhou.rvutils.db.TerremotosAdapter;
import com.example.proyectot2ad_junzhou.rvutils.db.TerremotosDB;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnDatosListener {

    private Button btnFiltro;
    private Button btnConsulta;
    private TextView tvFiltro;
    private RecyclerView rvTerremotos;
    private TerremotosDB tDB;
    private TerremotosAdapter tAdapter;
    private List<Terremotos> listaTerremotos;
    private String pais;
    private String mes;
    private String anio;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnFiltro = findViewById(R.id.btnFilter);
        btnConsulta = findViewById(R.id.btnQuery);
        rvTerremotos = findViewById(R.id.rvTerremoto);
        tvFiltro = findViewById(R.id.tvFiltros);

        btnFiltro.setOnClickListener((View.OnClickListener) this);
        btnConsulta.setOnClickListener((View.OnClickListener) this);

        initDatos();



    }

    private void cargarRecycleView() {
        // Arraylist para guardar los objetos que se van a mostrar en el RecyclerView
        listaTerremotos = new ArrayList<>();
        // Creacion del adaptador
        tAdapter = new TerremotosAdapter(listaTerremotos);
        // Creacion del LayoutManager y asignacion al RecyclerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);
        rvTerremotos.setLayoutManager(layoutManager);
        rvTerremotos.setItemAnimator(new DefaultItemAnimator());
        rvTerremotos.setAdapter(tAdapter);


        tDB = TerremotosDB.getDatabase(this);
        // Instancia del DAO
        TerremotosDao tDao = tDB.terremotosDao();


        // TODO crear todos las posibilidades de filtros
        // Obtener todos los terremotos a traves de la Query getAll()
        List<Terremotos> terremotosList = tDao.getAll();
        TerremotosAdapter adapter = new TerremotosAdapter(terremotosList);
        rvTerremotos.setAdapter(adapter);



    }

    private void initDatos() {

        ArrayList<Terremotos> listaTerremotos = new ArrayList<>(Arrays.asList(new Terremotos("22 de mayo de 1960, 15:11", 9.5, "Terremoto de Valdivia de 1960",
                        "Valdivia, Región de los Ríos", "38°14′24′′S 73°3′0′′O", "1655 a 2000")
                , new Terremotos("26 de diciembre de 2004, 07:58", 9.3, "Terremoto del océano Índico de 2004",
                        "Frente al norte de la isla de Sumatra", "Sin datos", "230270")
                , new Terremotos("27 de marzo de 1964, 17:36", 9.2, "Terremoto de Alaska de 1964",
                        "Anchorage, Alaska", "61°N 148°O", "128"),
                new Terremotos("11 de marzo de 2011, 14:46", 9.1, "Terremoto y maremoto de Japón de 2011",
                        "Costa Este de la Región de Tōhoku, Honshū", "38°19′19.20′′N 142°22′8.40′′E",
                        "15897"),
                new Terremotos("4 de noviembre de 1952, 16:58", 9.0, "Terremoto de Kamchatka de 1952",
                        "Península de Kamchatka", "52°48′N 159°30′E", "2366"),
                new Terremotos("13 de agosto de 1868, 21:30", 9.0, "Terremoto de Arica de 1868", "Arica",
                        "18°36′S 71°0′O", "693"),
                new Terremotos("28 de octubre de 1746, 22:30", 9.0, "Terremoto de Lima de 1746",
                        "Lima y Callao", "11°21′00′′S 77°16′48′′O", "15000 a 20000"),
                new Terremotos("26 de enero de 1700, 21:30", 9.0, "Terremoto de Cascadia de 1700",
                        "California, Oregón, Washington y Columbia Británica", "Sin datos", "Sin datos"),
                new Terremotos("27 de febrero de 2010, 03:34", 8.8, "Terremoto de Chile de 2010",
                        "Cobquecura, Región del Biobío (actual Ñuble)", "35°50′45.6′′S 72°42′57.6′′O",
                        "525"),
                new Terremotos("31 de enero de 1906, 15:36", 8.8, "Terremoto de Ecuador y Colombia de 1906",
                        "Frente a las costas de Esmeraldas", "1°0′N 81°30′O", "1500"),
                new Terremotos("25 de noviembre de 1833, 20:00", 8.8, "Terremoto de Sumatra de 1833", "En el mar al sur de la isla de Sumatra," +
                        " a 175 km al sur de Padang",
                        "3°30′S 102°12′E", "Sin datos"),
                new Terremotos("1 de noviembre de 1755, 10:16", 8.7, "Terremoto de Lisboa de 1755", "Lisboa",
                        "36°N 11°O", "60000 a 100000"),
                new Terremotos("8 de julio de 1730, 04:45", 8.7, "Terremoto de Valparaíso de 1730",
                        "Valparaíso y La Serena", "33°30′S 71°36′O", "300"),
                new Terremotos("11 de abril de 2012, 15:38", 8.6, "Terremoto del océano Índico de 2012",
                        "Frente al norte de la isla de Sumatra", "02°18′39.6′′N 93°03′46.8′′E", "10"),
                new Terremotos("28 de marzo de 2005, 23:09", 8.6, "Terremoto de Sumatra de 2005", "Frente al norte de la isla de Sumatra",
                        "2°36′N 97°6′E", "1300"),
                new Terremotos("9 de marzo de 1957, 14:22", 8.6, "Terremoto de las islas Andreanof de 1957",
                        "Islas Andreanof, Alaska", "51°33′36′′N 175°23′24′′O", "0"),
                new Terremotos("15 de agosto de 1950", 8.6, "Terremoto de Assam de 1950", "Assam (India), Tíbet (China)",
                        "28°30′N 96°30′O", "1526"),
                new Terremotos("10 de noviembre de 1922, 23:53", 8.6, "Terremoto de Vallenar de 1922 Chile",
                        "Región de Atacama y Provincia de Catamarca", "Sin datos", "1500"),
                new Terremotos("28 de marzo de 1787, 11:30", 8.6, "Terremoto de Nueva España de 1787",
                        "Costas de Oaxaca y Guerrero", "Sin datos", "11"),
                new Terremotos("3 de febrero de 1923, 04:58", 8.5, "Terremoto de Kamchatka de 1923",
                        "Península de Kamchatka", "54°N 161°E", "Sin datos"),
                new Terremotos("20 de octubre de 1687, 09:15", 8.5, "Terremotos de Lima y Callao de 1687",
                        "Lima y Callao", "Sin datos", "5000"),
                new Terremotos("16 de diciembre de 1575, 14:30", 8.5, "Terremoto de Valdivia de 1575",
                        "Valdivia", "39°48′S 73°12′O", "1221"),
                new Terremotos("16 de septiembre de 2015, 19:54", 8.4, "Terremoto de Coquimbo de 2015",
                        "Frente a las costas de la Comuna de Canela, Región de Coquimbo",
                        "31°34′52′′S 71°45′07′′O", "12"),
                new Terremotos("23 de junio de 2001, 15:33", 8.4, "Terremoto del sur del Perú de 2001",
                        "Departamentos de Arequipa, Moquegua y Tacna", "16°15′36′′S 73°38′24′′O", "102"),
                new Terremotos("6 de febrero de 2023, 01:17", 7.8, "Terremoto de Turquía y Siria 2023",
                        "Turquía, Siria", "37°10′26′′N 37°01′55′′E", "40120")));

        ArrayList<PaisesAfectados> listaPaises = new ArrayList<>(Arrays.asList(
                new PaisesAfectados("22 de mayo de 1960, 15:11", "Chile"),
                new PaisesAfectados("26 de diciembre de 2004, 07:58", "Indonesia"),
                new PaisesAfectados("27 de marzo de 1964, 17:36", "Estados Unidos"),
                new PaisesAfectados("11 de marzo de 2011, 14:46", "Japón"),
                new PaisesAfectados("4 de noviembre de 1952, 16:58", "Rusia"),
                new PaisesAfectados("13 de agosto de 1868, 21:30", "Chile"),
                new PaisesAfectados("28 de octubre de 1746, 22:30", "Perú"),
                new PaisesAfectados("26 de enero de 1700, 21:30", "Estados Unidos"),
                new PaisesAfectados("27 de febrero de 2010, 03:34", "Chile"),
                new PaisesAfectados("6 de febrero de 2023, 01:17", "Turquía"),
                new PaisesAfectados("6 de febrero de 2023, 01:17", "Siria"),
                new PaisesAfectados("31 de enero de 1906, 15:36", "Ecuador"),
                new PaisesAfectados("31 de enero de 1906, 15:36", "Colombia"),
                new PaisesAfectados("25 de noviembre de 1833, 20:00", "Indonesia"),
                new PaisesAfectados("1 de noviembre de 1755, 10:16", "Portugal"),
                new PaisesAfectados("8 de julio de 1730, 04:45", "Chile"),
                new PaisesAfectados("11 de abril de 2012, 15:38", "Indonesia"),
                new PaisesAfectados("28 de marzo de 2005, 23:09", "Indonesia"),
                new PaisesAfectados("9 de marzo de 1957, 14:22", "Estados Unidos"),
                new PaisesAfectados("15 de agosto de 1950", "India"),
                new PaisesAfectados("15 de agosto de 1950", "China"),
                new PaisesAfectados("10 de noviembre de 1922, 23:53", "Argentina"),
                new PaisesAfectados("28 de marzo de 1787, 11:30", "México"),
                new PaisesAfectados("3 de febrero de 1923, 04:58", "Rusia"),
                new PaisesAfectados("20 de octubre de 1687, 09:15", "Perú"),
                new PaisesAfectados("16 de diciembre de 1575, 14:30", "Chile"),
                new PaisesAfectados("16 de septiembre de 2015, 19:54", "Chile"),
                new PaisesAfectados("23 de junio de 2001, 15:33", "Perú")));


        // comprobar si la base de datos existe
        File dbFile = getDatabasePath("terremotos.db");
        if (dbFile.exists()) {
            return;
        }

        tDB = TerremotosDB.getDatabase(this);
        for (Terremotos terremoto : listaTerremotos) {
            tDB.terremotosDao().insert(terremoto);
        }

        for (PaisesAfectados paisesAfectados : listaPaises) {
            tDB.paisesAfectadosDao().insert(paisesAfectados);
        }

    }


    public void onClick(View view) {
        if (view.getId() == R.id.btnFilter) {
            // Crea un nuevo dialogo y lo muestra
            FilterDialog filterDialog = new FilterDialog();
            filterDialog.show(getSupportFragmentManager(), "FilterDialog");
        } else if (view.getId() == R.id.btnQuery) {
            cargarRecycleView();
        }
    }

    @Override
    public void onDatosListener(String pais, String mes, String anio) {

        this.pais = pais;
        this.mes = mes;
        this.anio = anio;
        tvFiltro.setText(" Pais: " + pais + " | Mes: " + mes + " | Año: " + anio);


    }
}