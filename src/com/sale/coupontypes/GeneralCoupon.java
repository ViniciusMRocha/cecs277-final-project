package com.sale.coupontypes;

import com.factory.Product;
import com.sale.Coupon;
import com.sale.Sale;

/**
 * Created a general coupon
 */
public class GeneralCoupon extends Coupon {

    /**
     * Constructor that creates a GeneralCoupon object
     */
    public GeneralCoupon() {
        super(CouponTypes.GENERAL_COUPON.getCouponName(), CouponTypes.GENERAL_COUPON.getCouponDescription());
    }

    /**
     * Calculate the discount applied by the coupon
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