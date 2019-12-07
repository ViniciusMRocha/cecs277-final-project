package com.decorator.toppings.drinktoppings;

import com.factory.drink.Drink;

/**
 * Toppings represent the different kinda of toppings that a Drink
 * can have. It is a part of the Decorator design pattern.
 *
 */
public abstract class Toppings extends Drink {
	protected Drink base;

	public Toppings(Drink base) {
		super();
		this.base = base;
	}
	public abstract String getDescription();
}