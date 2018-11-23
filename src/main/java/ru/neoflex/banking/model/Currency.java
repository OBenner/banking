package ru.neoflex.banking.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Currency {

    private String сode;
    private long nominal;
    private String name;
    private double value;






}
