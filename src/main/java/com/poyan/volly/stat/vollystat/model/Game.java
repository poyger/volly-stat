package com.poyan.volly.stat.vollystat.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Game {
    int id;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    Date date;

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
