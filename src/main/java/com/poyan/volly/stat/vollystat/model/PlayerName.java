package com.poyan.volly.stat.vollystat.model;

public enum PlayerName {
    Ahmad(1),
    Akul(2),
    Hedi(3),
    Maks(4),
    Mohsen(5),
    Nima(6),
    Nuri(7),
    Peiman(8),
    Poyan(9),
    RezaPanjaki(10),
    Saman(11),
    Sayed(12),
    Shahram(13),
    Sirus(14),
    Oskan(15),
    Babak(16),
    Zafar(17),
    Guest(18),
    Milad(19),
    Emad(20),
    Ali(21);
    private final int id;

    PlayerName(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }
}
