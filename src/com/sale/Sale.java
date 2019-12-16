package com.sale;

import com.factory.Product;

import java.util.ArrayList;

public class Sale {
    private ArrayList<Product> itemsInSale;
    private double totalPrice;
    private ArrayList<Coupon> couponsInSale;
    private static int totalOrders;
    private int receiptNumber;
    private ArrayList<Integer> indexesOfCouponUsages;

    public Sale() {
        itemsInSale = new ArrayList<>();
        couponsInSale = new ArrayList<>();
        totalPrice = 0.0;
        indexesOfCouponUsages = new ArrayList<>();
        receiptNumber = ++totalOrders;
        System.out.println("Receipt num:" + receiptNumber + "\nTotal orders num: " + totalOrders);

        calculateTotalCost();
    }

    public void addToSale(Product itemToAdd) {
        this.itemsInSale.add(itemToAdd);
        calculateTotalCost();
    }

    public void setItemsInSale(ArrayList<Product> itemsInSale) {
        this.itemsInSale = itemsInSale;
    }

    public void setCouponsInSale(ArrayList<Coupon> couponsInSale) {
        this.couponsInSale = couponsInSale;
    }

    public void removeFromSale(int itemIndex) {
        this.itemsInSale.remove(itemIndex);
        calculateTotalCost();
    }

    public void setReceiptNumber() {
        System.out.println("Receipt num:" + receiptNumber + "\nTotal orders num: " + totalOrders);
    }

    public int getReceiptNumber() {
        return receiptNumber;
    }

    public void addDiscountedItemIndex(int index) {
        indexesOfCouponUsages.add(index);
    }

    public void calculateTotalCost() {
        double totalPrice = 0.0;
        for(Product product : itemsInSale)
            totalPrice += product.getCost();

        for(Coupon coupon : couponsInSale) {
            double discount = coupon.calculateDiscount(this);
            totalPrice -= discount;
        }
        this.totalPrice = totalPrice;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public String getFormattedTotalPrice() {
        return String.format("$%.2f", totalPrice);
    }

    public int couponsUsed() {
        return couponsInSale.size();
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

        for(Coupon coupon : couponsInSale) {
            output += "\n-------------------- NEW COUPON --------------------\n";
            output += coupon;
        }

        output += "\n\n-------------------- ORDER TOTAL --------------------\n";

        output += "Total price: " + totalPrice;
        return output;
    }
}