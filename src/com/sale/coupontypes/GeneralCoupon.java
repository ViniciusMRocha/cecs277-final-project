package com.sale.coupontypes;

import com.factory.Product;
import com.sale.Coupon;
import com.sale.Sale;

public class GeneralCoupon extends Coupon {

    public GeneralCoupon() {
        super("General coupon", "$2 oﬀ a total purchase of at least $10.");
    }

    @Override
    protected double calculateDiscount(Sale sale) {
        double totalCostWithoutCoupon = 0.0;

        for(Product item : sale.getItemsInSale())
            totalCostWithoutCoupon += item.getCost();

        return ((totalCostWithoutCoupon >= 10) ? 2.0 : 0.0);
    }
}