package com.liceu.geom.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Room {
    private int roomNumber;
    private Map<Side.Directions, Side> sides = new HashMap<>();
    private List<Item> items = new ArrayList<>();
    private boolean goal = false;

    public Room(int roomNumber) {
        this.roomNumber = roomNumber;
    }
}