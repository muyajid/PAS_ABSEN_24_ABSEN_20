package com.example.pas_absen_24_absen_20;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesFragment extends Fragment {
    private AdapterCountries adapterCountries;
    private RecyclerView rvCountries;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.countries_fragment, container, false);

        rvCountries = view.findViewById(R.id.rvCountries);
        rvCountries.setLayoutManager(new LinearLayoutManager(getContext()));

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://www.thesportsdb.com/api/v1/json/3/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        ApiService apiService = retrofit.create(ApiService.class);

        Call<DataModelCountries> call = apiService.getCountries();

        call.enqueue(new Callback<DataModelCountries>() {
            @Override
            public void onResponse(Call<DataModelCountries> call, Response<DataModelCountries> response) {
                if (response.isSuccessful()) {
                    List<DataModelCountries.countriesItem> countriesItems = response.body().getCountriesItems();
                    adapterCountries = new AdapterCountries(countriesItems);
                    rvCountries.setAdapter(adapterCountries);
                } else {
                    Log.e("Inggris Fragment", response.message());
                }
            }

            @Override
            public void onFailure(Call<DataModelCountries> call, Throwable t) {
                Log.e("Inggris Fragment", t.getMessage());
            }
        });
        return view;
    }
}
