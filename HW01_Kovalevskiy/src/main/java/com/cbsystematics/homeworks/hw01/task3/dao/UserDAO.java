package com.cbsystematics.homeworks.hw01.task3.dao;

import com.cbsystematics.homeworks.hw01.task3.entity.User;


import java.util.List;

public interface UserDAO extends BaseDAO<Long, User> {
    
    User selectByEnterprise(Long id);
    List<User> selectByCountry(String country);
    List<User> selectByModerator(int id);
}
