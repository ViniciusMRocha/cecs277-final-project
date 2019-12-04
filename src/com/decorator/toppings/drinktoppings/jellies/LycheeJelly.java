package com.decorator.toppings.drinktoppings.jellies;

import com.factory.Drink;

public class LycheeJelly extends Jellies {
    public LycheeJelly(Drink base) {
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
