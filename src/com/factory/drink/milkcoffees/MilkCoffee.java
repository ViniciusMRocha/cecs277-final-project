package com.factory.drink.milkcoffees;

import com.factory.drink.coffee.Coffee;

public abstract class MilkCoffee extends Coffee {

    /**
     * Creates a new Coffee object with the specified parameters.
     *
     * @param name     The name of the coffee
     * @param size     The size of the coffee
     * @param milkType The type of milk in the coffee
     * @param quantity The amount of coffee products to buy
     */
    public MilkCoffee(String name, Size size, Milk milkType, int quantity) {
        super(name, size, milkType, quantity);
    }
}