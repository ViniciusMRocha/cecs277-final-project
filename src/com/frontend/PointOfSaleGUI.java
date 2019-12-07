package com.frontend;


import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.factory.DrinkTypes;
import com.factory.PastryTypes;
import com.factory.Product;
import com.factory.drink.Drink;
import com.factory.drink.DrinkFactory;
import com.factory.pastry.Pastry;
import com.factory.pastry.PastryFactory;
import com.sale.Coupon;
import com.sale.Sale;
import com.sale.coupontypes.DrinkCoupon;
import com.sale.coupontypes.GeneralCoupon;
import com.sale.coupontypes.PastryCoupon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

public class PointOfSaleGUI extends JPanel {

    private static JFrame orderFrame;

    private PointOfSaleGUI() {
        super(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel(new BorderLayout());
        tabbedPane.addTab("Make a new sale", panel1);

        String comboBoxItems[] = {"Drink", "Food"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        panel1.add(cb, BorderLayout.NORTH);

        JButton select = new JButton("Text");
        panel1.add(select, BorderLayout.SOUTH);

        JPanel panel2 = new JPanel(new BorderLayout());
        tabbedPane.addTab("Edit an existing sale", panel2);
        panel2.setPreferredSize(new Dimension(610, 300));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));



        ArrayList<Sale> sales = createSales();
        JTable existingOrders = new OrderHistoryTable(sales);

        orderFrame = new JFrame();
        OrderDetailsWindow orderDetailsPanel = new OrderDetailsWindow();
        orderFrame.add(orderDetailsPanel);
        orderFrame.setVisible(false);
        orderFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        JButton viewButton = new JButton("View selected order");
        viewButton.setEnabled(false);
        viewButton.addActionListener(e -> {
            Sale selectedSale = ((SaleTableModel)existingOrders.getModel()).getSaleAt(existingOrders.getSelectedRow());
            SaleDetailsTableModel model = new SaleDetailsTableModel(selectedSale);
            orderDetailsPanel.updateTableModel(model);
            orderFrame.pack();
            orderFrame.setVisible(true);
        });

        JButton editButton = new JButton("Edit selected order");
        editButton.setEnabled(false);

        existingOrders.getSelectionModel().addListSelectionListener(e -> {
            if(existingOrders.getSelectedRow() == -1) {
                editButton.setEnabled(false);
                viewButton.setEnabled(false);
            } else {
                editButton.setEnabled(true);
                viewButton.setEnabled(true);
            }
        });

        JButton removeButton = new JButton("Remove selected order");
        removeButton.setEnabled(false);

        existingOrders.getSelectionModel().addListSelectionListener(e -> {
            if(existingOrders.getSelectedRow() == -1) {
                removeButton.setEnabled(false);
                viewButton.setEnabled(false);
            } else {
                removeButton.setEnabled(true);
                viewButton.setEnabled(true);
            }
        });

        buttonPanel.add(editButton, BorderLayout.EAST);
        buttonPanel.add(removeButton, BorderLayout.EAST);
        buttonPanel.add(viewButton, BorderLayout.WEST);
        panel2.add(buttonPanel, BorderLayout.SOUTH);

        JLabel text = new JLabel("Please select a sale to edit");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(text, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(existingOrders);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(tabbedPane);
    }

    /**
     * Create the GUI and display it.
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Final Exam");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PointOfSaleGUI(), BorderLayout.CENTER);
        frame.pack();
        frame.setVisible(true);
    }

    private ArrayList<Sale> createSales() {
        PastryFactory pastryMaker = new PastryFactory();
        DrinkFactory drinkMaker = new DrinkFactory();
        ArrayList<DrinkToppings> coffeeToppings = new ArrayList<>();

        coffeeToppings.add(DrinkToppings.WHIPPED_CREAM);
        Product almondLatte = drinkMaker.createProduct("Almond Latte", DrinkTypes.COFFEE, Drink.Size.MEDIUM, coffeeToppings, Drink.Sweetness.NO_SUGAR, Drink.Milk.NO_MILK); //TODO: Add list of toppings to ENUM!
        ArrayList<DrinkToppings> coffeeToppings1 = new ArrayList<>();

        Product darkRoast = drinkMaker.createProduct("Dark Roast", DrinkTypes.COFFEE, Drink.Size.LARGE, coffeeToppings1, Drink.Sweetness.NO_SUGAR, Drink.Milk.NO_MILK); //TODO: Add list of toppings to ENUM!

        ArrayList<DrinkToppings> coffeeToppings3 = new ArrayList<>();

        coffeeToppings3.add(DrinkToppings.WHIPPED_CREAM);
        Product hazelnutLatte = drinkMaker.createProduct("Hazelnut Latte", DrinkTypes.COFFEE, Drink.Size.SMALL, coffeeToppings3, Drink.Sweetness.NO_SUGAR, Drink.Milk.SOY_MILK); //TODO: Add list of toppings to ENUM!
        Product pumpkinSpiceLatte = drinkMaker.createProduct("Pumpkin Spice Latte", DrinkTypes.COFFEE, Drink.Size.SMALL, coffeeToppings3, Drink.Sweetness.NO_SUGAR, Drink.Milk.HALF_AND_HALF); //TODO: Add list of toppings to ENUM!

        ArrayList<DrinkToppings> teaToppings = new ArrayList<>();

        teaToppings.add(DrinkToppings.BOBA);
        teaToppings.add(DrinkToppings.COCONUT_JELLY);
        Product jasmineGreenTea = drinkMaker.createProduct("Jasmine Green Tea", DrinkTypes.TEA, Drink.Size.LARGE, teaToppings, Drink.Sweetness.QUARTER_SWEET, Drink.Milk.SOY_MILK);
        ArrayList<DrinkToppings> teaToppings2 = new ArrayList<>();

        teaToppings2.add(DrinkToppings.PASSIONFRUIT_JELLY);
        teaToppings2.add(DrinkToppings.STRAWBERRIES);
        teaToppings2.add(DrinkToppings.COCONUT_JELLY);
        Product summerMintTea = drinkMaker.createProduct("Summer Mint Tea", DrinkTypes.TEA, Drink.Size.LARGE, teaToppings2, Drink.Sweetness.HALF_SWEET, Drink.Milk.NO_MILK);
        ArrayList<DrinkToppings> teaToppings3 = new ArrayList<>();

        teaToppings3.add(DrinkToppings.BOBA);
        Product milkTea = drinkMaker.createProduct("Milk Tea", DrinkTypes.TEA, Drink.Size.MEDIUM, teaToppings3, Drink.Sweetness.THREE_FOURTHS_SWEET, Drink.Milk.HALF_AND_HALF);
        ArrayList<DrinkToppings> teaToppings4 = new ArrayList<>();

        teaToppings4.add(DrinkToppings.BOBA);
        teaToppings4.add(DrinkToppings.LYCHEE_JELLY);
        Product jasmineGreenTeaTwo = drinkMaker.createProduct("Jasmine Green Tea", DrinkTypes.TEA, Drink.Size.MEDIUM, teaToppings4, Drink.Sweetness.NO_SUGAR, Drink.Milk.SOY_MILK);

        Product chocolateCroissant = pastryMaker.createProduct("Chocolate Nut", PastryTypes.CROISSANT, 1, Pastry.HeatState.COLD, 0, 0);
        Product plainCroissant = pastryMaker.createProduct("Plain", PastryTypes.CROISSANT, 1, Pastry.HeatState.HEATED, 0, 0);
        Product oatmealCookie = pastryMaker.createProduct("Oatmeal", PastryTypes.COOKIE, 7, 0, 0, 0);
        Product varietyMacaroon = pastryMaker.createProduct("Variety", PastryTypes.MACAROON, 7, 0, 0, 0);

        ArrayList<Product> itemsInSale = new ArrayList<>();

        itemsInSale.add(almondLatte);
        itemsInSale.add(darkRoast);
        itemsInSale.add(hazelnutLatte);
        itemsInSale.add(pumpkinSpiceLatte);

        itemsInSale.add(jasmineGreenTea);
        itemsInSale.add(summerMintTea);
        itemsInSale.add(milkTea);
        itemsInSale.add(jasmineGreenTeaTwo);
        itemsInSale.add(chocolateCroissant);
        itemsInSale.add(plainCroissant);
        itemsInSale.add(oatmealCookie);
        itemsInSale.add(varietyMacaroon);

        ArrayList<Coupon> coupons = new ArrayList<>();
        ArrayList<Coupon> coupons2 = new ArrayList<>();
        ArrayList<Coupon> coupons3 = new ArrayList<>();
        coupons.add(new DrinkCoupon());

        Sale sale = new Sale(itemsInSale, coupons);
        System.out.println(sale.printItems());


        coupons2.add(new GeneralCoupon());
        Sale sale2 = new Sale(itemsInSale, coupons2);

        ArrayList<Product> itemsInSale2 = new ArrayList<>(itemsInSale);

        itemsInSale2.remove(1); // Changed the amount of items in a sale to test if the JTables would update correctly.
        coupons3.add(new PastryCoupon());
        Sale sale3 = new Sale(itemsInSale2, coupons3);

        ArrayList<Sale> sales = new ArrayList<>();
        sales.add(sale);
        sales.add(sale2);
        sales.add(sale3);

        return sales;
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}