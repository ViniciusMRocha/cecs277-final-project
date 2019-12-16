package com.sale.coupontypes;

import com.factory.*;
import com.factory.drink.Drink;
import com.sale.Coupon;
import com.sale.Sale;

/**
 * Created a drink coupon
 */
public class DrinkCoupon extends Coupon {
    /**
     * Constructor that creates a DrinkCoupon object
     */
    public DrinkCoupon() {
        super(CouponTypes.DRINK_COUPON.getCouponName(), CouponTypes.DRINK_COUPON.getCouponDescription());
    }

    /**
     * Calculate the discount applied by the coupon
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
     * Gets the highers priced drink to apply the coupon
     * @param sale Sale
     * @return Drink
     */
    private Drink getHighestPricedDrink(Sale sale) {
        Drink drink = null;
        double drinkPrice = 0.0;
        for(Product item : sale.getItemsInSale()) {
            System.out.println("item : " + item);
            if(item instanceof Drink) {
                if(item.getCost() > drinkPrice) {
                    drink = (Drink)item;
                    drinkPrice = item.getCost();
                }
            }
        }
        System.out.println("most expensive drink: " + drink);
        sale.addDiscountedItemIndex(sale.getItemsInSale().indexOf(drink));
        return drink;
    }
}