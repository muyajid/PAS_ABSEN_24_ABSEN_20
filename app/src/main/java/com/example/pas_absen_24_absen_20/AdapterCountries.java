package com.example.pas_absen_24_absen_20;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class AdapterCountries extends RecyclerView.Adapter<AdapterCountries.AdapterHolder> {
    private List<DataModelCountries.countriesItem> countriesItems;

    public AdapterCountries(List<DataModelCountries.countriesItem> countriesItems) {
        this.countriesItems = countriesItems;
    }

    @NonNull
    @Override
    public AdapterCountries.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.countries_item, parent, false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterCountries.AdapterHolder holder, int position) {
        DataModelCountries.countriesItem countriesItem = countriesItems.get(position);
        Glide.with(holder.imgFlag.getContext())
                .load(countriesItem.getFlag_url_32())
                .into(holder.imgFlag);
        holder.tvName.setText(countriesItem.getName_en());
    }

    @Override
    public int getItemCount() {
        return countriesItems.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        ImageView imgFlag;
        TextView tvName;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            imgFlag = itemView.findViewById(R.id.imgFlag);
            tvName = itemView.findViewById(R.id.tvName);
        }
    }
}
