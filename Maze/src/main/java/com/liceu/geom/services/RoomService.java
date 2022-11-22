package com.liceu.geom.services;

import com.liceu.geom.model.Coin;
import com.liceu.geom.model.DoorKey;
import com.liceu.geom.model.Player;
import com.liceu.geom.model.Room;

public class RoomService {
    public static Room createRoom(int roomID) {
        Room room = new Room();
        room.setRoomID(roomID);
        return room;
    }

    public static String giveKeyToPlayer(Room room, Player player) {
        //Se comprueba si hay llaves en la habitación.
        DoorKey doorKey = ItemService.getKey(room.getItems());
        if (doorKey == null) {
            throw new NoItemExepcition();
        }
        //Si hay una llave se coge de la habitación y se comprueba si el usuario tiene suficientes monedas.
        //Si las tiene se da al jugador la llave y se le quitan las monedas que cueste la llave.
        //Si no las tiene la llave se devuelve a la habitación.
        int keyCost = doorKey.getValue();
        if (ItemService.getCoinsAmount(player.getInventory()) >= keyCost) {
            for (int i = 0; i < keyCost; i++) {
                ItemService.removeCoin(player.getInventory());
            }
            ItemService.addItem(player.getInventory(), doorKey);
            return doorKey.getName() + " recogida!";
        } else {
            ItemService.putKeyInRoom(room, doorKey);
            return "Monedas insuficientes!";
        }
    }

    public static String giveCoinToPlayer(Room room, Player player) {
        //Se comprueba si hay monedas en la habitación y si hay la quita de la habitación y se la da al jugador.
        String getCoinStatus = ItemService.removeCoin(room.getItems());
        if (getCoinStatus == null) throw new NoItemExepcition();
        else ItemService.addItem(player.getInventory(), new Coin());
        return getCoinStatus;
    }
}
