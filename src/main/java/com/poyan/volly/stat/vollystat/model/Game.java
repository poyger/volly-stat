package com.poyan.volly.stat.vollystat.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Game {
    private static int counter = 0;
    private int id;

    {
        id = counter;
        counter++;
    }

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    private Date date;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
