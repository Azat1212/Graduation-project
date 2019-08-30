package ru.home.graduationproject.core;

import javax.validation.constraints.NotNull;

public class СarbohydrateCalculator implements Сalculator {

    private int productAmount;
    private int carbohydratePerAmount;
    private BreadUnitSystem breadUnitSystem;
    private double usersСoefficient;

    public СarbohydrateCalculator(int productAmount, int carbohydratePerAmount) {
        this(productAmount, carbohydratePerAmount, BreadUnitSystem.RUS, 1.0);
    }

    public СarbohydrateCalculator(int productAmount, int carbohydratePerAmount, @NotNull BreadUnitSystem breadUnitSystem) {
        this(productAmount, carbohydratePerAmount, breadUnitSystem, 1.0);
    }

    public СarbohydrateCalculator(int productAmount, int carbohydratePerAmount, BreadUnitSystem breadUnitSystem, double usersСoefficient) {
        this.productAmount = productAmount;
        this.carbohydratePerAmount = carbohydratePerAmount;
        this.breadUnitSystem = breadUnitSystem;
        this.usersСoefficient = usersСoefficient;
    }

    @Override
    public double calculate() {
        return ((productAmount/100.0)*carbohydratePerAmount*usersСoefficient)/breadUnitSystem.getBreadUnit();
    }
}
