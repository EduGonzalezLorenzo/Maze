package com.liceu.geom.services;

import com.liceu.geom.model.*;

import java.util.Collection;
import java.util.List;

public class RoomService {
    public static Room createRoom(int roomID) {
        Room room = new Room();
        room.setRoomID(roomID);
        return room;
    }

    public static boolean hasCoin(Room room) {
        List<Item> itemList = room.getItems();
        for (Item item : itemList) {
            if (item instanceof Coin) return true;
        }
        return false;
    }

    public static boolean hasKey(Room room) {
        List<Item> itemList = room.getItems();
        for (Item item : itemList) {
            if (item instanceof DoorKey) return true;
        }
        return false;
    }

    public static String giveKeyToPlayer(Room room, Player player) {
        //Revisar si el player tiene suficientes coins:
            //Si las tiene se le quitan las monedas, se le da la llave y msg de exito.
            //Si no se devuelve msg de fracaso.
        DoorKey doorKey = ItemService.getKeyFromRoom(room);
        ItemService.addItem(player.getInventory(), doorKey);
        return "Has obtenido una llave!";
    }

    public static String giveCoinToPlayer(Room room, Player player) {
        ItemService.removeCoin(room.getItems());
        ItemService.addItem(player.getInventory(), new Coin());
        return "Has obtenido una moneda!";
    }
}
