package com.liceu.geom.services;

import com.liceu.geom.model.*;
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
        DoorKey doorKey = ItemService.getKey(room.getItems());
        if (doorKey==null) return "No hay llave en esta habitación";
        //TODO añadir error al intentarlo
        int keyCost = doorKey.getValue();
        if (ItemService.getCoinsAmount(player.getInventory()) >= keyCost){
            for (int i = 0; i < keyCost; i++) {
                ItemService.removeCoin(player.getInventory());
            }
            ItemService.addItem(player.getInventory(), doorKey);
            return doorKey.getName() + " recogida!";
        }else {
            ItemService.putKeyInRoom(room, doorKey);
            return "Monedas insuficientes!";
        }

    }

    public static String giveCoinToPlayer(Room room, Player player) {
        ItemService.removeCoin(room.getItems());
        ItemService.addItem(player.getInventory(), new Coin());
        return "Has obtenido una moneda!";
    }
}
