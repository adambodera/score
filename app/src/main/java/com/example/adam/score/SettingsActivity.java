package com.example.adam.score;

import android.app.Activity;
import android.os.Bundle;

public class SettingsActivity extends Activity {

    public static final String KEY_PREF_NUM_OF_PLAYERS = "pref_number_of_players";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getFragmentManager().beginTransaction().replace(android.R.id.content, new SettingsFragment()).commit();
    }
}
