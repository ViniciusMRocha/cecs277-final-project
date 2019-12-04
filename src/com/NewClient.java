package com;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.*;
import com.sale.Coupon;
import com.sale.Sale;
import com.sale.coupontypes.DrinkCoupon;

import java.util.ArrayList;

/** 
 * CECS 277 Fall 2019
 * Final Exam Project - Till software for tea and coffee shop
 * Full program with GUI designed to allow the user to purchase both drinks and pastries
 * @authors Tyler McDonald, Spencer Carlson
 * @date 25/11/2019
 * @version 1.00
 */

/**
 * Main implementation for the program
 * @author Tyler McDonald
 */
public class NewClient {

	public static void main(String[] args) {
		ArrayList<Toppings> teaToppings = new ArrayList<>();
		ArrayList<DrinkToppings> coffeeToppings = new ArrayList<>();

		//CREATING THE FACTORIES
		PastryFactory pastryMaker = new PastryFactory();
		DrinkFactory drinkMaker = new DrinkFactory();
			
		System.out.println("\n\n---------------New Drink---------------");
		Product coffee = drinkMaker.createProduct(DrinkTypes.COFFEE, Drink.Size.LARGE, coffeeToppings, 0); //TODO: Add list of toppings to ENUM!
		Product tea = drinkMaker.createProduct(DrinkTypes.TEA, Drink.Size.LARGE, teaToppings, Drink.Sweetness.HALF_SWEET);
		//Product pastry = pastryMaker.createProduct(PastryTypes.CROISSANT, bubTea);
		//System.out.println(coffee.getDescription());

		ArrayList<Product> itemsInSale = new ArrayList<>();
		ArrayList<Coupon> coupons = new ArrayList<>();
		itemsInSale.add(coffee);
		itemsInSale.add(tea);
		coupons.add(new DrinkCoupon());

		Sale sale = new Sale(itemsInSale, coupons);
		System.out.println(sale);
	}

}
