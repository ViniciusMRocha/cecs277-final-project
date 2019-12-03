package com;

import java.util.ArrayList;

import decorator.*;
import product.DrinkTypes;
import product.PastryTypes;
import product.Pastry;
import product.Product;
import product.SizesSML;

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
public class Client {

	public static void main(String[] args) {
		ArrayList<ToppingTypes> bubTea = new ArrayList<ToppingTypes>();
//		vegtop.add(ToppingTypes.BellPeppers);
//		vegtop.add(ToppingTypes.Mushrooms);
		
		ArrayList<ToppingTypes> meattop = new ArrayList<ToppingTypes>();
//		meattop.add(ToppingTypes.Ham);
//		meattop.add(ToppingTypes.Pepperoni);
//		meattop.add(ToppingTypes.Sausage);
		
		//CREATING THE FACTORIES
		PastryFactory pastryMaker = new PastryFactory();
		DrinkFactory drinkMaker = new DrinkFactory();
			
		System.out.println("\n\n---------------New Drink---------------");
		Product t = pastryMaker.createProduct(PastryTypes.Croissant, bubTea, 2);
//		System.out.println(veg.getDescription());
//		System.out.println(String.format("Cost: $%.2f" , veg.getCost()));
		
		System.out.println("\n\n---------------New Drink2---------------");
		Product tea = drinkMaker.createProduct(DrinkTypes.Tea, bubTea,SizesSML.L);
//		System.out.println(soda.getDescription());
//		System.out.println(String.format("Cost: $%.2f" , soda.getCost()));
		
		System.out.println("\n\n---------------New Pizza---------------");
//		Product meat = pizzaMaker.createProduct(PastryTypes.Simple, meattop);
//		System.out.println(meat.getDescription());
//		System.out.println(String.format("Cost: $%.2f" , meat.getCost()));
		

		System.out.println("\n\n---------------New Drink---------------");
//		Product juice = drinkMaker.createProduct(DrinkTypes.Coffee, SizesSML.M);
//		System.out.println(juice.getDescription());
//		System.out.println(String.format("Cost: $%.2f" , juice.getCost()));
		
	}

}
