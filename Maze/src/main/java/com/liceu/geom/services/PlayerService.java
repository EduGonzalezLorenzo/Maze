package com.liceu.geom.services;

import com.liceu.geom.model.MazeMap;
import com.liceu.geom.model.Player;
import com.liceu.geom.model.Room;

import java.util.Map;

public class PlayerService {
    public static Player generatePlayer(MazeMap mazeMap) {
        Player player = new Player();
        for (Map.Entry<Integer, Room> entry : mazeMap.getRoomList().entrySet()) {
            Room room = entry.getValue();
            if (room.isStart()) {
                player.setLocation(room);
            }
        }
        return player;
    }

}
