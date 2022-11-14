package com.liceu.geom.DAO;

import com.liceu.geom.model.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static com.liceu.geom.DAO.MySqlDatabase.getConnection;

public class UserDaoMySql implements UserDao{

    @Override
    public void login(User user) {

    }

    @Override
    public void saveUser(User user) {
        try {
            Connection con = getConnection();
            String query = "insert into user (name) values (?)";
            PreparedStatement preparedStatement = con.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, user.getName());
            preparedStatement.execute();
            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()){
                int id = resultSet.getInt(1);
                user.setId(id);
                //return user; se podria hacer que devuelva el usuario creado para verificar que se ha creado correctamene
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    @Override
    public User getUser(String userName) {
        return null;
    }

    public List<User> getAllUser(){
        try {
            List<User> allUser = new ArrayList<>();
            Connection con = getConnection();
            Statement st = con.createStatement();
            ResultSet resultSet = st.executeQuery("select * from figura");
            while (resultSet.next()){
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                User user = new User(name);
                user.setId(id);
                allUser.add(user);
            }
            return allUser;
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
