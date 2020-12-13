package com.cbsystematics.homeworks.hw01.task2.database;

import javax.sql.DataSource;

public interface DataSourceInterface {
    
    DataSource getMySQLDataSource();
    
    DataSource getPgSQLDataSource();
}
