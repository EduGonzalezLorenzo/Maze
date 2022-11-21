package com.liceu.geom.DAO;

import com.liceu.geom.model.Winner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static com.liceu.geom.DAO.MySqlDatabase.getConnection;

public class WinnersDaoMySql implements WinnersDao {
    @Override
    public void addToWinners(Winner winner) {
        try {
            Connection con = getConnection();
            String query = "insert into winners (PlayerName, MazeName, Time) values (?,?,?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, winner.getPlayerName());
            preparedStatement.setString(2, winner.getMazeName());
            preparedStatement.setInt(3, (int) winner.getTimeInMilliseconds());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                winner.setId(id);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public List<Winner> getWinners() {
        try {
            List<Winner> allWinners = new ArrayList<>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from Winners");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String playerName = resultSet.getString(2);
                String mazeName = resultSet.getString(3);
                int time = resultSet.getInt(4);
                Winner winner = new Winner();
                winner.setId(id);
                winner.setPlayerName(playerName);
                winner.setMazeName(mazeName);
                winner.setTimeInMilliseconds(time);
                allWinners.add(winner);
            }
            return allWinners;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



