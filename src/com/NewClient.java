package com;


import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.factory.*;
import com.sale.Coupon;
import com.sale.Sale;
import com.sale.coupontypes.DrinkCoupon;
import com.sale.coupontypes.GeneralCoupon;
import com.sale.coupontypes.PastryCoupon;

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


		//CREATING THE FACTORIES
		PastryFactory pastryMaker = new PastryFactory();
		DrinkFactory drinkMaker = new DrinkFactory();
		ArrayList<DrinkToppings> coffeeToppings = new ArrayList<>();

		coffeeToppings.add(DrinkToppings.WHIPPED_CREAM);
		Product almondLatte = drinkMaker.createProduct("Almond Latte", DrinkTypes.COFFEE, Drink.Size.MEDIUM, coffeeToppings, Drink.Sweetness.NO_SUGAR, Drink.Milk.NO_MILK); //TODO: Add list of toppings to ENUM!
		coffeeToppings.clear();

		Product darkRoast = drinkMaker.createProduct("Dark Roast", DrinkTypes.COFFEE, Drink.Size.LARGE, coffeeToppings, Drink.Sweetness.NO_SUGAR, Drink.Milk.NO_MILK); //TODO: Add list of toppings to ENUM!

		coffeeToppings.add(DrinkToppings.WHIPPED_CREAM);
		Product hazelnutLatte = drinkMaker.createProduct("Hazelnut Latte", DrinkTypes.COFFEE, Drink.Size.SMALL, coffeeToppings, Drink.Sweetness.NO_SUGAR, Drink.Milk.SOY_MILK); //TODO: Add list of toppings to ENUM!
		Product pumpkinSpiceLatte = drinkMaker.createProduct("Pumpkin Spice Latte", DrinkTypes.COFFEE, Drink.Size.SMALL, coffeeToppings, Drink.Sweetness.NO_SUGAR, Drink.Milk.HALF_AND_HALF); //TODO: Add list of toppings to ENUM!

		ArrayList<DrinkToppings> teaToppings = new ArrayList<>();

		teaToppings.add(DrinkToppings.BOBA);
		teaToppings.add(DrinkToppings.COCONUT_JELLY);
		Product jasmineGreenTea = drinkMaker.createProduct("Jasmine Green Tea", DrinkTypes.TEA, Drink.Size.LARGE, teaToppings, Drink.Sweetness.QUARTER_SWEET, Drink.Milk.SOY_MILK);
		teaToppings.clear();

		teaToppings.add(DrinkToppings.PASSIONFRUIT_JELLY);
		teaToppings.add(DrinkToppings.STRAWBERRIES);
		teaToppings.add(DrinkToppings.COCONUT_JELLY);
		Product summerMintTea = drinkMaker.createProduct("Summer Mint Tea", DrinkTypes.TEA, Drink.Size.LARGE, teaToppings, Drink.Sweetness.HALF_SWEET, Drink.Milk.NO_MILK);
		teaToppings.clear();

		teaToppings.add(DrinkToppings.BOBA);
		Product milkTea = drinkMaker.createProduct("Milk Tea", DrinkTypes.TEA, Drink.Size.MEDIUM, teaToppings, Drink.Sweetness.THREE_FOURTHS_SWEET, Drink.Milk.HALF_AND_HALF);
		teaToppings.clear();

		teaToppings.add(DrinkToppings.BOBA);
		teaToppings.add(DrinkToppings.LYCHEE_JELLY);
		Product jasmineGreenTeaTwo = drinkMaker.createProduct("Jasmine Green Tea", DrinkTypes.TEA, Drink.Size.MEDIUM, teaToppings, Drink.Sweetness.NO_SUGAR, Drink.Milk.SOY_MILK);
		teaToppings.clear();

		Product chocolateCroissant = pastryMaker.createProduct("Chocolate Nut", PastryTypes.CROISSANT, 1, Pastry.HeatState.COLD, 0, 0);
		Product plainCroissant = pastryMaker.createProduct("Plain", PastryTypes.CROISSANT, 1, Pastry.HeatState.HEATED, 0, 0);
		Product oatmealCookie = pastryMaker.createProduct("Oatmeal", PastryTypes.COOKIE, 7, 0, 0, 0);
		Product varietyMacaroon = pastryMaker.createProduct("Variety", PastryTypes.MACAROON, 7, 0, 0, 0);

		ArrayList<Product> itemsInSale = new ArrayList<>();
		itemsInSale.add(almondLatte);
		itemsInSale.add(darkRoast);
		itemsInSale.add(hazelnutLatte);
		itemsInSale.add(pumpkinSpiceLatte);

		itemsInSale.add(jasmineGreenTea);
		itemsInSale.add(summerMintTea);
		itemsInSale.add(milkTea);
		itemsInSale.add(jasmineGreenTeaTwo);
		itemsInSale.add(chocolateCroissant);
		itemsInSale.add(plainCroissant);
		itemsInSale.add(oatmealCookie);
		itemsInSale.add(varietyMacaroon);
		//Product pastry = pastryMaker.createProduct(PastryTypes.CROISSANT, bubTea);

		ArrayList<Coupon> coupons = new ArrayList<>();
		coupons.add(new DrinkCoupon());
		coupons.add(new GeneralCoupon());
		coupons.add(new PastryCoupon());
		Sale sale = new Sale(itemsInSale, coupons);
		System.out.println(sale);
	}

}
