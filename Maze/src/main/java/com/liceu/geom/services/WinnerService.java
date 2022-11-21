package com.liceu.geom.services;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.Winner;

import java.util.Collections;
import java.util.List;

public class WinnerService {
    public static Winner generateWinner(Game game) {
        Winner winner = new Winner();
        winner.setMazeName(game.getMazeMap().getName());
        winner.setPlayerName(game.getPlayer().getName());
        winner.setTimeInMilliseconds((int) game.getTotalTime());
        return winner;
    }

    public static List<Winner> FormatWinners(List<Winner> winners) {
        Collections.sort(winners);
        for (int i = 0; i < winners.size(); i++) {
            Winner winner = winners.get(i);
            winner.setPosition(i + 1);
            winner.setFormattedTime(WinnerService.formatTime(winner.getTimeInMilliseconds()));
        }
        return winners;
    }

    private static String formatTime(int timeInMilliseconds) {
        long second = (timeInMilliseconds / 1000) % 60;
        long minute = (timeInMilliseconds / (1000 * 60)) % 60;
        long hour = (timeInMilliseconds / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }
}