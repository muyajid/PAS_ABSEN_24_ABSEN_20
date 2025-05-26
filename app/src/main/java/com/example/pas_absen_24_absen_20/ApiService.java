package com.example.pas_absen_24_absen_20;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("all_countries.php")
    Call<DataModelCountries> getCountries();

    @GET("search_all_teams.php?s=Soccer&c=Spain")
    Call<DataModelSpanishLeague> getSpanishLeague();
}
