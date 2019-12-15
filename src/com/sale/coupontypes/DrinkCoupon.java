package com.sale.coupontypes;

import com.factory.*;
import com.factory.drink.Drink;
import com.sale.Coupon;
import com.sale.Sale;

public class DrinkCoupon extends Coupon {
    public DrinkCoupon() {
        super(CouponTypes.DRINK_COUPON.getCouponName(), CouponTypes.DRINK_COUPON.getCouponDescription());
    }

    @Override
    protected double calculateDiscount(Sale sale) {
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
        sale.addDiscountedItemIndex(sale.getItemsInSale().indexOf(drink));
        return drink;
    }
}