package com.factory;

/**
 * A Cookie is a type of pastry.
 */
public class Cookie extends Pastry {

    Cookie(String name, int quantity) {
        this.name = name;
        description = "A mouth-watering treat!";
        this.quantity = quantity;
    }

    /**
     * How many sets-of-three cookies have been purchased.
     *
     * @return the many sets of three purchased.
     */
    private int setsOfThreePurchased(int quantity) {
        return (int) (Math.floor(quantity / 3));
    }

    public double getCost() {
        double originalPrice = 1.50;
        double specialPrice = 1.00;

        if (quantity < 3) return (quantity * originalPrice);
        int cookiesInSetsOfThree = setsOfThreePurchased(quantity) * 3;
        int remainingCookies = quantity % (cookiesInSetsOfThree);
        return (remainingCookies * originalPrice) + (cookiesInSetsOfThree * specialPrice);
    }
}
