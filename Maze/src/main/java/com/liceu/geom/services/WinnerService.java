package com.liceu.geom.services;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.Winner;

import java.util.List;

public class WinnerService {
    public static Winner generateWinner(Game game) {
        Winner winner = new Winner();
        winner.setMazeName(game.getMazeMap().getName());
        winner.setPlayerName(game.getPlayer().getName());
        winner.setTime(game.getTotalTime());
        return winner;
    }

    public static List<Winner> SortWinners(List<Winner> winners) {
        return winners;
    }
}
