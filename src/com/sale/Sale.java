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

    /**
     * Created a sale with items and coupons
     * @param itemsInSale ArrayList
     * @param coupons ArrayList
     */
    public Sale(ArrayList<Product> itemsInSale, ArrayList<Coupon> coupons) {
        indexesOfCouponUsages = new ArrayList<>();
        this.itemsInSale = itemsInSale;
        if(coupons == null) this.couponsInSale = new ArrayList<>();
        else this.couponsInSale = coupons;
        calculateTotalCost();
    }

    /**
     * Creates a empty sale
     */
    public Sale() {
        itemsInSale = new ArrayList<>();
        couponsInSale = new ArrayList<>();
        totalPrice = 0.0;
        indexesOfCouponUsages = new ArrayList<>();
        calculateTotalCost();
    }

    /**
     * adds a product to the sale
     * @param itemToAdd Product
     */
    public void addToSale(Product itemToAdd) {
        this.itemsInSale.add(itemToAdd);
        calculateTotalCost();
    }

    /**
     * Set the all the items array list to the sale
     * @param itemsInSale ArrayList
     */
    public void setItemsInSale(ArrayList<Product> itemsInSale) {
        this.itemsInSale = itemsInSale;
    }

    /**
     * Remove the item from a sale
     * @param itemIndex int
     */
    public void removeFromSale(int itemIndex) {
        this.itemsInSale.remove(itemIndex);
        calculateTotalCost();
    }

    /**
     * Sets the receipt number
     */
    public void setReceiptNumber() {
        receiptNumber = ++totalOrders;
        System.out.println("Receipt num:" + receiptNumber + "\nTotal orders num: " + totalOrders);
    }

    /**
     * Get the receipt number
     * @return int
     */
    public int getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * add discount to the item applied by the coupon
     * @param index int
     */
    public void addDiscountedItemIndex(int index) {
        indexesOfCouponUsages.add(index);
    }

    /**
     * Calculates the total cost for the sale
     */
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

    /**
     * Gets the total price for the sale
     * @return double
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Formatted the total price for display
     * @return String
     */
    public String getFormattedTotalPrice() {
        return String.format("$%.2f", totalPrice);
    }

    /**
     * Gets the amount of total coupons used
     * @return
     */
    public int couponsUsed() {
        return couponsInSale.size();
    }

    /**
     * Gets the item in a sale
     * @return ArrayList
     */
    public ArrayList<Product> getItemsInSale() {
        return itemsInSale;
    }

    /**
     * Prints out each item in the console
     * @return String
     */
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

    /**
     * Prints out the sale information
     * @return String
     */
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