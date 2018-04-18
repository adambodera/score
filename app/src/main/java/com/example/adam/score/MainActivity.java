package com.example.adam.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String NUM_OF_PLAYERS = "com.example.adam.score.NUM_OF_PLAYERS";
    private Spinner numOfPlayers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goToGameActivity(View view){
        Intent intent = new Intent(this, GameActivity.class);
        numOfPlayers = findViewById(R.id.num_of_players);
        int position = numOfPlayers.getSelectedItemPosition();
        intent.putExtra(NUM_OF_PLAYERS, (position+1));
        startActivity(intent);
    }
}
