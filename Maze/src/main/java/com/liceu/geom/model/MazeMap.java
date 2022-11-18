package com.liceu.geom.model;

import java.util.HashMap;
import java.util.Map;

public class MazeMap {
    int id;
    String name;

    private Map<Integer, Room> roomList = new HashMap<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
