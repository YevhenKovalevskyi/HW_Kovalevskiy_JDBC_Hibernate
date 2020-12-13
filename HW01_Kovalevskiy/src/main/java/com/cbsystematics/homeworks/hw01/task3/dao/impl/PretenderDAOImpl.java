package com.cbsystematics.homeworks.hw01.task3.dao.impl;

import com.cbsystematics.homeworks.hw01.task3.dao.PretenderDAO;
import com.cbsystematics.homeworks.hw01.task3.entity.Pretender;
import com.cbsystematics.homeworks.hw01.task3.models.SQLModel;
import com.mysql.cj.util.StringUtils;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class PretenderDAOImpl implements PretenderDAO {
    
    @Override
    @SneakyThrows
    public Pretender insert(Pretender pretender) {
        return null;
    }
    
    @Override
    @SneakyThrows
    public Pretender update(Pretender pretender) {
        return null;
    }
    
    @Override
    @SneakyThrows
    public boolean delete(Pretender pretender) {
        return true;
    }
    
    @Override
    @SneakyThrows
    public boolean delete(Long id) {
        return true;
    }
    
    @Override
    @SneakyThrows
    public List<Pretender> selectAll() {
        return null;
    }
    
    @Override
    @SneakyThrows
    public Pretender selectOne(Long id) {
        Pretender pretender = null;
        
        String query =
                "SELECT " +
                    "f_ent_id AS ent_id, p_country_code AS country_code, p_currency_code AS currency_code, " +
                    "p_account_name AS account_name, p_account_url AS account_url, p_account_timezone AS account_timezone, " +
                    "p_account_budget AS account_budget, f_mod_id AS mod_id " +
                "FROM pretenders " +
                "WHERE f_ent_id = " + id;
        
        ArrayList<HashMap<String, String>> result = SQLModel.execute(query);
    
        if (result.size() > 0) {
            HashMap<String, String> item = result.get(0);
            
            pretender = new Pretender();
            pretender.setEntId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("ent_id")) ? "0" : item.get("ent_id")));
            pretender.setCountryCode(item.get("country_code"));
            pretender.setCurrencyCode(item.get("currency_code"));
            pretender.setAccountName(item.get("account_name"));
            pretender.setAccountUrl(item.get("account_url"));
            pretender.setAccountTimezone(item.get("account_timezone"));
            pretender.setAccountBudget(Byte.parseByte(item.get("account_budget")));
            pretender.setModId(Integer.parseInt(StringUtils.isNullOrEmpty(item.get("mod_id")) ? "0" : item.get("mod_id")));
        }
        
        return pretender;
    }
    
    @Override
    @SneakyThrows
    public List<Pretender> selectByCountry(String country) {
        List<Pretender> pretenders = new ArrayList<>();
    
        String query =
                "SELECT " +
                    "f_ent_id AS ent_id, p_country_code AS country_code, p_currency_code AS currency_code, " +
                    "p_account_name AS account_name, p_account_url AS account_url, p_account_timezone AS account_timezone, " +
                    "p_account_budget AS account_budget, f_mod_id AS mod_id " +
                "FROM pretenders " +
                "WHERE p_country_code = '" + country + "'";
    
        ArrayList<HashMap<String, String>> result = SQLModel.execute(query);
    
        if (result.size() > 0) {
            result.forEach(item -> {
                Pretender pretender = new Pretender();
                pretender.setEntId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("ent_id")) ? "0" : item.get("ent_id")));
                pretender.setCountryCode(item.get("country_code"));
                pretender.setCurrencyCode(item.get("currency_code"));
                pretender.setAccountName(item.get("account_name"));
                pretender.setAccountUrl(item.get("account_url"));
                pretender.setAccountTimezone(item.get("account_timezone"));
                pretender.setAccountBudget(Byte.parseByte(item.get("account_budget")));
                pretender.setModId(Integer.parseInt(StringUtils.isNullOrEmpty(item.get("mod_id")) ? "0" : item.get("mod_id")));
    
                pretenders.add(pretender);
            });
        }
    
        return pretenders;
    }
    
    @Override
    @SneakyThrows
    public List<Pretender> selectByCurrency(String currency) {
        List<Pretender> pretenders = new ArrayList<>();
    
        String query =
                "SELECT " +
                    "f_ent_id AS ent_id, p_country_code AS country_code, p_currency_code AS currency_code, " +
                    "p_account_name AS account_name, p_account_url AS account_url, p_account_timezone AS account_timezone, " +
                    "p_account_budget AS account_budget, f_mod_id AS mod_id " +
                "FROM pretenders " +
                "WHERE p_currency_code = '" + currency + "'";
    
        ArrayList<HashMap<String, String>> result = SQLModel.execute(query);
    
        if (result.size() > 0) {
            result.forEach(item -> {
                Pretender pretender = new Pretender();
                pretender.setEntId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("ent_id")) ? "0" : item.get("ent_id")));
                pretender.setCountryCode(item.get("country_code"));
                pretender.setCurrencyCode(item.get("currency_code"));
                pretender.setAccountName(item.get("account_name"));
                pretender.setAccountUrl(item.get("account_url"));
                pretender.setAccountTimezone(item.get("account_timezone"));
                pretender.setAccountBudget(Byte.parseByte(item.get("account_budget")));
                pretender.setModId(Integer.parseInt(StringUtils.isNullOrEmpty(item.get("mod_id")) ? "0" : item.get("mod_id")));
            
                pretenders.add(pretender);
            });
        }
    
        return pretenders;
    }
    
    @Override
    @SneakyThrows
    public List<Pretender> selectByModerator(int id) {
        List<Pretender> pretenders = new ArrayList<>();
    
        String query =
                "SELECT " +
                    "f_ent_id AS ent_id, p_country_code AS country_code, p_currency_code AS currency_code, " +
                    "p_account_name AS account_name, p_account_url AS account_url, p_account_timezone AS account_timezone, " +
                    "p_account_budget AS account_budget, f_mod_id AS mod_id " +
                "FROM pretenders " +
                "WHERE f_mod_id = " + id;
    
        ArrayList<HashMap<String, String>> result = SQLModel.execute(query);
    
        if (result.size() > 0) {
            result.forEach(item -> {
                Pretender pretender = new Pretender();
                pretender.setEntId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("ent_id")) ? "0" : item.get("ent_id")));
                pretender.setCountryCode(item.get("country_code"));
                pretender.setCurrencyCode(item.get("currency_code"));
                pretender.setAccountName(item.get("account_name"));
                pretender.setAccountUrl(item.get("account_url"));
                pretender.setAccountTimezone(item.get("account_timezone"));
                pretender.setAccountBudget(Byte.parseByte(item.get("account_budget")));
                pretender.setModId(Integer.parseInt(StringUtils.isNullOrEmpty(item.get("mod_id")) ? "0" : item.get("mod_id")));
            
                pretenders.add(pretender);
            });
        }
    
        return pretenders;
    }
}
