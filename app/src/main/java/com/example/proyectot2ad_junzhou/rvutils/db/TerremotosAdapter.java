package com.example.proyectot2ad_junzhou.rvutils.db;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectot2ad_junzhou.R;
import com.example.proyectot2ad_junzhou.entity.Terremotos;

import java.util.List;

public class TerremotosAdapter extends RecyclerView.Adapter<TerremotosAdapter.TerremotoViewHolder> {

    private List<Terremotos> terremotosList;

    public TerremotosAdapter(List<Terremotos> terremotosList) {
        this.terremotosList = terremotosList;
    }

    @NonNull
    @Override
    public TerremotoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.terremoto_item, parent, false);
        return new TerremotoViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull TerremotoViewHolder holder, int position) {
        // Asignar los valores a los elementos del layout
        Terremotos terremoto = terremotosList.get(position);
        holder.fecha_Hora.setText(terremoto.getFecha_Hora());
        holder.magnitud.setText(String.valueOf(terremoto.getMagnitud()));
        holder.nom_disp.setText(terremoto.getNom_disp());
        holder.coordenadas.setText(terremoto.getCoordenadas());
        holder.lugar.setText(terremoto.getLugar());
        holder.muertes.setText(terremoto.getMuertes());
    }

    @Override
    public int getItemCount() {
        return terremotosList.size();
    }

    public class TerremotoViewHolder extends RecyclerView.ViewHolder {
        public TextView fecha_Hora, magnitud, nom_disp, coordenadas, lugar, muertes;

        // Asignar los elementos del layout al objeto
        public TerremotoViewHolder(@NonNull View itemView) {
            super(itemView);
            fecha_Hora = itemView.findViewById(R.id.tvItemFecha);
            magnitud = itemView.findViewById(R.id.tvItemMagnitud);
            nom_disp = itemView.findViewById(R.id.tvItemNomDisp);
            coordenadas = itemView.findViewById(R.id.tvItemCoord);
            lugar = itemView.findViewById(R.id.tvItemLugar);
            muertes = itemView.findViewById(R.id.tvItemMuertes);
        }
    }
}