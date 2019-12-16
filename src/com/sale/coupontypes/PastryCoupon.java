package com.sale.coupontypes;

import com.factory.pastry.cookies.Cookie;
import com.factory.Product;
import com.sale.Coupon;
import com.sale.Sale;

/**
 * Created a pastry coupon
 */
public class PastryCoupon extends Coupon {

    /**
     * Constructor that creates a GeneralCoupon object
     */
    public PastryCoupon() {
        super(CouponTypes.PASTRY_COUPON.getCouponName(), CouponTypes.PASTRY_COUPON.getCouponDescription());
    }

    /**
     * Calculate the discount applied by the coupon
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