package com.cbsystematics.homeworks.hw01.task2.services;

import com.cbsystematics.homeworks.hw01.task2.database.PgSQLConnectionSingleton;
import com.cbsystematics.homeworks.hw01.task2.models.SQLModel;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.Arrays;

public class PgSQLDataService {
    
    private static final Connection connection = PgSQLConnectionSingleton.getInstance();
    
    @SneakyThrows
    public static void getAccountsActivity() {
        String query = "" +
                "SELECT f_u_ads_id AS ads_id, f_u_ent_id AS ent_id, f_c_ent_tld AS ent_tld, f_u_country_code AS country_code, " +
                "f_cas_campaign_last_active AS last_active, f_cas_inactivity AS inactivity, " +
                "f_cas_impressions AS impressions, f_m_mod_login AS moderator, f_mt_package_name AS package, " +
                "f_c_campaign_id AS campaigns, f_c_ent_name AS ent_name FROM campaigns_active_state_cache " +
                "WHERE f_es_campaign_excluded = 0 ORDER BY last_active DESC, impressions DESC LIMIT 10";
    
        ArrayList<Object[]> result = SQLModel.execute(query, PgSQLDataService.connection);
    
        if (result.size() > 0) {
            result.forEach(item -> System.out.println(Arrays.deepToString(item)));
        }
    }
}
