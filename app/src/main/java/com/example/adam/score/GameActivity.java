package com.example.adam.score;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);

        this.numOfPlayers = getIntent().getIntExtra(MainActivity.NUM_OF_PLAYERS, 2);

        this.gameView = findViewById(R.id.game_view);
        List<String> items = Arrays.asList(getResources().getStringArray(R.array.num_of_players));
        items.subList(0, numOfPlayers-1);

        String playerDefaultName = getResources().getString(R.string.player);
        ArrayList<PlayerModel> playerList = new ArrayList<>();
        for (int i = 0; i < numOfPlayers; i++) {
            PlayerModel player = new PlayerModel(i+1, playerDefaultName + String.valueOf(i + 1));
            playerList.add(player);
        }
        PlayerBoxAdapter playerBoxAdapter = new PlayerBoxAdapter(this, playerList);
        this.gameView.setAdapter(playerBoxAdapter);
    }

    @Override
    public void onDialogPositiveClick(DialogFragment dialog, int playerId) {
        Object o = gameView.getAdapter().getItem(1);
        int i =1;
    }

    @Override
    public void onDialogNegativeClick(DialogFragment dialog) {
        dialog.getDialog().cancel();
    }
}
