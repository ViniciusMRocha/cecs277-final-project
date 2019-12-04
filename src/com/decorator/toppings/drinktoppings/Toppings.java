package com.decorator.toppings.drinktoppings;

import com.factory.Drink;

/**
 * Toppings represent the different kinda of toppings that a Drink
 * can have. It is a part of the Decorator design pattern.
 *
 * TODO: Fix topping costs (set getCost() in each topping to: "return base.getCost() + toppingCost;"
 */
public abstract class Toppings extends Drink {
	Drink base;

	public Toppings(Drink base) {
		this.base = base;
	}
	public abstract String getDescription();
}