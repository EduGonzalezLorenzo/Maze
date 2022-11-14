package com.liceu.geom.model;

import java.util.HashMap;
import java.util.Map;

public class MazeMap {
    int id;
    String mazeName;

    private Map<Integer, Room> roomList = new HashMap<>();

    public MazeMap(String mazeName) {
        this.mazeName = mazeName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMazeName() {
        return mazeName;
    }

    public void setMazeName(String mazeName) {
        this.mazeName = mazeName;
    }
}
