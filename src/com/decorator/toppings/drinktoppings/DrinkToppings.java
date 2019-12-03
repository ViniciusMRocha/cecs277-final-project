package com.decorator.toppings.drinktoppings;

import com.factory.Drink;

/**
 * DrinkToppings represent the different kinda of toppings that a Drink
 * can have. It is a part of the Decorator design pattern.
 */
public abstract class DrinkToppings extends Drink {
	Drink base;

	public DrinkToppings(Drink base) {
		this.base = base;
	}
	public abstract String getDescription();
}