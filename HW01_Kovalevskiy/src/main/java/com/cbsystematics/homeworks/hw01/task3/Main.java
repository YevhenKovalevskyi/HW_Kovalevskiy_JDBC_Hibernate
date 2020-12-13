package com.cbsystematics.homeworks.hw01.task3;

import com.cbsystematics.homeworks.hw01.task3.entity.Pretender;
import com.cbsystematics.homeworks.hw01.task3.entity.User;
import com.cbsystematics.homeworks.hw01.task3.services.PretenderService;
import com.cbsystematics.homeworks.hw01.task3.services.UserService;

import java.util.List;

public class Main {
    
    public static void main(String[] args) {
        List<User> usersByCountry = UserService.getUsersByCountry("KZ");
    
        if (usersByCountry.size() > 0) {
            System.out.println("\n-- KZ --");
            usersByCountry.forEach(System.out::println);
        } else {
            System.out.println("No data!");
        }
    
        List<Pretender> pretendersByCountry = PretenderService.getPretendersByCountry("KZ");
    
        if (pretendersByCountry.size() > 0) {
            System.out.println("\n-- KZ --");
            pretendersByCountry.forEach(System.out::println);
        } else {
            System.out.println("No data!");
        }
    
        User user = UserService.getUser(2867801378L);
    
        if (user != null) {
            System.out.println("\n-- 2867801378L --");
            System.out.println(user);
        } else {
            System.out.println("No data!");
        }
    
        List<User> usersByModerator = UserService.getUsersByModerator(443);
    
        if (usersByModerator.size() > 0) {
            System.out.println("\n-- 443 --");
            usersByModerator.forEach(System.out::println);
        } else {
            System.out.println("No data!");
        }
    }
}
