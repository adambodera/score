package com.example.adam.score.model;

public class PlayerModel {
    private int playerId;
    private String playerName;
    private int playerScore;

    public PlayerModel(int playerId, String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerScore = 0;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
