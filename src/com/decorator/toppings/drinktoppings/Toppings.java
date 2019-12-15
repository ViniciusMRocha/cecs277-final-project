package com.decorator.toppings.drinktoppings;

import com.factory.drink.Drink;

/**
 * Toppings represent the different kinds of toppings that a Drink
 * can have. It is a part of the Decorator design pattern.
 *
 */
public abstract class Toppings extends Drink {
	protected Drink base;

	public Toppings(Drink base) {
		super();
		this.base = base;
	}

	/**
	 * Returns the description of the new product, including all of it's other decorations and it's base class name
	 * @return the description of the object
	 */
	public abstract String getDescription();
}