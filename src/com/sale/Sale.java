package com.sale;

import com.factory.Product;

import java.util.ArrayList;

/**
 * A sale contains different product types (drinks and pastries).
 * It also hold any coupon information applied to the sale.
 * and the total amount for the sale
 */
public class Sale {
    private ArrayList<Product> itemsInSale;
    private double totalPrice;
    private ArrayList<Coupon> couponsInSale;
    private static int totalOrders;
    private int receiptNumber;
    private ArrayList<Integer> indexesOfCouponUsages;

    /**
     * Creates a sale object
     * @param itemsInSale ArrayList
     * @param coupons ArrayList
     */
    public Sale(ArrayList<Product> itemsInSale, ArrayList<Coupon> coupons) {
        indexesOfCouponUsages = new ArrayList<>();
        this.itemsInSale = itemsInSale;
        if(coupons == null) this.couponsInSale = new ArrayList<>();
        else this.couponsInSale = coupons;
        calculateTotalCost();
        totalOrders++;
        receiptNumber = totalOrders;
    }

    /**
     * Creates a empty sale object
     */
    public Sale() {
        itemsInSale = new ArrayList<>();
        couponsInSale = new ArrayList<>();
        totalPrice = 0.0;
        indexesOfCouponUsages = new ArrayList<>();
        receiptNumber = ++totalOrders;
        System.out.println("Receipt num:" + receiptNumber + "\nTotal orders num: " + totalOrders);

        calculateTotalCost();
    }

    /**
     * Adds a item to the sale
     * @param itemToAdd Product
     */
    public void addToSale(Product itemToAdd) {
        this.itemsInSale.add(itemToAdd);
        calculateTotalCost();
    }

    /**
     * Add a coupon to the sale
     * @param coupon Coupon
     */
    public void addCouponToSale(Coupon coupon) {
        this.couponsInSale.add(coupon);
        calculateTotalCost();
    }


    /**
     * Takes in an array of products and sets it to the sale as the sale items
     * @param itemsInSale ArrayList
     */
    public void setItemsInSale(ArrayList<Product> itemsInSale) {
        this.itemsInSale = itemsInSale;
    }

    public void setCouponsInSale(ArrayList<Coupon> couponsInSale) {
        this.couponsInSale = couponsInSale;
    }

    /**
     * remove a item from the sale by getting the item index in the sale grid
     * @param itemIndex int
     */
    public void removeFromSale(int itemIndex) {
        this.itemsInSale.remove(itemIndex);
        calculateTotalCost();
    }

    /**
     * Prints out the reciept number and the total order number
     */
    public void setReceiptNumber() {
        System.out.println("Receipt num:" + receiptNumber + "\nTotal orders num: " + totalOrders);
    }

    /**
     * Gets the receipt number for that one specific sale
     * @return int
     */
    public int getReceiptNumber() {
        return receiptNumber;
    }

    /**
     * Applies the coupon to a selected item
     * @param index int
     */
    public void addDiscountedItemIndex(int index) {
        indexesOfCouponUsages.add(index);
    }

    /**
     * Calculates the total dollar amount for the sale
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
     * Gets the item index where the coupon was used
     * @return ArrayList
     */
    public ArrayList<Integer> getIndexesOfCouponUsages() {
        return indexesOfCouponUsages;
    }

    /**
     * Gets the total price for the sale
     * @return double
     */
    public double getTotalPrice() {
        return totalPrice;
    }

    /**
     * Gets the dollar amount formatter for currency standard
     * @return String
     */
    public String getFormattedTotalPrice() {
        return String.format("$%.2f", totalPrice);
    }

    /**
     * Gets the total count of how many coupons were used
     * @return int
     */
    public int couponsUsed() {
        return couponsInSale.size();
    }

    /**
     * Gets all the items in the sale grid
     * @return ArrayList
     */
    public ArrayList<Product> getItemsInSale() {
        return itemsInSale;
    }

    /**
     * Formated way to print a sale item
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
     * Formated way to print a coupon and the total dollar amount for the order
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