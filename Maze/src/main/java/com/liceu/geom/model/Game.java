package com.liceu.geom.model;

public class Game {
    int id;

    private Player player;
    private MazeMap mazeMap;



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
}
