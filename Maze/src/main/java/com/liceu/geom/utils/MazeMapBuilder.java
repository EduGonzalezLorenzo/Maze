package com.liceu.geom.utils;

import com.liceu.geom.model.DoorKey;
import com.liceu.geom.model.MazeMap;
import com.liceu.geom.model.Side;

public interface MazeMapBuilder {
    public void buildRoom(int nRoom);

    void setGoal(int nroom);

    void buildDoor(int roomFrom, int roomTo, Side.Directions dir);

    void buildDoor(int roomFrom, int roomTo, Side.Directions dir, DoorKey key);

    void putKeyInRoom(int nRoom, DoorKey key);

    MazeMap getMaze();
}


