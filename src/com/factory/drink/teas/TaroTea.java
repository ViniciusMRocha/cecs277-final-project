package com.factory.drink.teas;

import com.factory.Product;

public class TaroTea extends Tea implements Product {
    /**
     * Initializes a new Tea object with the specified parameters.
     *
     * @param name      The name of the tea
     * @param size      The size of the tea
     * @param sweetness The sweetness of the tea
     * @param milkType  The type of milk in the tea
     * @param quantity The quantity purchased
     */
    public TaroTea(String name, Size size, Sweetness sweetness, Milk milkType, int quantity) {
        super(name, size, sweetness, milkType, quantity);
        description = "taro tea";
    }

    @Override
    public double getCost() {
        switch (size) {
            case SMALL:
                return 2.25;
            case MEDIUM:
                return 2.75;
            case LARGE:
                return 3.25;
        }
        return 0.0;
    }
}
