package com.sale.coupontypes;

import com.factory.*;
import com.factory.drink.Drink;
import com.sale.Coupon;
import com.sale.Sale;

public class DrinkCoupon extends Coupon {
    public DrinkCoupon() {
        super("Drink coupon", "50% oﬀ highest priced drink for current purchase.");
    }

    @Override
    protected double calculateDiscount(Sale sale) {
        System.out.println("Items in sale: ");

        Drink drinkToSubsidize = getHighestPricedDrink(sale);
        if(drinkToSubsidize == null) return 0;
        return (drinkToSubsidize.getCost()) * 0.5;
    }

    private Drink getHighestPricedDrink(Sale sale) {
        Drink drink = null;
        double drinkPrice = 0.0;
        for(Product item : sale.getItemsInSale()) {
            if(item instanceof Drink) {
                if(item.getCost() > drinkPrice) {
                    drink = (Drink)item;
                    drinkPrice = item.getCost();
                }
            }
        }
        return drink;
    }
}