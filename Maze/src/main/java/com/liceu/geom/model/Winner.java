package com.liceu.geom.model;

public class Winner {
    private int id;
    private int position;
    private long time;
    private String mazeName;
    private String playerName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getMazeName() {
        return mazeName;
    }

    public void setMazeName(String mazeName) {
        this.mazeName = mazeName;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }
}
