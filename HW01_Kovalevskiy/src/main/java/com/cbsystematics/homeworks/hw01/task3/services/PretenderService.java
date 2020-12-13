package com.cbsystematics.homeworks.hw01.task3.services;

import com.cbsystematics.homeworks.hw01.task3.dao.impl.PretenderDAOImpl;
import com.cbsystematics.homeworks.hw01.task3.entity.Pretender;

import java.util.List;

public class PretenderService {
    
    private static final PretenderDAOImpl pretenderDAO = new PretenderDAOImpl();
    
    public static Pretender getPretender(Long id) {
        return PretenderService.pretenderDAO.selectOne(id);
    }
    
    public static List<Pretender> getPretendersByCurrency(String currency) {
        return PretenderService.pretenderDAO.selectByCurrency(currency);
    }
    
    public static List<Pretender> getPretendersByCountry(String country) {
        return PretenderService.pretenderDAO.selectByCountry(country);
    }
    
    public static List<Pretender> getPretendersByModerator(int id) {
        return PretenderService.pretenderDAO.selectByModerator(id);
    }
}
