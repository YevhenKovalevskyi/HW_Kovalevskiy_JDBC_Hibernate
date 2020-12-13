package com.cbsystematics.homeworks.hw01.task3.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class User extends Entity {
    
    private Long adsId;
    private Long merchantId;
    private Long entId;
    private String countryCode;
    private int budget;
    private byte isActive;
    private byte isNew;
    private byte isAcceptable;
    private byte isDone;
    private int modId;
    private String updatedAt;
    
}
