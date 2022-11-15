package com.liceu.geom.model;

public class Game {
    private Player player;
    private MazeMap mazeMap;

    private boolean victory = false;

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
}
