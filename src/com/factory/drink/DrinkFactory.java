package com.factory.drink;

import com.decorator.toppings.drinktoppings.Boba;
import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.decorator.toppings.drinktoppings.PoppingBoba;
import com.decorator.toppings.drinktoppings.Strawberries;
import com.decorator.toppings.drinktoppings.jellies.CoconutJelly;
import com.decorator.toppings.drinktoppings.jellies.GrassJelly;
import com.decorator.toppings.drinktoppings.jellies.LycheeJelly;
import com.decorator.toppings.drinktoppings.jellies.PassionFruitJelly;
import com.decorator.toppings.drinktoppings.milk.WhippedCream;
import com.factory.ProductFactory;
import com.factory.drink.coffee.*;
import com.factory.drink.milkcoffees.HousePremiumMilkCoffee;
import com.factory.drink.milkcoffees.MilkCoffeeTypes;
import com.factory.drink.milkcoffees.PumpkinSpiceMilkCoffee;
import com.factory.drink.milkcoffees.SeaCreamMilkCoffee;
import com.factory.drink.teas.*;

import java.util.ArrayList;


/**
 * A DrinkFactory is an implementation of the ProductFactory. It creates a unique type of Drink object depending on
 * the user's specifications.
 */
public class DrinkFactory extends ProductFactory {

    /**
     * The createProduct(Object, Object) method initializes a new Drink object given a set of parameters.
     *
     * @param name Object
     * @param type Object
     * @param size Object
     * @param toppings Object
     * @param sweetness Object
     * @param milk Object
     * @param details2 Object
     * @return Drink
     */
    @Override
    public Drink createProduct(Object name, Object type, Object size, Object toppings, Object sweetness, Object milk, Object details2) {
        Drink p = null;

        if(type instanceof MilkCoffeeTypes) {
            System.out.println("This is a milk coffee");
            switch ((MilkCoffeeTypes)type) {
                case SEA_CREAM:
                    p = new SeaCreamMilkCoffee((String)name, (Drink.Size)size, (Drink.Milk)milk);
                    break;

                case HOUSE_PREMIUM:
                    p = new HousePremiumMilkCoffee((String)name, (Drink.Size)size, (Drink.Milk)milk);
                    break;

                case PUMPKIN_SPICE:
                    p = new PumpkinSpiceMilkCoffee((String)name, (Drink.Size)size, (Drink.Milk)milk);
                    break;
            }
        } else if(type instanceof CoffeeTypes) {
            System.out.println("This is a coffee");

            switch ((CoffeeTypes)type) {
                case CHA_CHA_CHA_REGULAR:
                    p = new ChaChaChaRegular((String)name, (Drink.Size)size, (Drink.Milk)milk);
                    break;

                case CHA_CHA_CHA_DECAF:
                    p = new ChaChaChaDecaf((String)name, (Drink.Size)size, (Drink.Milk)milk);
                    break;

                case CAFE_DE_LA_OLLA:
                    p = new CafeDeLaOllaCoffee((String)name, (Drink.Size)size, (Drink.Milk)milk);
                    break;

                case HAZELNUT_HAPPINESS:
                    p = new HazelnutHappinessCoffee((String)name, (Drink.Size)size, (Drink.Milk)milk);
                    break;
            }
        } else if(type instanceof TeaTypes) {
            switch ((TeaTypes)type) {
                case SUMMER_MINT_TEA:
                    p = new SummerMintTea((String)name, (Drink.Size)size, (Tea.Sweetness)sweetness, (Drink.Milk)milk);
                    break;

                case GREEN_TEA:
                    p = new GreenTea((String)name, (Drink.Size)size, (Tea.Sweetness)sweetness, (Drink.Milk)milk);
                    break;

                case ROSE_GREEN_TEA:
                    p = new RoseGreenTea((String)name, (Drink.Size)size, (Tea.Sweetness)sweetness, (Drink.Milk)milk);
                    break;

                case JASMINE_GREEN_TEA:
                    p = new JasmineGreenTea((String)name, (Drink.Size)size, (Tea.Sweetness)sweetness, (Drink.Milk)milk);
                    break;

                case TARO_TEA:
                    p = new TaroTea((String)name, (Drink.Size)size, (Tea.Sweetness)sweetness, (Drink.Milk)milk);
                    break;
            }
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