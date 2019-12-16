package com.sale.coupontypes;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.sale.Coupon;

/**
 * Describes the different types of coupon available for purchase at "Cha-cha-cha Time!"
 */
public enum CouponTypes {
    DRINK_COUPON("Drink coupon", "50% oﬀ highest priced drink in current purchase."),
    GENERAL_COUPON("General coupon", "$2 oﬀ a total purchase of at least $10."),
    PASTRY_COUPON("Pastry coupon", "$1 oﬀ a cookie purchase.");

    private String couponName;
    private String couponDescription;

    /**
     * Creates a coupon type
     * @param couponName String
     * @param couponDescription String
     */
    CouponTypes(String couponName, String couponDescription) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
    }

    /**
     * Gest the coupon name
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
     * Gets enum value from passed string
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
     * Gets coupon from a passed enum value
     * @param couponValue CouponTypes
     * @return Coupon
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
