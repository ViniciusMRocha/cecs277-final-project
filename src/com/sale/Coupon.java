package com.sale;

import com.factory.Product;

public abstract class Coupon {
    private String couponName;
    private String couponDescription;
    protected Product discountedItem;

    public Coupon(String couponName, String couponDescription) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
    }

    protected abstract double calculateDiscount(Sale sale);

    @Override
    public String toString() {
        return "Coupon name: " + couponName +
                "\nCoupon description: " + couponDescription;
    }
}
