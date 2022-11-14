package com.liceu.geom.services;

import com.liceu.geom.model.Room;

public class RoomService {
    public static Room createRoom(int roomID) {
        Room room = new Room();
        room.setRoomID(roomID);
        return room;
    }
}
