package com.factory.pastry.croissants;

import com.factory.Product;

/**
 * A StrawberryCroissant is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
 */
public class StrawberryCroissant extends Croissant implements Product {
    /**
     *  * A StrawberryCroissant is a type of pastry, which is a type of product available for purchase at "Cha-cha-cha Time!"
     * @param name
     * @param quantity
     * @param heatState
     */
    public StrawberryCroissant(String name, int quantity, HeatState heatState) {
        super(name, quantity, heatState);
        description = "strawberry";
    }

    @Override
    public double getCost() {
        double pastryCost = super.getCost();
        pastryCost += 3.25 * quantity;
        return pastryCost;
    }
}
