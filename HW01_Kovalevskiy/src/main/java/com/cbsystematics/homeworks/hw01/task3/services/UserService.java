package com.cbsystematics.homeworks.hw01.task3.services;

import com.cbsystematics.homeworks.hw01.task3.dao.impl.UserDAOImpl;
import com.cbsystematics.homeworks.hw01.task3.entity.User;

import java.util.List;

public class UserService {
    
    private static final UserDAOImpl userDAO = new UserDAOImpl();
    
    public static User getUser(Long id) {
        return UserService.userDAO.selectOne(id);
    }
    
    public static User getUserByEnterprise(Long id) {
        return UserService.userDAO.selectByEnterprise(id);
    }
    
    public static List<User> getUsersByCountry(String country) {
        return UserService.userDAO.selectByCountry(country);
    }
    
    public static List<User> getUsersByModerator(int id) {
        return UserService.userDAO.selectByModerator(id);
    }
}
