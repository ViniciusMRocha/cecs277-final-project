package com.sale;

import com.factory.Product;

/**
 * Creates a abstract class for the implementation of different coupons
 */
public abstract class Coupon {
    private String couponName;
    private String couponDescription;
    protected Product discountedItem;

    /**
     * Creates a individual coupon by passing a coupon name and a description
     * @param couponName String
     * @param couponDescription String
     */
    public Coupon(String couponName, String couponDescription) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
    }

    /**
     * Method to calculate the discount applied by the coupon
     * @param sale Sale
     * @return double
     */
    protected abstract double calculateDiscount(Sale sale);

    /**
     * Prints out the coupon name and description
     * @return String
     */
    @Override
    public String toString() {
        return "Coupon name: " + couponName +
                "\nCoupon description: " + couponDescription;
    }
}
