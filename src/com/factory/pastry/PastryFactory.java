package com.factory.pastry;

import com.factory.Product;
import com.factory.ProductFactory;
import com.factory.pastry.cookies.ChocolateChipCookie;
import com.factory.pastry.cookies.CookieTypes;
import com.factory.pastry.cookies.NutChocolateChipCookie;
import com.factory.pastry.cookies.OatmealCookie;
import com.factory.pastry.croissants.Croissant;
import com.factory.pastry.croissants.CroissantTypes;
import com.factory.pastry.croissants.PlainCroissant;
import com.factory.pastry.croissants.StrawberryCroissant;
import com.factory.pastry.macaroons.Macaroon;
import com.factory.pastry.macaroons.MacaroonTypes;

/**
* A PastryFactory is an implementation of the ProductFactory. It creates a unique type of Pastry object depending on
* the user's specifications.
*/
public class PastryFactory extends ProductFactory {

	/**
	 * The createProduct(Object, Object) method initializes a new Pastry object given a set of parameters.
	 * @param name Object
	 * @param type Object
	 * @param quantity Object
	 * @param heatState Object
	 * @param details3 Object
	 * @param details4 Object
	 * @param details5 Object
	 * @return Pastry
	 */
	@Override
	public Product createProduct(Object name, Object type, Object quantity, Object heatState, Object details3, Object details4, Object details5) {
	Pastry p = null;

	if(type instanceof CookieTypes) {
		switch ((CookieTypes)type) {
			case OATMEAL:
				p = new OatmealCookie((String)name, (int)quantity);
				break;

			case CHOCOLATE_CHIP:
				p = new ChocolateChipCookie((String)name, (int)quantity);
				break;

			case NUT_CHOCOLATE_CHIP:
				p = new NutChocolateChipCookie((String)name, (int)quantity);
				break;
		}
	} else if(type instanceof CroissantTypes) {
		switch ((CroissantTypes)type) {
			case PLAIN:
				p = new PlainCroissant((String)name, (int)quantity, (Croissant.HeatState) heatState);
				break;

			case STRAWBERRY:
				System.out.println("Hi!!!");
				p = new StrawberryCroissant((String)name, (int)quantity, (Croissant.HeatState) heatState);
				break;
		}
	} else if(type instanceof MacaroonTypes) {
		switch ((MacaroonTypes)type) {
			case MACAROON:
				p = new Macaroon((String)name, (int)quantity);
				break;
		}
	}

	return p;
	}
}