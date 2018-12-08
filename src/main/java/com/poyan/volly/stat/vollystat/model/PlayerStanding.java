package com.poyan.volly.stat.vollystat.model;

public class PlayerStanding {
    private Player player;
    private int playedGames;
    private int win;
    private int lose;
    private int setWin;
    private int setLose;
    private int points;

    public PlayerStanding(Player player) {
        this.player = player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public void incPlayedGames(int playedGames) {
        this.playedGames += playedGames;
    }

    public void incWin(int win) {
        this.win += win;
    }

    public void incLose(int lose) {
        this.lose += lose;
    }

    public void incSetWin(int setWin) {
        this.setWin += setWin;
    }

    public void incSetLose(int setLose) {
        this.setLose += setLose;
    }

    public void incPoints(int points) {
        this.points += points;
    }


    public Player getPlayer() {
        return player;
    }

    public int getPlayedGames() {
        return playedGames;
    }

    public int getWin() {
        return win;
    }

    public int getLose() {
        return lose;
    }

    public int getSetWin() {
        return setWin;
    }

    public int getSetLose() {
        return setLose;
    }

    public int getPoints() {
        return points;
    }

}
