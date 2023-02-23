package com.example.proyectot2ad_junzhou;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.proyectot2ad_junzhou.dao.PaisesAfectadosDao;
import com.example.proyectot2ad_junzhou.dao.TerremotosDao;
import com.example.proyectot2ad_junzhou.entity.PaisesAfectados;
import com.example.proyectot2ad_junzhou.rvutils.db.TerremotosDB;

import java.util.List;

public class FilterDialog extends DialogFragment {

    OnDatosListener listener;
    Spinner spnPais;
    Spinner spnMes;
    EditText txtAnio;
    TerremotosDB db;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {


//      Construimos el Dialog que retorna el método
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View v = getActivity().getLayoutInflater().inflate(R.layout.activity_filter_dialog, null);
        builder.setView(v);

        spnMes = v.findViewById(R.id.spnMes);
        spnPais = v.findViewById(R.id.spnPais);
        txtAnio = v.findViewById(R.id.etAnio);


        initSpinnerMes();

        initSpinnerPais();


        builder.setTitle("Filtros").setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                            String pais = spnPais.getSelectedItem().toString();
                            String mes = spnMes.getSelectedItem().toString();
                            String anio = txtAnio.getText().toString();

                            if (listener != null) {
                                listener.onDatosListener(pais, mes, anio);
                            }

                        Toast.makeText(getActivity(), "Datos aceptados",
                                Toast.LENGTH_SHORT).show();

                        dialog.dismiss();
                    }
                })
                .setNegativeButton("Cancelar", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // cerrar el dialogo
                                dialog.dismiss();
                            }
                        });

        return builder.create();
    }

    private void initSpinnerPais() {
        // agregar los datos al spinner de paises con Query, llamada a la base de datos y obtencion de pais unicos
        db = TerremotosDB.getDatabase(getActivity());
        PaisesAfectadosDao paisDao = db.paisesAfectadosDao();

        // Query
        List<String> paises = paisDao.selectPaises();

        // Agregar "Sin Filtro" al inicio de la lista
        paises.add(0, "Sin Filtro");

        ArrayAdapter<String> adapterPaises = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_item, paises);

        adapterPaises.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnPais.setAdapter(adapterPaises);

    }

    private void initSpinnerMes() {
        // agregar los datos al spinner meses
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.meses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMes.setAdapter(adapter);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            listener = (OnDatosListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() + " must implement OnDatosListener");
        }
    }


    @Override
    public void onDetach() {
        if (listener != null) {
            listener = null;
        }
        super.onDetach();
    }

}