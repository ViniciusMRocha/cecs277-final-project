package com.sale.coupontypes;

import com.factory.pastry.cookies.Cookie;
import com.factory.Product;
import com.sale.Coupon;
import com.sale.Sale;


/**
 * PastryCoupon creates coupons that can be applied to parties in a customer's order
 */
public class PastryCoupon extends Coupon {

    /**
     * Creates a pastry coupon
     */
    public PastryCoupon() {
        super(CouponTypes.PASTRY_COUPON.getCouponName(), CouponTypes.PASTRY_COUPON.getCouponDescription());
    }

    /**
     * Calculates the discount that is going to be applied to the item
     * @param sale Sale
     * @return double
     */
    @Override
    protected double calculateDiscount(Sale sale) {

        for(Product item : sale.getItemsInSale()) {
            if (item instanceof Cookie) {
                sale.addDiscountedItemIndex(sale.getItemsInSale().indexOf(item));
                return 1.0;
            }
        }
        return 0.0;
    }
}