package com.liceu.geom.model;

import java.util.Date;

public class Game {

    private int id;

    private Player player;

    private MazeMap mazeMap;

    public long startTime;

    private long totalTime;

    private boolean victory = false;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public MazeMap getMazeMap() {
        return mazeMap;
    }

    public void setMazeMap(MazeMap mazeMap) {
        this.mazeMap = mazeMap;
    }

    public boolean isVictory() {
        return victory;
    }

    public void setVictory(boolean victory) {
        this.victory = victory;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getTotalTime() {
        return totalTime;
    }

    public void setTotalTime(long totalTime) {
        this.totalTime = totalTime;
    }
}
