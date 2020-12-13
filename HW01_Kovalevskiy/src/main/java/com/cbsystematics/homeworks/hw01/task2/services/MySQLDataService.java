package com.cbsystematics.homeworks.hw01.task2.services;

import com.cbsystematics.homeworks.hw01.task2.database.MySQLConnectionSingleton;
import com.cbsystematics.homeworks.hw01.task2.models.SQLModel;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

public class MySQLDataService {
    
    private static final Connection connection = MySQLConnectionSingleton.getInstance();
    
    @SneakyThrows
    public static void getAccountsActivity() {
        String query = "" +
                "SELECT f_u_ads_id AS ads_id, f_u_ent_id AS ent_id, f_c_ent_tld AS ent_tld, f_u_country_code AS country_code, " +
                "MAX(f_cas_campaign_last_active) AS last_active, MIN(f_cas_inactivity) AS inactivity, " +
                "SUM(f_cas_impressions) AS impressions, f_m_mod_login AS moderator, f_mt_package_name AS package, " +
                "COUNT(f_c_campaign_id) AS campaigns, f_c_ent_name AS ent_name " +
                "FROM campaigns_active_state_cache WHERE f_es_campaign_excluded = 0 GROUP BY f_u_ads_id " +
                "ORDER BY last_active DESC, impressions DESC LIMIT 10";
        
        ArrayList<Object[]> result = SQLModel.execute(query, MySQLDataService.connection);
        
        if (result.size() > 0) {
            result.forEach(item -> System.out.println(Arrays.deepToString(item)));
        } else {
            System.out.println("Empty data!");
        }
    }
    
    @SneakyThrows
    public static void getPretenders() {
        String query = "" +
                "SELECT f_ent_id AS ent_id, p_country_code AS country_code, p_currency_code AS currency_code, " +
                "p_account_name AS account_name, p_account_url AS account_url, p_status AS status, f_mod_id AS mod_id " +
                "FROM pretenders ORDER BY created_at DESC LIMIT 10";
        
        ArrayList<Object[]> result = SQLModel.execute(query, MySQLDataService.connection);
        
        if (result.size() > 0) {
            result.forEach(item -> System.out.println(Arrays.deepToString(item)));
        } else {
            System.out.println("Empty data!");
        }
    }
}
