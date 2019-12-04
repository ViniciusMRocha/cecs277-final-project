package com.decorator.toppings.drinktoppings.jellies;

import com.factory.Drink;

public class PassionFruitJelly extends Jellies {
    public PassionFruitJelly(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getCost() {
        return return getBase().getCost() + 0.50;
    }
}
