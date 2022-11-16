package com.liceu.geom.services;

import com.liceu.geom.model.*;

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

}
