package com.decorator.toppings.drinktoppings;

import com.factory.Drink;

public abstract class Milk extends Toppings {

    public Milk(Drink base) {
        super(base);
    }

    @Override
    public double getCost() {
        return return getBase().getCost() + 10.0;
    }
}
