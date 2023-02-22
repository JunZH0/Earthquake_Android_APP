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
import android.widget.Spinner;
import android.widget.Toast;

public class FilterDialog extends DialogFragment {

    OnDatosListener listener;
    Spinner spnPais;
    Spinner spnMes;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {



//      Construimos el Dialog que retorna el método
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        View v = getActivity().getLayoutInflater().inflate(R.layout.activity_filter_dialog, null);
        builder.setView(v);
        spnMes = v.findViewById(R.id.spnMes);
        spnPais = v.findViewById(R.id.spnPais);

        // agregar los datos al spinner
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.meses, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMes.setAdapter(adapter);


// configuramos el diálogo
        builder.setTitle("Filtros")
                .setPositiveButton("Aceptar", new
                        DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                Toast.makeText(getActivity(), "Datos aceptados",
                                        Toast.LENGTH_SHORT).show();
                                dialog.dismiss();
                                // TODO PENDIENTE DE IMPLEMENTAR
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

}