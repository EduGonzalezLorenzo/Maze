package com.liceu.geom.services;

import com.liceu.geom.DAO.WinnersDao;
import com.liceu.geom.DAO.WinnersDaoMySql;
import com.liceu.geom.model.*;
import org.json.simple.JSONObject;

import java.util.List;

public class GameService {

    public static String getGameJson(Game game, String msg) {
        Player player = game.getPlayer();
        Room room = player.getLocation();

        JSONObject root = new JSONObject();
        JSONObject roomInfo = new JSONObject();
        JSONObject playerInfo = new JSONObject();
        JSONObject gameInfo = new JSONObject();

        putRoomInfo(player, room, roomInfo, msg);
        putPlayerInfo(player, playerInfo);
        putGameInfo(gameInfo, game);

        putInfoToJson(root, roomInfo, playerInfo, gameInfo);

        return root.toJSONString();
    }

    private static void putInfoToJson(JSONObject root, JSONObject roomInfo, JSONObject playerInfo, JSONObject gameInfo) {
        root.put("Room", roomInfo);
        root.put("Player", playerInfo);
        root.put("Game", gameInfo);
    }

    private static void putGameInfo(JSONObject gameInfo, Game game) {
        gameInfo.put("gameStatus", game.isVictory());
    }

    private static void putPlayerInfo(Player player, JSONObject playerInfo) {
        playerInfo.put("Coins", ItemService.getCoinsAmount(player.getInventory()));
        playerInfo.put("Keys", ItemService.getKeysAmount(player.getInventory()));
    }


    private static void putRoomInfo(Player player, Room room, JSONObject roomInfo, String msg) {
        roomInfo.put("roomNumber", player.getLocation().getRoomID());
        roomInfo.put("N", room.getSide(Side.Directions.NORTH).toString());
        roomInfo.put("S", room.getSide(Side.Directions.SOUTH).toString());
        roomInfo.put("E", room.getSide(Side.Directions.EAST).toString());
        roomInfo.put("W", room.getSide(Side.Directions.WEST).toString());
        roomInfo.put("Coins", ItemService.getCoinsAmount(room.getItems()));
        roomInfo.put("Keys", ItemService.getKeysAmount(room.getItems()));
        roomInfo.put("msg", msg);
    }

    public static String movePlayer(Game game, String dir) {
        Side.Directions direction = SideService.getDirection(dir);
        Player player = game.getPlayer();
        Room room = player.getLocation();
        Side roomSide = room.getSide(direction);
        return SideService.enterSide(player, roomSide);
    }

    public static void addPlayerToWinners(Game game) {
        WinnersDao winnersDao = new WinnersDaoMySql();
        Winner winner = WinnerService.generateWinner(game);
        winnersDao.addToWinners(winner);
    }

    public static void endGame(Game game) {
        game.setVictory(true);
        game.setTotalTime(System.currentTimeMillis() - game.getStartTime());

    }

    public static List<Winner> getWinners() {
        WinnersDao winnersDao = new WinnersDaoMySql();
        List<Winner> winners = winnersDao.getWinners();
        return WinnerService.FormatWinners(winners);
    }

    public static Game createNewGame(int mazeMapType) {
        Game game = new Game();
        MazeMap mazeMap = MazeMapService.generateMazeMap(mazeMapType);
        Player player = PlayerService.generatePlayer(mazeMap);
        game.setPlayer(player);
        game.setMazeMap(mazeMap);
        game.setStartTime(System.currentTimeMillis());
        return game;
    }
}
