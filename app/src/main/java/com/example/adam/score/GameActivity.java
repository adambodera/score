package com.example.adam.score;

import android.app.DialogFragment;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;

import com.example.adam.score.model.PlayerModel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GameActivity extends AppCompatActivity
        implements EditPlayerName.EditPlayerNameNoticeListener{

    private GridView gameView;
    private Integer numOfPlayers;
    private Integer numOfStartingPoints;
    private ArrayList<PlayerModel> playerList;
    private PlayerBoxAdapter playerBoxAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String pref_num_of_players = preferences.getString(SettingsActivity.KEY_PREF_NUM_OF_PLAYERS, "");
        this.numOfPlayers = Integer.parseInt(pref_num_of_players);

	this.numOfStartingPoints = getIntent().getIntExtra(MainActivity.NUM_OF_STARTING_POINTS, 0);
        
	this.gameView = findViewById(R.id.game_view);
        List<String> items = Arrays.asList(getResources().getStringArray(R.array.num_of_players));
        items.subList(0, numOfPlayers-1);

        String playerDefaultName = getResources().getString(R.string.player);
        playerList = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            PlayerModel player = new PlayerModel(i+1, playerDefaultName + String.valueOf(i + 1), numOfStartingPoints);
            playerList.add(player);
        }
        playerBoxAdapter = new PlayerBoxAdapter(this, playerList);
        this.gameView.setAdapter(playerBoxAdapter);
    }

    @Override
    public void onDialogPositiveClick(EditPlayerName dialog, int playerId) {
        playerList.get(playerId).setPlayerName(dialog.getText());
        playerBoxAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDialogNegativeClick(EditPlayerName dialog) {
        dialog.getDialog().cancel();
    }
}
