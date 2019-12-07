package com.decorator.toppings.drinktoppings.jellies;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.drink.Drink;

public class GrassJelly extends Toppings {
    public GrassJelly(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "grass jelly, ";
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
