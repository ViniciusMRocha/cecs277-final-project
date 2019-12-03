package com.decorator.toppings.drinktoppings.jellies;

import com.factory.Drink;

public class CoconutJelly extends Jellies {
    public CoconutJelly(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getCost() {
        return 0;
    }
}
