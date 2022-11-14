package com.liceu.geom.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private int roomID;
    private Map<Side.Directions, Side> sides = new HashMap<>();
    private List<Item> items = new ArrayList<>();
    private boolean goal = false;
    private boolean start = false;

    public int getRoomID() {
        return roomID;
    }

    public void setRoomID(int roomID) {
        this.roomID = roomID;
    }

    public Map<Side.Directions, Side> getSides() {
        return sides;
    }

    public void setSides(Map<Side.Directions, Side> sides) {
        this.sides = sides;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public boolean isGoal() {
        return goal;
    }

    public void setGoal(boolean goal) {
        this.goal = goal;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public void setSide(Side.Directions dir, Side side){
        sides.put(dir, side);
    }

    public Side getSide(Side.Directions dir){
        return this.sides.get(dir);
    }

    public void addItem(Item item) {
        items.add(item);
    }
}