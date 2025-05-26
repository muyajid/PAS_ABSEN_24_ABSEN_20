package com.example.pas_absen_24_absen_20;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import retrofit2.Call;

public class DataModelCountries {
    @SerializedName("countries")
    private List<countriesItem> countriesItems;

    public List<countriesItem> getCountriesItems() {
        return countriesItems;
    }

    public static class countriesItem {
        @SerializedName("name_en")
        private String name_en;

        @SerializedName("flag_url_32")
        private String flag_url_32;

        public String getName_en() {
            return name_en;
        }

        public String getFlag_url_32() {
            return flag_url_32;
        }
    }
}
