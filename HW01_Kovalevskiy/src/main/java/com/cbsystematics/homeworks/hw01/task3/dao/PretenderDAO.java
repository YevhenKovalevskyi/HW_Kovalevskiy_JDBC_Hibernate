package com.cbsystematics.homeworks.hw01.task3.dao;

import com.cbsystematics.homeworks.hw01.task3.entity.Pretender;

import java.util.List;

public interface PretenderDAO extends BaseDAO<Long, Pretender> {
    
    List<Pretender> selectByCountry(String country);
    List<Pretender> selectByCurrency(String currency);
    List<Pretender> selectByModerator(int id);
}
