package com.cbsystematics.homeworks.hw01.task3.dao.impl;

import com.cbsystematics.homeworks.hw01.task3.dao.UserDAO;
import com.cbsystematics.homeworks.hw01.task3.entity.User;
import com.cbsystematics.homeworks.hw01.task3.models.SQLModel;
import com.mysql.cj.util.StringUtils;
import lombok.SneakyThrows;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UserDAOImpl implements UserDAO {
    
    @Override
    @SneakyThrows
    public User insert(User user) {
        return null;
    }
    
    @Override
    @SneakyThrows
    public User update(User user) {
        return null;
    }
    
    @Override
    @SneakyThrows
    public boolean delete(User user) {
        return true;
    }
    
    @Override
    @SneakyThrows
    public boolean delete(Long id) {
        return true;
    }
    
    @Override
    @SneakyThrows
    public List<User> selectAll() {
        return null;
    }
    
    @Override
    @SneakyThrows
    public User selectOne(Long id) {
        User user = null;
    
        String query =
                "SELECT " +
                    "u_ads_id AS ads_id, u_merchant_id AS merchant_id, f_ent_id AS ent_id, f_country_code AS country_code, " +
                    "u_budget AS budget, u_is_active AS is_active, u_is_new AS is_new, u_is_acceptable AS is_acceptable, " +
                    "u_is_done AS is_done, f_mod_id AS mod_id " +
                "FROM users " +
                "WHERE u_ads_id = " + id;
    
        ArrayList<HashMap<String, String>> result = SQLModel.execute(query);
    
        if (result.size() > 0) {
            HashMap<String, String> item = result.get(0);
            
            user = new User();
            user.setAdsId(Long.parseLong(item.get("ads_id")));
            user.setMerchantId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("merchant_id")) ? "0" : item.get("merchant_id")));
            user.setEntId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("ent_id")) ? "0" : item.get("ent_id")));
            user.setCountryCode(item.get("country_code"));
            user.setBudget(Byte.parseByte(item.get("budget")));
            user.setIsActive(Byte.parseByte(item.get("is_active")));
            user.setIsNew(Byte.parseByte(item.get("is_new")));
            user.setIsAcceptable(Byte.parseByte(item.get("is_acceptable")));
            user.setIsDone(Byte.parseByte(item.get("is_done")));
            user.setModId(Integer.parseInt(StringUtils.isNullOrEmpty(item.get("mod_id")) ? "0" : item.get("mod_id")));
        }
    
        return user;
    }
    
    @Override
    @SneakyThrows
    public User selectByEnterprise(Long id) {
        User user = null;
    
        String query =
                "SELECT " +
                    "u_ads_id AS ads_id, u_merchant_id AS merchant_id, f_ent_id AS ent_id, f_country_code AS country_code, " +
                    "u_budget AS budget, u_is_active AS is_active, u_is_new AS is_new, u_is_acceptable AS is_acceptable, " +
                    "u_is_done AS is_done, f_mod_id AS mod_id " +
                "FROM users " +
                "WHERE f_ent_id = " + id;
    
        ArrayList<HashMap<String, String>> result = SQLModel.execute(query);
    
        if (result.size() > 0) {
            HashMap<String, String> item = result.get(0);
            
            user = new User();
            user.setAdsId(Long.parseLong(item.get("ads_id")));
            user.setMerchantId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("merchant_id")) ? "0" : item.get("merchant_id")));
            user.setEntId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("ent_id")) ? "0" : item.get("ent_id")));
            user.setCountryCode(item.get("country_code"));
            user.setBudget(Byte.parseByte(item.get("budget")));
            user.setIsActive(Byte.parseByte(item.get("is_active")));
            user.setIsNew(Byte.parseByte(item.get("is_new")));
            user.setIsAcceptable(Byte.parseByte(item.get("is_acceptable")));
            user.setIsDone(Byte.parseByte(item.get("is_done")));
            user.setModId(Integer.parseInt(StringUtils.isNullOrEmpty(item.get("mod_id")) ? "0" : item.get("mod_id")));
        }
    
        return user;
    }
    
    @Override
    @SneakyThrows
    public List<User> selectByCountry(String country) {
        List<User> users = new ArrayList<>();
    
        String query =
                "SELECT " +
                    "u_ads_id AS ads_id, u_merchant_id AS merchant_id, f_ent_id AS ent_id, f_country_code AS country_code, " +
                    "u_budget AS budget, u_is_active AS is_active, u_is_new AS is_new, u_is_acceptable AS is_acceptable, " +
                    "u_is_done AS is_done, f_mod_id AS mod_id " +
                "FROM users " +
                "WHERE f_country_code = '" + country + "' ";
    
        ArrayList<HashMap<String, String>> result = SQLModel.execute(query);
    
        if (result.size() > 0) {
            result.forEach(item -> {
                User user = new User();
                user.setAdsId(Long.parseLong(item.get("ads_id")));
                user.setMerchantId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("merchant_id")) ? "0" : item.get("merchant_id")));
                user.setEntId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("ent_id")) ? "0" : item.get("ent_id")));
                user.setCountryCode(item.get("country_code"));
                user.setBudget(Byte.parseByte(item.get("budget")));
                user.setIsActive(Byte.parseByte(item.get("is_active")));
                user.setIsNew(Byte.parseByte(item.get("is_new")));
                user.setIsAcceptable(Byte.parseByte(item.get("is_acceptable")));
                user.setIsDone(Byte.parseByte(item.get("is_done")));
                user.setModId(Integer.parseInt(StringUtils.isNullOrEmpty(item.get("mod_id")) ? "0" : item.get("mod_id")));
    
                users.add(user);
            });
        }
    
        return users;
    }
    
    @Override
    @SneakyThrows
    public List<User> selectByModerator(int id) {
        List<User> users = new ArrayList<>();
    
        String query =
                "SELECT " +
                    "u_ads_id AS ads_id, u_merchant_id AS merchant_id, f_ent_id AS ent_id, f_country_code AS country_code, " +
                    "u_budget AS budget, u_is_active AS is_active, u_is_new AS is_new, u_is_acceptable AS is_acceptable, " +
                    "u_is_done AS is_done, f_mod_id AS mod_id " +
                "FROM users " +
                "WHERE f_mod_id = " + id;
    
        ArrayList<HashMap<String, String>> result = SQLModel.execute(query);
    
        if (result.size() > 0) {
            result.forEach(item -> {
                User user = new User();
                user.setAdsId(Long.parseLong(item.get("ads_id")));
                user.setMerchantId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("merchant_id")) ? "0" : item.get("merchant_id")));
                user.setEntId(Long.parseLong(StringUtils.isNullOrEmpty(item.get("ent_id")) ? "0" : item.get("ent_id")));
                user.setCountryCode(item.get("country_code"));
                user.setBudget(Byte.parseByte(item.get("budget")));
                user.setIsActive(Byte.parseByte(item.get("is_active")));
                user.setIsNew(Byte.parseByte(item.get("is_new")));
                user.setIsAcceptable(Byte.parseByte(item.get("is_acceptable")));
                user.setIsDone(Byte.parseByte(item.get("is_done")));
                user.setModId(Integer.parseInt(StringUtils.isNullOrEmpty(item.get("mod_id")) ? "0" : item.get("mod_id")));
            
                users.add(user);
            });
        }
    
        return users;
    }
}
