package com.decorator.toppings.drinktoppings;

import com.factory.drink.Drink;

public class PoppingBoba extends Toppings {
    public PoppingBoba(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "popping boba, ";
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