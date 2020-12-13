package com.cbsystematics.homeworks.hw01.task2.database;

import lombok.SneakyThrows;

import java.sql.Connection;

public class MySQLConnectionSingleton {
    
    private static Connection instance;
    
    private MySQLConnectionSingleton() {
    
    }
    
    @SneakyThrows
    public static Connection getInstance() {
        if (MySQLConnectionSingleton.instance == null) {
            MySQLConnectionSingleton.instance = new DataSourceFactory().getMySQLDataSource().getConnection();
        }
        
        return MySQLConnectionSingleton.instance;
    }
}
