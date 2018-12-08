package com.poyan.volly.stat.vollystat.model;

public class GameResult {
    private Game game;
    private Team team1;
    private Team team2;
    private int team1SetWin;
    private int team2SetWin;
    private int id;
    private static int counter = 0;

    {
        setId(counter++);
    }


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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
