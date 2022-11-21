package com.liceu.geom.model;

public class Winner implements Comparable {
    private int id;
    private int position;
    private int timeInMilliseconds;

    private String formattedTime;
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

    public int getTimeInMilliseconds() {
        return timeInMilliseconds;
    }

    public void setTimeInMilliseconds(int timeInMilliseconds) {
        this.timeInMilliseconds = timeInMilliseconds;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
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

    @Override
    public int compareTo(Object o) {
        Winner winner = (Winner) o;
        if (this.timeInMilliseconds > winner.timeInMilliseconds) {
            return 1;
        } else if (this.timeInMilliseconds == winner.timeInMilliseconds) {
            return 0;
        } else return -1;
    }
}
