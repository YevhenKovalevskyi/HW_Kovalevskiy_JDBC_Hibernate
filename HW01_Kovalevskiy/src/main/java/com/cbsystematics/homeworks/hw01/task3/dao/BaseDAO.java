package com.cbsystematics.homeworks.hw01.task3.dao;

import com.cbsystematics.homeworks.hw01.task3.entity.Entity;
import lombok.SneakyThrows;

import java.sql.Connection;
import java.sql.Statement;
import java.util.List;

public interface BaseDAO<K, T extends Entity> {
    
    T insert(T t);
    T update(T t);
    boolean delete(T t);
    boolean delete(K id);
    List<T> selectAll();
    T selectOne(K id);
    
    @SneakyThrows
    default void close(Statement statement) {
        if (statement != null) {
            statement.close();
        }
    }
    
    @SneakyThrows
    default void close(Connection connection) {
        if (connection != null) {
            connection.close();
        }
    }
}
