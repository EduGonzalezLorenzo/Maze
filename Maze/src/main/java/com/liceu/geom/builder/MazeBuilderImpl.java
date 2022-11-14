package com.liceu.geom.builder;

import com.liceu.geom.model.DoorKey;
import com.liceu.geom.model.MazeMap;
import com.liceu.geom.model.Room;
import com.liceu.geom.model.Side;

public class MazeBuilderImpl implements MazeBuilder{
    @Override
    public void buildRoom(int nRoom) {
        Room room = new Room(nRoom);

    }

    @Override
    public void setGoal(int nRoom) {

    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Side.Directions dir) {

    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Side.Directions dir, DoorKey key) {

    }

    @Override
    public void putKeyInRoom(int nRoom, DoorKey key) {

    }

    @Override
    public MazeMap getMaze() {
        return null;
    }
}
