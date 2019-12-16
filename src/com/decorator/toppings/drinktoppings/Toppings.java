package com.decorator.toppings.drinktoppings;

import com.factory.drink.Drink;

/**
 * Toppings represent the different kinds of toppings that a Drink
 * can have. It is a part of the Decorator design pattern.
 *
 */
public abstract class Toppings extends Drink {
	protected Drink base;

	/**
	 * Wraps a Drink object into a new Toppings object.
	 * @param base Drink
	 */
	public Toppings(Drink base) {
		super();
		this.base = base;
	}

	public Drink getBase() {
		return base;
	}

	/**
	 * Returns the description of the new product, including all of it's other decorations and it's base class name
	 * @return String
	 */
	public abstract String getDescription();
}