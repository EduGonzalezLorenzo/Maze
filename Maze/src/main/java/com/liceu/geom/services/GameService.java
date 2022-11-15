package com.liceu.geom.services;

import com.liceu.geom.model.*;
import org.json.simple.JSONObject;

public class GameService {
    Game game = new Game();

    public static String getJsonInfo(Game game) {
        Player player = game.getPlayer();

        JSONObject root = new JSONObject();
        JSONObject sides = new JSONObject();
        JSONObject playerInfo = new JSONObject();

        sides.put("N", player.getLocation().getSide(Side.Directions.NORTH));
        sides.put("S", player.getLocation().getSide(Side.Directions.SOUTH));
        sides.put("E", player.getLocation().getSide(Side.Directions.EAST));
        sides.put("W", player.getLocation().getSide(Side.Directions.WEST));

        playerInfo.put("Coins", PlayerService.getCoinsAmount(player));
        playerInfo.put("Keys", PlayerService.getKeysAmount(player));

        root.put("Room", sides);
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

    public static void chargeCurrentLocation(Game game) {
    }

    public Game createNewGame(int mazeMapType) {
        MazeMap mazeMap = MazeMapService.generateMazeMap(mazeMapType);
        Player player = PlayerService.generatePlayer(mazeMap);
        game.setPlayer(player);
        game.setMazeMap(mazeMap);
        return game;
    }
}
