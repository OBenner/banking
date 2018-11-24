package ru.neoflex.banking.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    private String userName;
    private String accCode;
    private double amount;
    private String accountNumber;
}
