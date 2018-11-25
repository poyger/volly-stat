package com.poyan.volly.stat.vollystat.model;

public class Player {
    private static int counter = 0;
    private int id;
    private PlayerName name;

    {
        id = counter;
        counter++;
    }

    public PlayerName getName() {
        return name;
    }

    public void setName(PlayerName name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
