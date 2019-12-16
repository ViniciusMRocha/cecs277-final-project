package com.sale;

import com.factory.Product;
/**
 * a Coupon is a abstract representation of a coupon with the implementations
 */
public abstract class Coupon {
    private String couponName;
    private String couponDescription;
    protected Product discountedItem;

    /**
     * Created a Coupon object
     * @param couponName String
     * @param couponDescription String
     */
    public Coupon(String couponName, String couponDescription) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
    }

    protected abstract double calculateDiscount(Sale sale);

    /**
     * Prints out the coupon information
     * @return String
     */
    @Override
    public String toString() {
        return "Coupon name: " + couponName +
                "\nCoupon description: " + couponDescription;
    }
}
