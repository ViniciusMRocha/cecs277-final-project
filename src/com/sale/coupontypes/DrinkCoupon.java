package com.sale.coupontypes;

import com.factory.Drink;
import com.factory.Product;
import com.sale.Coupon;
import com.sale.Sale;

public class DrinkCoupon extends Coupon {
    public DrinkCoupon() {
        super("Drink coupon", "50% oﬀ highest priced drink for current purchase.");
    }

    @Override
    protected double calculateDiscount(Sale sale) {
        Drink drinkToSubsidize = getHighestPricedDrink(sale);
        discountedItem = drinkToSubsidize;
        if(drinkToSubsidize == null) return 0;
        return (drinkToSubsidize.getCost()) * 0.5;
    }

    private Drink getHighestPricedDrink(Sale sale) {
        Drink drink = null;
        for(Product item : sale.getItemsInSale()) {
            if(item instanceof Drink) {
                if(drink == null)
                    drink = (Drink)item;
                else {
                    if(item.getCost() > drink.getCost())
                        drink = (Drink)item;
                }
            }
        }
        return drink;
    }
}