package com.example.proyectot2ad_junzhou.rvutils.db;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.proyectot2ad_junzhou.entity.Terremotos;

import java.util.List;

public class TerremotoAdapter extends RecyclerView.Adapter<TerremotoAdapter.ViewHolder> {

    private List<Terremotos> terremotos;

    public TerremotoAdapter(List<Terremotos> terremotos) {
        this.terremotos = terremotos;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }
}