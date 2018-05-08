package com.example.adam.score.model;

public class PlayerModel {
    private int playerId;
    private String playerName;
    private int playerScore;

    public PlayerModel(int playerId, String playerName, int playerScore) {
        this.playerId = playerId;
        this.playerName = playerName;
        this.playerScore = playerScore;
    }

    public int getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }
}
