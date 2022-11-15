package com.liceu.geom.services;

import com.liceu.geom.model.Door;
import com.liceu.geom.model.Game;
import com.liceu.geom.model.Room;

public class DoorService {
    public static Door getDoor(Room r1, Room r2) {
        Door door = new Door();
        door.setRoomFrom(r1);
        door.setRoomTo(r2);
        return door;
    }

    public static boolean openDoor(Game game){
        //Si usuario tiene llave abrir puerta y return true;
        //Si usuario no tiene la llave
        return false;
    }
}
