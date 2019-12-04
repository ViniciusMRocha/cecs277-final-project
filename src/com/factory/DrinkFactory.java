package com.factory;

import com.decorator.toppings.drinktoppings.*;
import com.decorator.toppings.drinktoppings.jellies.*;
import com.decorator.toppings.drinktoppings.milk.*;

import java.util.ArrayList;


/**
 * A DrinkFactory is an implementation of the ProductFactory. It creates a unique type of Drink object depending on
 * the user's specifications.
 */
public class DrinkFactory implements ProductFactory {

    private DrinkToppings[] ArrayList;

    /**
     * The createProduct(Object, Object) method initializes a new Drink object given a set of parameters.
     * TODO: Properly document the uses for each object parameter, if applicable.
     */
    @Override
    public Product createProduct(Object type, Object size, Object toppings, Object sweetness) {
        Drink p = null;

        switch((DrinkTypes)type) {
            case TEA:
                p = new Tea((Drink.Size)size, (Tea.Sweetness)sweetness);
                break;

            case COFFEE:
                p = new Coffee((Drink.Size)size);
                break;
        }

        for(DrinkToppings t: (ArrayList<DrinkToppings>) toppings) {
            switch (t) {
                case COCONUT_JELLY:
                    p = new CoconutJelly(p);
                    break;

                case LYCHEE_JELLY:
                    p = new LycheeJelly(p);
                    break;

                case GRASS_JELLY:
                    p = new GrassJelly(p);
                    break;

                case PASSIONFRUIT_JELLY:
                    p = new PassionFruitJelly(p);
                    break;

                case HALF_AND_HALF:
                    p = new HalfAndHalf(p);
                    break;

                case SOY_MILK:
                    p = new SoyMilk(p);
                    break;

                case BOBA:
                    p = new Boba(p);
                    break;
                case POPPING_BOBA:
                    p = new PoppingBoba(p);
                    break;

                case WHIPPED_CREAM:
                    p = new WhippedCream(p);
                    break;

                case STRAWBERRIES:
                    p = new Strawberries(p);
                    break;
            }
        }
        return p;
    }
}