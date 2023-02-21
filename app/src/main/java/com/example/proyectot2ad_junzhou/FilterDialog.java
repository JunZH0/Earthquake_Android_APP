package com.example.proyectot2ad_junzhou;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class FilterDialog extends DialogFragment {

    OnDatosListener listener;
    Spinner spnPais;
    Spinner spnMes;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        spnMes = (Spinner) getActivity().findViewById(R.id.spnMes);
        spnPais = (Spinner) getActivity().findViewById(R.id.spnPais);


        //iniSPNMes();
        iniSPNPais();


// Construimos el Dialog que retorna el método
        AlertDialog.Builder builder = new
                AlertDialog.Builder(getActivity());
        // Obtenemos un LayoutInflater para asignarle un layout
        LayoutInflater inflater = getActivity().getLayoutInflater();
        // le asignamos el layout que hemos definido
        builder.setView(inflater.inflate(R.layout.activity_filter_dialog, null));

// configuramos el diálogo
        builder.setTitle("Filtros")
                .setPositiveButton("Aceptar", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getActivity(), "Datos aceptados",
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                // PENDIENTE DE IMPLEMENTAR
                            }
                        })
                .setNegativeButton("Cancelar", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                // Cancelar > cerrar el cuadro de diálogo
                                dialog.dismiss();
                            }
                        });

        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnDatosListener) {
            listener = (OnDatosListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnDatosListener ");
        }
    }


    @Override
    public void onDetach() {
        if (listener != null) {
            listener = null;
        }
        super.onDetach();
    }

    private void iniSPNPais() {

    }

    private void iniSPNMes() {
        // crear array de meses y añadirlo al spinner
        String[] meses = new String[]{"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio",
                "Julio", "Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};

        spnMes.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_spinner_dropdown_item, meses));
    }
}