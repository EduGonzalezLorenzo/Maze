package com.liceu.geom.services;

import com.liceu.geom.model.*;
import org.json.simple.JSONObject;

public class GameService {
    Game game = new Game();

    public static String getJsonInfo(Game game, String msg) {
        Player player = game.getPlayer();
        Room room = player.getLocation();

        JSONObject root = new JSONObject();
        JSONObject roomInfo = new JSONObject();
        JSONObject playerInfo = new JSONObject();

        roomInfo.put("roomNumber", player.getLocation().getRoomID());
        roomInfo.put("N", room.getSide(Side.Directions.NORTH).toString());
        roomInfo.put("S", room.getSide(Side.Directions.SOUTH).toString());
        roomInfo.put("E", room.getSide(Side.Directions.EAST).toString());
        roomInfo.put("W", room.getSide(Side.Directions.WEST).toString());
        roomInfo.put("Coins", ItemService.getCoinsAmount(room.getItems()));
        roomInfo.put("Keys", ItemService.getKeysAmount(room.getItems()));
        roomInfo.put("msg", msg);

        playerInfo.put("Coins", ItemService.getCoinsAmount(player.getInventory()));
        playerInfo.put("Keys", ItemService.getKeysAmount(player.getInventory()));

        root.put("Room", roomInfo);
        root.put("Player", playerInfo);

        return root.toJSONString();
    }

    public static String movePlayer(Game game, String dir) {
        Side.Directions direction = getDirection(dir);
        Player player = game.getPlayer();
        Room room = player.getLocation();
        Side roomSide = room.getSide(direction);
        return SideService.enterSide(player, roomSide);
    }

    private static Side.Directions getDirection(String dir) {
        return switch (dir) {
            case "N" -> Side.Directions.NORTH;
            case "S" -> Side.Directions.SOUTH;
            case "E" -> Side.Directions.EAST;
            case "W" -> Side.Directions.WEST;
            default -> null;
        };
    }

    public Game createNewGame(int mazeMapType) {
        MazeMap mazeMap = MazeMapService.generateMazeMap(mazeMapType);
        Player player = PlayerService.generatePlayer(mazeMap);
        game.setPlayer(player);
        game.setMazeMap(mazeMap);
        return game;
    }
}
