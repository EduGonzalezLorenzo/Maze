package com.liceu.geom.DAO;

import com.liceu.geom.model.Game;
import com.liceu.geom.model.Player;

import java.util.List;

public interface WinnersDao {
    public void addToWinners(Game game);
    public List<Game> getWinners();
}
