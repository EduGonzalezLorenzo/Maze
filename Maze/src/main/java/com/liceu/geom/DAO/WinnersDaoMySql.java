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
            preparedStatement.setString(1, winner.getMazeName());
            preparedStatement.setLong(1, winner.getTime());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                int id = resultSet.getInt(1);
                winner.setId(id);
                //return user; se podria hacer que devuelva el usuario creado para verificar que se ha creado correctamene
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
            ResultSet resultSet = st.executeQuery("select * from figura");
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String playerName = resultSet.getString(2);
                String mazeName = resultSet.getString(3);
                Long time = resultSet.getLong(4);
                Winner winner = new Winner();
                winner.setId(id);
                winner.setPlayerName(playerName);
                winner.setMazeName(mazeName);
                winner.setTime(time);
                allWinners.add(winner);
            }
            return allWinners;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}



