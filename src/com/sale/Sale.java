package com.sale;

import com.factory.Product;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> itemsInSale;
    private double totalPrice;
    private ArrayList<Coupon> coupons;

    public Sale(ArrayList<Product> itemsInSale, ArrayList<Coupon> coupons) {
        this.itemsInSale = itemsInSale;
        this.coupons = coupons;
        totalPrice = calculateTotalCost();
    }

    private double calculateTotalCost() {
        double cost = 0.0;
        for(Product product : itemsInSale)
            cost += product.getCost();

        for(Coupon coupon : coupons)
            cost -= coupon.calculateDiscount(this);
        return cost;
    }

    public ArrayList<Product> getItemsInSale() {
        return itemsInSale;
    }

    @Override
    public String toString() {
        String output = "";
        for(Product item : itemsInSale)
            output += item.getDescription() + "\n";

        for(Coupon coupon : coupons)
            output += coupon + "\n";

        output += "Total price: " + totalPrice;
        return output;
    }
}