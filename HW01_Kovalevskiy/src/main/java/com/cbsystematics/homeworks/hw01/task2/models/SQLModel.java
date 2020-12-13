package com.cbsystematics.homeworks.hw01.task2.models;

import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class SQLModel {
    
    /*
       For Insert, Update, Delete
    */
    @SneakyThrows
    public static int executeUpdate(String query, Connection connection) {
        Statement statement = connection.createStatement();
        
        return statement.executeUpdate(query);
    }
    
    /*
       For Select
    */
    @SneakyThrows
    public static ArrayList<Object[]> execute(String query, Connection connection) {
        ArrayList<Object[]> result = new ArrayList<>();
        
        try (
                Statement stmt = connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            int columnCount = rs.getMetaData().getColumnCount();
            
            while (rs.next()) {
                Object[] values = new Object[columnCount];
                
                for (int i = 1; i <= columnCount; i++) {
                    values[i - 1] = rs.getObject(i);
                }
    
                result.add(values);
            }
        }
        
        return result;
    }
}
