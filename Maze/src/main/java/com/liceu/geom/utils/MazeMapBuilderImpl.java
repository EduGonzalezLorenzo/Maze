package com.liceu.geom.utils;

import com.liceu.geom.model.*;
import com.liceu.geom.services.DoorService;
import com.liceu.geom.services.RoomService;


public class MazeMapBuilderImpl implements MazeMapBuilder{
    private MazeMap mazeMap = new MazeMap();

    @Override
    public void setName(String name) {
        this.mazeMap.setName(name);
    }

    @Override
    public void buildRoom(int nRoom) {
        Room room = RoomService.createRoom(nRoom);
        room.setSide(Side.Directions.NORTH, new Wall());
        room.setSide(Side.Directions.SOUTH, new Wall());
        room.setSide(Side.Directions.EAST, new Wall());
        room.setSide(Side.Directions.WEST, new Wall());
        mazeMap.addRoom(nRoom, room);
    }

    @Override
    public void setGoal(int nroom) {
        this.mazeMap.getRoom(nroom).setGoal(true);
    }

    @Override
    public void buildDoor(int roomFrom, int roomTo, Side.Directions dir) {
        Door door = buildDoorInternal(roomFrom, roomTo, dir);
    }

    @Override
    public void buildDoorWithKey(int roomFrom, int roomTo, Side.Directions dir, DoorKey key) {
        Door door = buildDoorInternal(roomFrom, roomTo, dir);
        door.setOpen(false);
        key.setDoor(door);
    }

    private Door buildDoorInternal(int roomFrom, int roomTo, Side.Directions dir) {
        Room r1 = mazeMap.getRoom(roomFrom);
        Room r2 = mazeMap.getRoom(roomTo);
        Door door = DoorService.buildDoor(r1, r2);
        r1.setSide(dir, door);
        r2.setSide(getOppositeSide(dir), door);
        return door;
    }


    private Side.Directions getOppositeSide(Side.Directions dir) {
        return switch (dir) {
            case NORTH -> Side.Directions.SOUTH;
            case SOUTH -> Side.Directions.NORTH;
            case EAST -> Side.Directions.WEST;
            case WEST -> Side.Directions.EAST;
        };
    }

    @Override
    public void putKeyInRoom(int nRoom, DoorKey key) {
        mazeMap.getRoom(nRoom).addItem(key);
    }

    @Override
    public MazeMap getMaze() {
        return this.mazeMap;
    }

    public void putCoinInRoom(int nRoom, Coin coin) {
        mazeMap.getRoom(nRoom).addItem(coin);
    }

    @Override
    public void setStart(int nRoom) {
        this.mazeMap.getRoom(nRoom).setStart(true);
    }
}
