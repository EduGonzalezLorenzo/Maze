package com.liceu.geom.DAO;

import com.liceu.geom.model.Winner;

import java.util.List;

public interface WinnersDao {
    public void addToWinners(Winner winner);
    public List<Winner> getWinners();
}
