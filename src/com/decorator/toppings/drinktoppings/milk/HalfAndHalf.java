package com.decorator.toppings.drinktoppings.milk;

import com.decorator.toppings.drinktoppings.Milk;
import com.factory.Drink;

public class HalfAndHalf extends Milk {
    public HalfAndHalf(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return "Half and half";
    }

    @Override
    public double getCost() {
        return base.getCost() + 0.25;
    }

}
