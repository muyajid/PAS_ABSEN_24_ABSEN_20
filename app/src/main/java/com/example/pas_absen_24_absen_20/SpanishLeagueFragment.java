package com.example.pas_absen_24_absen_20;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class SpanishLeagueFragment extends Fragment {
    private static final String BASE_URL = "https://www.thesportsdb.com/api/v1/json/3/";

    RecyclerView rvSpanishLeague;
    AdapterSpanishLeague adapterSpanishLeague;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_ligaspanyol, container, false);

        rvSpanishLeague = view.findViewById(R.id.rvSpanishLeague);
        rvSpanishLeague.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<DataModelSpanishLeague> call = apiService.getSpanishLeague();

        call.enqueue(new Callback<DataModelSpanishLeague>() {
            @Override
            public void onResponse(Call<DataModelSpanishLeague> call, Response<DataModelSpanishLeague> response) {
                if (response.isSuccessful()) {
                    List<DataModelSpanishLeague.Teams> teamsList = response.body().getTeams();
                     adapterSpanishLeague= new AdapterSpanishLeague(teamsList);
                    rvSpanishLeague.setAdapter(adapterSpanishLeague);
                } else {
                    Log.e("Home", response.message());
                }
            }

            @Override
            public void onFailure(Call<DataModelSpanishLeague> call, Throwable t) {
                Log.e("Home", t.getMessage());
            }
        });

        return view;
    }

}
