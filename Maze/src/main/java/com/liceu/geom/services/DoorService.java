package com.liceu.geom.services;

import com.liceu.geom.model.Door;
import com.liceu.geom.model.Room;

public class DoorService {
    public static Door getDoor(Room r1, Room r2) {
        Door door = new Door();
        door.setRoomFrom(r1);
        door.setRoomTo(r2);
        return door;
    }
}
