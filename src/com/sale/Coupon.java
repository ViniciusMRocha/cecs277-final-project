package com.sale;

public abstract class Coupon {
    private String couponName;
    private String couponDescription;

    public Coupon(String couponName, String couponDescription) {
        this.couponName = couponName;
        this.couponDescription = couponDescription;
    }

    protected abstract double calculateDiscount(Sale sale);

    @Override
    public String toString() {
        return "Coupon:\n" +
                "\nCoupon name: " + couponName +
                "\nCoupon description: " + couponDescription +
                "\n\n";
    }
}
