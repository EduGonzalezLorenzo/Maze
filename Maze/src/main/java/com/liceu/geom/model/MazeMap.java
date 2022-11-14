package com.liceu.geom.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MazeMap {
    int id;
    String mazeName;

    private Map<Integer, Room> roomList = new HashMap<>();

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

    public Map<Integer, Room> getRoomList() {
        return roomList;
    }

    public void setRoomList(Map<Integer, Room> roomList) {
        this.roomList = roomList;
    }

    public void addRoom(int nRoom, Room room) {
        roomList.put(nRoom, room);
    }

    public Room getRoom(int nRoom){
        return roomList.get(nRoom);
    }
}
