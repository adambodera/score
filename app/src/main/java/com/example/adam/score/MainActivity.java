package com.example.adam.score;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity {

    public static final String NUM_OF_PLAYERS = "com.example.adam.score.NUM_OF_PLAYERS";
    public static final String NUM_OF_STARTING_POINTS = "com.example.adam.score.NUM_OF_STARTING_POINTS";
    private Spinner numOfPlayers;
    private EditText numOfStartingPoints;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void goToGameActivity(View view){
        Intent intent = new Intent(this, GameActivity.class);
        numOfPlayers = findViewById(R.id.num_of_players);
        int position = numOfPlayers.getSelectedItemPosition();
        numOfStartingPoints = findViewById(R.id.num_of_starting_points);
        int startingPoints = Integer.valueOf(numOfStartingPoints.getText().toString());
        intent.putExtra(NUM_OF_PLAYERS, (position+1));
        intent.putExtra(NUM_OF_STARTING_POINTS, startingPoints);
        startActivity(intent);
    }
}
