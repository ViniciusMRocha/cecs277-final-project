package com.sale;

import com.factory.Product;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> itemsInSale;
    private double totalPrice;
    private ArrayList<Coupon> coupons;
    private static int totalOrders = 0;
    private int receiptNumber;
    private ArrayList<Integer> indexesOfCouponUsages;

    public Sale(ArrayList<Product> itemsInSale, ArrayList<Coupon> coupons) {
        indexesOfCouponUsages = new ArrayList<>();
        this.itemsInSale = itemsInSale;
        if(coupons == null) this.coupons = new ArrayList<>();
        else this.coupons = coupons;
        totalPrice = calculateTotalCost();
        totalOrders++;
        receiptNumber = totalOrders;
    }

    public Sale() {
        itemsInSale = new ArrayList<>();
        coupons = new ArrayList<>();
        totalPrice = 0.0;
        indexesOfCouponUsages = new ArrayList<>();
    }

    public void addToSale(Product itemToAdd) {
        this.itemsInSale.add(itemToAdd);
        totalPrice = calculateTotalCost();
        totalOrders++;
        receiptNumber = totalOrders;
    }


    public void removeFromSale(int itemIndex) {
        this.itemsInSale.remove(itemIndex);
        totalPrice = calculateTotalCost();
        totalOrders++;
        receiptNumber = totalOrders;
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void addDiscountedItemIndex(int index) {
        indexesOfCouponUsages.add(index);
    }

    private double calculateTotalCost() {
        double cost = 0.0;
        for(Product product : itemsInSale)
            cost += product.getCost();

        for(Coupon coupon : coupons) {
            double discount = coupon.calculateDiscount(this);
            cost -= discount;
        }
        return cost;
    }

    public ArrayList<Integer> getIndexesOfCouponUsages() {
        return indexesOfCouponUsages;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getFormattedTotalPrice() {
        return String.format("$%.2f", totalPrice);
    }

    public int couponsUsed() {
        return coupons.size();
    }

    public ArrayList<Product> getItemsInSale() {
        return itemsInSale;
    }

    public String printItems() {
        String output = "";
        int itemNumber = 1;
        for(Product item : itemsInSale) {
            output += "\n-------------------- NEW ITEM --------------------\n";
            output += "Item #" + (itemNumber++) + "\n";
            output += item.getDescription() + "\n";
            output += String.format("Cost: $%.2f" , item.getCost());
        }
        return output;
    }
    @Override
    public String toString() {
        String output = "";

        for(Coupon coupon : coupons) {
            output += "\n-------------------- NEW COUPON --------------------\n";
            output += coupon;
        }

        output += "\n\n-------------------- ORDER TOTAL --------------------\n";

        output += "Total price: " + totalPrice;
        return output;
    }
}