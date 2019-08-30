package ru.home.graduationproject.core;

public enum BreadUnitSystem {
    RUS(10),
    EUR(12);


    public int getBreadUnit() {
        return breadUnit;
    }

    private int breadUnit;

    BreadUnitSystem(int breadUnit) {
        this.breadUnit = breadUnit;
    }
}
