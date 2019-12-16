package com.factory.drink.milkcoffees;

import com.factory.drink.coffee.Coffee;

public abstract class MilkCoffee extends Coffee {

    /**
     * Creates a new MilkCoffee object with the specified parameters.
     *
     * @param name      String
     * @param size      Size
     * @param milkType  Milk
     */
    public MilkCoffee(String name, Size size, Milk milkType) {
        super(name, size, milkType);
    }
}