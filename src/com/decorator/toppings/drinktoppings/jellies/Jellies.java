package com.decorator.toppings.drinktoppings.jellies;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.factory.Drink;

public abstract class Jellies extends DrinkToppings {
    public Jellies(Drink base) {
        super(base);
    }
}
