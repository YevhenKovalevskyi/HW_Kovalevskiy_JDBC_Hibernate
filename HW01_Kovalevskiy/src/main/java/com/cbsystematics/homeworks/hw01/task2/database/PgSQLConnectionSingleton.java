package com.cbsystematics.homeworks.hw01.task2.database;

import lombok.SneakyThrows;

import java.sql.Connection;

public class PgSQLConnectionSingleton {
    
    private static Connection instance;
    
    private PgSQLConnectionSingleton() {
    
    }
    
    @SneakyThrows
    public static Connection getInstance() {
        if (PgSQLConnectionSingleton.instance == null) {
            PgSQLConnectionSingleton.instance = new DataSourceFactory().getPgSQLDataSource().getConnection();
        }
        
        return PgSQLConnectionSingleton.instance;
    }
}
