package com.poyan.volly.stat.vollystat.model;

public class GameResult {
    Game game;
    Team team1;
    Team team2;
    int team1SetWin;
    int team2SetWin;

    public Game getGame() {
        return game;
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Team getTeam1() {
        return team1;
    }

    public void setTeam1(Team team1) {
        this.team1 = team1;
    }

    public Team getTeam2() {
        return team2;
    }

    public void setTeam2(Team team2) {
        this.team2 = team2;
    }

    public int getTeam1SetWin() {
        return team1SetWin;
    }

    public void setTeam1SetWin(int team1SetWin) {
        this.team1SetWin = team1SetWin;
    }

    public int getTeam2SetWin() {
        return team2SetWin;
    }

    public void setTeam2SetWin(int team2SetWin) {
        this.team2SetWin = team2SetWin;
    }
}
