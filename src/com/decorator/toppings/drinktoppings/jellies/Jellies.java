package com.decorator.toppings.drinktoppings.jellies;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.Drink;

public abstract class Jellies extends Toppings {
    public Jellies(Drink base) {
        super(base);
    }
}
