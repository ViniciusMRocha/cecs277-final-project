package com.decorator.toppings.drinktoppings.jellies;

import com.factory.Drink;

public class GrassJelly extends Jellies {
    public GrassJelly(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return null;
    }

    @Override
    public double getCost() {
        return 0.50;
    }
}
