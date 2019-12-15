package com.factory.pastry;

import com.factory.PastryTypes;
import com.factory.Product;
import com.factory.ProductFactory;

/**
* A PastryFactory is an implementation of the ProductFactory. It creates a unique type of Pastry object depending on
* the user's specifications.
*/
public class PastryFactory extends ProductFactory {

	/**
	 * The createProduct(Object, Object) method initializes a new Pastry object given a set of parameters.
	 * @param type The type of Pastry to be created.
	 * @return The new Pastry object.
	 */
	@Override
	public Product createProduct(Object name, Object type, Object quantity, Object heatState, Object details3, Object details4) {
	Pastry p = null;

		switch ((PastryTypes) type) {
			case CROISSANT:
				p = new Croissant((String)name, (int)quantity, (Croissant.HeatState) heatState);
				break;
			case COOKIE:
				p = new Cookie((String)name, (int)quantity);
				break;
			case MACAROON:
				p = new Macaroon((String)name, (int)quantity);
				break;
		}

		return p;
	}
}