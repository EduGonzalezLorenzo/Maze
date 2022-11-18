package com.liceu.geom.DAO;

import com.liceu.geom.model.Game;

import java.util.ArrayList;
import java.util.List;

public class WinnersDaoImpl implements WinnersDao{
    static List<Game> winnersList = new ArrayList<>();
    static int winnerID = 0;
    @Override
    public void addToWinners(Game game) {
        game.setId(winnerID);
        winnerID++;
        winnersList.add(game);
    }

    @Override
    public List<Game> getWinners() {
        return winnersList;
    }
}
