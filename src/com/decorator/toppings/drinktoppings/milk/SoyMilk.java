package com.decorator.toppings.drinktoppings.milk;

import com.decorator.toppings.drinktoppings.Milk;
import com.factory.Drink;

public class SoyMilk extends Milk {
    public SoyMilk(Drink base) {
        super(base);
    }

    @Override
    public String getDescription() {
        return "Soy milk!";
    }

    @Override
    public double getCost() {
        return return getBase().getCost() + 0.50;
    }
}
