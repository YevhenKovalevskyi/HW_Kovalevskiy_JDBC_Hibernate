package com.cbsystematics.homeworks.hw01.task3.models;

import com.cbsystematics.homeworks.hw01.task3.database.MySQLConnectionSingleton;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;

public class SQLModel {
    
    private static final Connection connection = MySQLConnectionSingleton.getInstance();
    
    /*
       For Insert, Update, Delete
    */
    @SneakyThrows
    public static int executeUpdate(String query) {
        Statement statement = SQLModel.connection.createStatement();
        
        return statement.executeUpdate(query);
    }
    
    /*
       For Select
    */
    @SneakyThrows
    public static ArrayList<HashMap<String, String>> execute(String query) {
        ArrayList<HashMap<String, String>> result = new ArrayList<>();
    
        try (
                Statement stmt = SQLModel.connection.createStatement();
                ResultSet rs = stmt.executeQuery(query)
        ) {
            ResultSetMetaData md = rs.getMetaData();
            int columnCount = md.getColumnCount();
        
            while (rs.next()) {
                HashMap<String, String> items = new HashMap<>(columnCount);
            
                for (int i = 1; i <= columnCount; i++) {
                    items.put(md.getColumnLabel(i), rs.getString(i));
                }
            
                result.add(items);
            }
        }
    
        return result;
    }
}
