package com.decorator.toppings.drinktoppings.jellies;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.drink.Drink;

public class CoconutJelly extends Toppings {
    public CoconutJelly(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
            return base.getDescription() + "coconut jelly, ";
    }

    @Override
    public String getName() {
        return base.getName();
    }

    @Override
    public double getCost() {
        return base.getCost() + 0.50;
    }
}
