package com.example.pas_absen_24_absen_20;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class DataModelSpanishLeague {

    @SerializedName("teams")
    private List<Teams> teams;

    public List<Teams> getTeams() {
        return teams;
    }

    public static class Teams {
        @SerializedName("strTeam")
        private String strTeam;

        @SerializedName("strBadge")
        private String strBadge;

        public String getStrTeam() {
            return strTeam;
        }

        public String getStrBadge() {
            return strBadge;
        }
    }
}
