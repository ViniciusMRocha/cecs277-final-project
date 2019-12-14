package com.sale.coupontypes;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.sale.Coupon;

public enum CouponTypes {
    DRINK_COUPON("Drink coupon", "50% oﬀ highest priced drink in current purchase."),
    GENERAL_COUPON("General coupon", "$2 oﬀ a total purchase of at least $10."),
    PASTRY_COUPON("Pastry coupon", "$1 oﬀ a cookie purchase.");

    private String couponName;
    private String couponDescription;

    CouponTypes(String couponName, String couponDescription) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
    }

    public String getCouponName() {
        return couponName;
    }

    public String getCouponDescription() {
        return couponDescription;
    }

    @Override
    public String toString() {
        return couponName;
    }

    public static CouponTypes getEnumValueFromString(String text) {
        for (CouponTypes coupon : CouponTypes.values()) {
            if (coupon.couponName.equalsIgnoreCase(text))
                return coupon;
        }
        return null;
    }

    public static Coupon getCouponFromEnumValue(CouponTypes couponValue) {
        switch (couponValue) {
            case DRINK_COUPON:
                return new DrinkCoupon();

            case GENERAL_COUPON:
                return new GeneralCoupon();

            case PASTRY_COUPON:
                return new PastryCoupon();
        }
        return null;
    }
}
