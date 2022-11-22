package com.liceu.geom.services;

import com.liceu.geom.model.*;

public class SideService {
    public static String enterSide(Player player, Side side) {
        //Se comprueba si se intenta entrar en un muro o en una puerta.
        //Si es puerta se comprueba si esta abierta o cerrada.
        if (side instanceof Wall) return "Hay un muro!";
        Door door = (Door) side;
        if (door.isOpen()) {
            Room room = getOtherRoom(player.getLocation(), door);
            player.setLocation(room);
            return null;
        } else {
            return "La puerta esta cerrada.";
        }
    }

    public static Room getOtherRoom(Room location, Door door) {
        //Se comprueba en cual de las dos habitaciones que conecta la puerta esta el jugador y se le lleva a la otra.
        if (location.getRoomID() == door.getRoomFrom().getRoomID()) return door.getRoomTo();
        return door.getRoomFrom();
    }

    public static Side.Directions getDirection(String dir) {
        return switch (dir) {
            case "N" -> Side.Directions.NORTH;
            case "S" -> Side.Directions.SOUTH;
            case "E" -> Side.Directions.EAST;
            case "W" -> Side.Directions.WEST;
            default -> null;
        };
    }
}
