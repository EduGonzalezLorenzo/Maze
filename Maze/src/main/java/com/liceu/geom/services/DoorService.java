package com.liceu.geom.services;

import com.liceu.geom.model.*;

public class DoorService {
    public static Door buildDoor(Room r1, Room r2) {
        Door door = new Door();
        door.setRoomFrom(r1);
        door.setRoomTo(r2);
        return door;
    }

    public static String openDoor(Game game, String dir) {
        Side.Directions side = SideService.getDirection(dir);
        Player player = game.getPlayer();
        Room room = player.getLocation();
        Side candidate = room.getSide(side);
        if (candidate instanceof Wall) {
            return "No puedes abrir muros.";
        } else {
            Door door = (Door) candidate;
            if (door.isOpen()) return "La puerta ya esta abierta.";
            DoorKey doorKey = ItemService.getSpecificKey(player.getInventory(), door);
            if (doorKey == null) return "No tienes la llave";
            if (doorKey.getDoor() == door) {
                door.setOpen(true);
                return "Puerta abierta";
            } else ItemService.putKeyInRoom(room, doorKey);
        }
        return "";
    }

}
