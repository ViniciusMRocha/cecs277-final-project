package com.decorator.toppings.drinktoppings;

import com.factory.drink.Drink;

public class Strawberries extends Toppings {
    public Strawberries(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return base.getDescription() + "strawberries, ";
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
