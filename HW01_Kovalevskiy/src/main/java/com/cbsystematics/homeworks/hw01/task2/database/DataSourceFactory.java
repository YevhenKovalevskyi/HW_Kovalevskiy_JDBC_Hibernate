package com.cbsystematics.homeworks.hw01.task2.database;

import com.cbsystematics.homeworks.hw01.task2.helpers.FilesHelper;
import lombok.SneakyThrows;

import com.mysql.cj.jdbc.MysqlDataSource;
import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.util.Properties;

public class DataSourceFactory implements DataSourceInterface {
    
    @SneakyThrows
    public DataSource getMySQLDataSource() {
        Properties props = new Properties();
        MysqlDataSource mysqlDS;
        
        String filePath = FilesHelper.getResourceRootFilePathGradle(
                DataSourceFactory.class, "DataSourceFactory.class", "jdbc.properties"
        );

        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
            
            mysqlDS = new MysqlDataSource();
            mysqlDS.setURL(props.getProperty("jdbc.mysql.url"));
            mysqlDS.setUser(props.getProperty("jdbc.mysql.user"));
            mysqlDS.setPassword(props.getProperty("jdbc.mysql.password"));
            mysqlDS.setServerTimezone("UTC");
        }

        return mysqlDS;
    }
    
    @SneakyThrows
    public DataSource getPgSQLDataSource() {
        Properties props = new Properties();
        PGSimpleDataSource pgsqlDS;
    
        String filePath = FilesHelper.getResourceRootFilePathGradle(
                DataSourceFactory.class, "DataSourceFactory.class", "jdbc.properties"
        );
        
        try (FileInputStream fis = new FileInputStream(filePath)) {
            props.load(fis);
    
            pgsqlDS = new PGSimpleDataSource();
            pgsqlDS.setUrl(props.getProperty("jdbc.pgsql.url"));
            pgsqlDS.setUser(props.getProperty("jdbc.pgsql.user"));
            pgsqlDS.setPassword(props.getProperty("jdbc.pgsql.password"));
        }
        
        return pgsqlDS;
    }
}
