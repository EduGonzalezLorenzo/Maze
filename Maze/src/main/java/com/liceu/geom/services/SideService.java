package com.liceu.geom.services;

import com.liceu.geom.model.*;

public class SideService {
    public static String enterSide(Player player, Side side) {
        if (side instanceof Wall) return "No puedes atravesar una pared!";
        Door door = (Door) side;
        if (door.isOpen()) {
            Room room = getOtherRoom(player.getLocation(), door);
            player.setLocation(room);
            return null;
        } else {
            return "La puerta esta cerrada.";
        }
    }

    private static Room getOtherRoom(Room location, Door door) {
        if (location.getRoomID() == door.getRoomFrom().getRoomID()) return door.getRoomTo();
        return door.getRoomFrom();
    }
}
