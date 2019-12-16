package com.sale.coupontypes;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.sale.Coupon;

/**
 * Describes the different types of coupons available to be used at "Cha-cha-cha Time!"
 */
public enum CouponTypes {
    DRINK_COUPON("Drink coupon", "50% oﬀ highest priced drink in current purchase."),
    GENERAL_COUPON("General coupon", "$2 oﬀ a total purchase of at least $10."),
    PASTRY_COUPON("Pastry coupon", "$1 oﬀ a cookie purchase.");

    private String couponName;
    private String couponDescription;

    /**
     * Creates a coupon
     * @param couponName String
     * @param couponDescription String
     */
    CouponTypes(String couponName, String couponDescription) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
    }

    /**
     * Gets the coupon name
     * @return String
     */
    public String getCouponName() {
        return couponName;
    }

    /**
     * Gets the coupon description
     * @return String
     */
    public String getCouponDescription() {
        return couponDescription;
    }

    /**
     * Prints out the coupon name
     * @return String
     */
    @Override
    public String toString() {
        return couponName;
    }

    /**
     * Gets the enum value from a string
     * @param text String
     * @return CouponTypes
     */
    public static CouponTypes getEnumValueFromString(String text) {
        for (CouponTypes coupon : CouponTypes.values()) {
            if (coupon.couponName.equalsIgnoreCase(text))
                return coupon;
        }
        return null;
    }

    /**
     * Gets the coupon from the enum value
     * @param couponValue CouponTypes
     * @return CouponTypes
     */
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
