package com.sale.coupontypes;

import com.factory.Product;
import com.sale.Coupon;
import com.sale.Sale;

/**
 * GeneralCoupon creates coupons that can be applied to the sale in general in a customer's order
 */
public class GeneralCoupon extends Coupon {
    /**
     * Creates a general coupon
     */
    public GeneralCoupon() {
        super(CouponTypes.GENERAL_COUPON.getCouponName(), CouponTypes.GENERAL_COUPON.getCouponDescription());
    }

    /**
     * Calculates the discount that is going to be applied to the item
     * @param sale Sale
     * @return double
     */
    @Override
    protected double calculateDiscount(Sale sale) {
        double totalCostWithoutCoupon = 0.0;

        for(Product item : sale.getItemsInSale())
            totalCostWithoutCoupon += item.getCost();

        return ((totalCostWithoutCoupon >= 10) ? 2.0 : 0.0);
    }
}