package com.sale.coupontypes;

import com.factory.*;
import com.factory.drink.Drink;
import com.sale.Coupon;
import com.sale.Sale;

/**
 * DrinkCoupon creates coupons that can be applied to drinks in a customer's order
 */
public class DrinkCoupon extends Coupon {
    /**
     * Creates a drink coupon
     */
    public DrinkCoupon() {
        super(CouponTypes.DRINK_COUPON.getCouponName(), CouponTypes.DRINK_COUPON.getCouponDescription());
    }

    /**
     * Calculates the discount that is going to be applied to the item
     * @param sale Sale
     * @return double
     */
    @Override
    protected double calculateDiscount(Sale sale) {
        Drink drinkToSubsidize = getHighestPricedDrink(sale);
        if(drinkToSubsidize == null) return 0;
        return (drinkToSubsidize.getCost()) * 0.5;
    }

    /**
     * Gets the highest priced drink and applies the discount to that item.
     * @param sale Sale
     * @return Drink
     */
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