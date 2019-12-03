package com.factory;

	/**
	 * A PastryFactory is an implementation of the ProductFactory. It creates a unique type of Pastry object depending on
	 * the user's specifications.
	 */
	public class PastryFactory implements ProductFactory {

		/**
		 * The createProduct(Object, Object) method initializes a new Pastry object given a set of parameters.
		 * @param type The type of Pastry to be created.
		 * @param details An ArrayList that outlines any additional additions the drink will have, such as the amount,
		 *                or if it should be heated)
		 * @return The new Pastry object.
		 */
		@Override
	public Product createProduct(Object type, Object details) {
		Pastry p = null;

		switch ((PastryTypes) type) {
			case CROISSANT:
				p = new Croissant();
				break;
			case COOKIE:
				p = new Cookie();
				break;
			case MACAROON:
				p = new Macaroon();
				break;
		}

		return p;
	}
}