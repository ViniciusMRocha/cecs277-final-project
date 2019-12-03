package com.sale.coupontypes;

import com.factory.Pastry;
import com.factory.Product;
import com.sale.Coupon;
import com.sale.Sale;

public class PastryCoupon extends Coupon {

    public PastryCoupon() {
        super("Pastry coupon", "$1 oﬀ a cookie purchase.");
    }

    @Override
    protected double calculateDiscount(Sale sale) {
        for(Product item : sale.getItemsInSale())
            if(item instanceof Pastry)
                if(((Pastry) item).getName().equals("Cookie")) //TODO: Change this to an Enum
                    return 1.0;
        return 0.0;
    }
}