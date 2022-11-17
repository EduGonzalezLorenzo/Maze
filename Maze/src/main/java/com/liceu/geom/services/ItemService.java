package com.liceu.geom.services;

import com.liceu.geom.model.*;
import org.w3c.dom.ranges.DocumentRange;

import java.util.List;

public class ItemService {
    public static int getCoinsAmount(List<Item> inventory) {
        int coins = 0;
        for (Item item : inventory) {
            if (item instanceof Coin) coins++;
        }
        return coins;
    }

    public static int getKeysAmount(List<Item> inventory) {
        int keys = 0;
        for (Item item : inventory) {
            if (item instanceof DoorKey) keys++;
        }
        return keys;
    }

    public static List<Item> addItem(List<Item> inventory, Item item) {
        inventory.add(item);
        return inventory;
    }

    public static List<Item> removeCoin(List<Item> items) {
        items.removeIf(item -> item instanceof Coin);
        return items;
    }

    public static DoorKey getKeyFromRoom(Room room) {
        List<Item> roomItems = room.getItems();
        for (Item item : roomItems) {
            if (item instanceof DoorKey) {
                roomItems.remove(item);
                room.setItems(roomItems);
                return (DoorKey) item;
            }
        }
        return null;
    }

}
