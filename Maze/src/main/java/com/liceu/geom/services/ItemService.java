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

    public static void removeCoin(List<Item> items) {
        for (Item item : items) {
            if (item instanceof Coin) {
                items.remove(item);
                return;
            }
        }
    }

    public static DoorKey getKey(List<Item> items) {
        for (Item item : items) {
            if (item instanceof DoorKey) {
                items.remove(item);
                return (DoorKey) item;
            }
        }
        return null;
    }

    public static void putKeyInRoom(Room room, DoorKey doorKey) {
        room.getItems().add(doorKey);
    }

    public static DoorKey getSpecificKey(List<Item> items, Door door) {
        for (Item item : items) {
            if (item instanceof DoorKey) {
                DoorKey candidateKey = (DoorKey) item;
                if (candidateKey.getDoor() == door) {
                    items.remove(item);
                    return candidateKey;
                }
            }
        }
        return null;
    }
}
