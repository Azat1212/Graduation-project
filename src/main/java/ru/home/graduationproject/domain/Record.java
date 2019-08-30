package ru.home.graduationproject.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Record {
    private int id;
    private String product;
    private int productAmount;
    private int carbohydratePerAmount;
    private double amountOfBreadUnit;
}
