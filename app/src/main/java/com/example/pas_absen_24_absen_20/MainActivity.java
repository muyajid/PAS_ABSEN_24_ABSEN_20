package com.example.pas_absen_24_absen_20;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class            MainActivity extends AppCompatActivity {
    private BottomNavigationView bottom;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        bottom = findViewById(R.id.bottom);

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame, new ProfileFragment())
                .commit();

        bottom.setOnItemSelectedListener(item -> {
            Fragment fragment = null;
            int itemId = item.getItemId();

            if (itemId == R.id.nav_negara) {
                fragment = new CountriesFragment();
            } else if (itemId == R.id.nav_lalliga) {
                fragment = new SpanishLeagueFragment();
            } else if (itemId == R.id.nav_Profile) {
                fragment = new ProfileFragment();
            }

            if (fragment != null) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame, fragment)
                        .commit();
                return true;
            }
            return false;
        });
    }
}