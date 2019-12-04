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
        for(Product item : itemsInSale) {
            output += "\n-------------------- NEW ITEM --------------------\n";
            output += item.getDescription() + "\n";
            output += String.format("Cost: $%.2f" , item.getCost());
        }
        output += "\n\n-------------------- COUPONS --------------------\n";

        for(Coupon coupon : coupons) {
            output += "\n-------------------- NEW COUPON --------------------\n";
            output += coupon;
        }

        output += "\n\n-------------------- ORDER TOTAL --------------------\n";

        output += "Total price: " + totalPrice;
        return output;
    }
}