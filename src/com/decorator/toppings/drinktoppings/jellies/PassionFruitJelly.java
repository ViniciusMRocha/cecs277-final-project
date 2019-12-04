package com.decorator.toppings.drinktoppings.jellies;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.Drink;

public class PassionFruitJelly extends Toppings {
    public PassionFruitJelly(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "passion fruit jelly, ";
    }

    @Override
    public double getCost() {
        return base.getCost() + 0.50;
    }
}
