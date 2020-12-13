package com.cbsystematics.homeworks.hw01.task2;

import com.cbsystematics.homeworks.hw01.task2.services.MySQLDataService;
import com.cbsystematics.homeworks.hw01.task2.services.PgSQLDataService;

public class Main {
    
    public static void main(String[] args) {
        System.out.println("\n-- MySQL --");
        MySQLDataService.getAccountsActivity();
        System.out.println("\n-- проверка работы синглтона --");
        MySQLDataService.getPretenders();
        
        System.out.println("\n-- PgSQL --");
        PgSQLDataService.getAccountsActivity();
    }
}
