package com.cbsystematics.homeworks.hw01.task3.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
public class Pretender extends Entity {
    
    private Long entId;
    private String countryCode;
    private String currencyCode;
    private String accountName;
    private String accountUrl;
    private String accountTimezone;
    private int accountBudget;
    private int modId;
    private String updatedAt;
    
}
