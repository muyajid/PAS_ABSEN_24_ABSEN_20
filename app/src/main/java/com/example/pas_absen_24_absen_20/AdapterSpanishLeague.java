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

public class AdapterSpanishLeague extends RecyclerView.Adapter<AdapterSpanishLeague.AdapterHolder> {
    private List<DataModelSpanishLeague.Teams> teamsList;

    public AdapterSpanishLeague(List<DataModelSpanishLeague.Teams> teamsList) {
        this.teamsList = teamsList;
    }

    @NonNull
    @Override
    public AdapterSpanishLeague.AdapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.spain_league_item, parent, false);
        return new AdapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterSpanishLeague.AdapterHolder holder, int position) {
        DataModelSpanishLeague.Teams teams = teamsList.get(position);
        holder.tvStrTeam.setText(teams.getStrTeam());
        Glide.with(holder.imgStrBadge.getContext())
                .load(teams.getStrBadge())
                .into(holder.imgStrBadge);
    }

    @Override
    public int getItemCount() {
        return teamsList.size();
    }

    public class AdapterHolder extends RecyclerView.ViewHolder {
        TextView tvStrTeam;
        ImageView imgStrBadge;
        public AdapterHolder(@NonNull View itemView) {
            super(itemView);
            tvStrTeam = itemView.findViewById(R.id.tvStrTeam);
            imgStrBadge = itemView.findViewById(R.id.imgStrBadge);
        }
    }
}
