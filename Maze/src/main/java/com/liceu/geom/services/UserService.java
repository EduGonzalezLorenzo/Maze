package com.liceu.geom.services;

import com.liceu.geom.DAO.UserDao;
import com.liceu.geom.DAO.UserDaoMySql;

public class UserService {
    UserDao userDao = new UserDaoMySql();
}
