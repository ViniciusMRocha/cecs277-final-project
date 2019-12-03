package com;

import java.util.ArrayList;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.decorator.toppings.drinktoppings.Milk;
import com.decorator.toppings.drinktoppings.milk.HalfAndHalf;
import com.factory.*;

/** 
 * CECS 277 Fall 2019
 * Final Exam Project - Till software for tea and coffee shop
 * Full program with GUI designed to allow the user to purchase both drinks and pastries
 * @author Tyler McDonald
 * @date 25/11/2019
 * @version 1.00
 */

/**
 * Main implementation for the program
 * @author Tyler McDonald
 */
public class NewClient {

	public static void main(String[] args) {
		ArrayList<DrinkToppings> bubTea = new ArrayList<>();
		ArrayList<DrinkToppings> coffeeToppings = new ArrayList<>();

		//CREATING THE FACTORIES
		PastryFactory pastryMaker = new PastryFactory();
		DrinkFactory drinkMaker = new DrinkFactory();
			
		System.out.println("\n\n---------------New Drink---------------");
		Product coffee = drinkMaker.createProduct(DrinkTypes.COFFEE, Drink.Size.MEDIUM);
		//Product pastry = pastryMaker.createProduct(PastryTypes.CROISSANT, bubTea);
		System.out.println(coffee.getDescription());
		System.out.println(String.format("Cost: $%.2f" , coffee.getCost()));

	}

}
