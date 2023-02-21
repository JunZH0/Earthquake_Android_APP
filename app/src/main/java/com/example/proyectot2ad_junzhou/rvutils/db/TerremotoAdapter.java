package com.example.proyectot2ad_junzhou.rvutils.db;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TerremotoAdapter extends RecyclerView.Adapter<TerremotoAdapter.TerremotoVH>  {


    @NonNull
    @Override
    public TerremotoVH onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TerremotoVH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class TerremotoVH extends RecyclerView.ViewHolder {

        public TerremotoVH(@NonNull View itemView) {
            super(itemView);
        }
    }
}
