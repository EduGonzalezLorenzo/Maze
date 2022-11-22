package com.liceu.geom.services;

import com.liceu.geom.DAO.WinnersDao;
import com.liceu.geom.DAO.WinnersDaoMySql;
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

    private static String formatTime(int timeInMilliseconds) {
        //Se formata el tiempo para mostrarlo en hh:mm:ss en lugar de en milisegundos.
        long second = (timeInMilliseconds / 1000) % 60;
        long minute = (timeInMilliseconds / (1000 * 60)) % 60;
        long hour = (timeInMilliseconds / (1000 * 60 * 60)) % 24;

        return String.format("%02d:%02d:%02d", hour, minute, second);
    }

    public static List<Winner> getWinners() {
        WinnersDao winnersDao = new WinnersDaoMySql();
        List<Winner> winners = winnersDao.getWinners();
        return WinnerService.FormatWinners(winners);
    }

    public static List<Winner> FormatWinners(List<Winner> winners) {
        //Se ordenan los ganadores por tiempo (el que ha tardado menos arriba)
        Collections.sort(winners);
        //Se añade la posición al ganador para poder mostrarlo en el cliente y se da formato al tiempo
        for (int i = 0; i < winners.size(); i++) {
            Winner winner = winners.get(i);
            winner.setPosition(i + 1);
            winner.setFormattedTime(WinnerService.formatTime(winner.getTimeInMilliseconds()));
        }
        return winners;
    }
}