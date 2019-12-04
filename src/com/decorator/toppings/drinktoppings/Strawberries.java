package com.decorator.toppings.drinktoppings;

import com.factory.Drink;

public class Strawberries extends Toppings {
    public Strawberries(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return "Strawberries";
    }

    @Override
    public double getCost() {
        return base.getCost() + 6;
    }
}
