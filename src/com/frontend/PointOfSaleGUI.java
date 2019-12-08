package com.frontend;


import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.DrinkTypes;
import com.factory.PastryTypes;
import com.factory.Product;
import com.factory.ProductTypes;
import com.factory.drink.*;
import com.factory.pastry.Pastry;
import com.factory.pastry.PastryFactory;
import com.sale.Coupon;
import com.sale.Sale;
import com.sale.coupontypes.DrinkCoupon;
import com.sale.coupontypes.GeneralCoupon;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PointOfSaleGUI extends JPanel {

    private static JFrame orderFrame;
    private static ArrayList<DrinkTypes> drinks;
    private static ArrayList<PastryTypes> pastries;

    private static ArrayList<JCheckBox> teaToppingsCheckBoxes;
    private static ArrayList<JCheckBox> coffeeToppingsCheckBoxes;

    private JComboBox drinkNameComboBox;

    private PointOfSaleGUI() {
        //super();
        ArrayList<Sale> sales = createSales();
        GridBagConstraints cons = createGridBagConstraints();
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel();
        panel1.setLayout(new GridBagLayout());
        panel1.setSize(new Dimension(600, 350));

        DefaultComboBoxModel drinkModel = new DefaultComboBoxModel(drinks.toArray());
        DefaultComboBoxModel pastryModel = new DefaultComboBoxModel(pastries.toArray());

        //String comboBoxItems[] = {"Drink", "Pastry"};

        ArrayList<ProductTypes> productTypes = new ArrayList<>();
        productTypes.add(ProductTypes.DRINK);
        productTypes.add(ProductTypes.PASTRY);

        DefaultComboBoxModel productTypeModel = new DefaultComboBoxModel(productTypes.toArray());
        JComboBox productTypeComboBox = new JComboBox();
        productTypeComboBox.setModel(productTypeModel);

        productTypeComboBox.setEditable(false);
        productTypeComboBox.setSelectedIndex(-1);

        ArrayList<Drink.Size> sizes = new ArrayList<>();

        ArrayList<String> coffeeTypes = new ArrayList<>();
        coffeeTypes.add(CoffeeTypes.ALMOND_LATTE.getCoffeeName());
        coffeeTypes.add(CoffeeTypes.DARK_ROAST.getCoffeeName());
        coffeeTypes.add(CoffeeTypes.HAZELNUT_LATTE.getCoffeeName());
        coffeeTypes.add(CoffeeTypes.PUMPKIN_SPICE_LATTE.getCoffeeName());

        ArrayList<String> teaTypes = new ArrayList<>();
        teaTypes.add(TeaTypes.JASMINE_GREEN_TEA.getTeaName());
        teaTypes.add(TeaTypes.SUMMER_MINT_TEA.getTeaName());
        teaTypes.add(TeaTypes.MILK_TEA.getTeaName());


        sizes.add(Drink.Size.SMALL);
        sizes.add(Drink.Size.MEDIUM);
        sizes.add(Drink.Size.LARGE);

        JComboBox sizeSelectionComboBox = new JComboBox();
        drinkNameComboBox = new JComboBox();
        drinkNameComboBox.setVisible(false);

        DefaultComboBoxModel teaTypesComboBoxModel = new DefaultComboBoxModel(teaTypes.toArray());
        DefaultComboBoxModel coffeeTypesComboBoxModel = new DefaultComboBoxModel(coffeeTypes.toArray());

        DefaultComboBoxModel sizeComboBoxModel = new DefaultComboBoxModel(sizes.toArray());
        sizeSelectionComboBox.setModel(sizeComboBoxModel);
        sizeSelectionComboBox.setVisible(false);

        JComboBox productDetailsComboBox = new JComboBox();
        productDetailsComboBox.setVisible(false);
        productDetailsComboBox.setSelectedIndex(-1);

        JPanel toppingsPanel;

        productTypeComboBox.addActionListener(e -> {
            if(productTypeComboBox.getSelectedItem().equals(ProductTypes.DRINK)) {
                productDetailsComboBox.setModel(drinkModel);
                productDetailsComboBox.setVisible(true);
            } else if(productTypeComboBox.getSelectedItem().equals(ProductTypes.PASTRY)) {
                productDetailsComboBox.setModel(pastryModel);
                productDetailsComboBox.setVisible(true);
            }
        });



        panel1.add(productTypeComboBox, cons);
        panel1.add(productDetailsComboBox, cons);
        panel1.add(sizeSelectionComboBox, cons);
        panel1.add(drinkNameComboBox, cons);
        OrderDetailsWindow saleDetails = new OrderDetailsWindow();
        SaleDetailsTableModel tableModel = new SaleDetailsTableModel(sales.get(2));

        saleDetails.updateTableModel(tableModel);

        toppingsPanel = new JPanel();
        toppingsPanel.setLayout(new GridLayout(3,3));



        productDetailsComboBox.addActionListener(e -> {
            toppingsPanel.removeAll();
            sizeSelectionComboBox.setModel(sizeComboBoxModel);
            sizeSelectionComboBox.setVisible(true);
            if(productDetailsComboBox.getSelectedItem().equals(DrinkTypes.COFFEE)) {
                drinkNameComboBox.setModel(coffeeTypesComboBoxModel);
                for (JCheckBox toppingCheckBox : coffeeToppingsCheckBoxes) {
                    toppingsPanel.add(toppingCheckBox);
                }
            } else if(productDetailsComboBox.getSelectedItem().equals(DrinkTypes.TEA)) {
                System.out.println("tea names: " + teaTypes);
                drinkNameComboBox.setModel(teaTypesComboBoxModel);
                for (JCheckBox toppingCheckBox : teaToppingsCheckBoxes) {
                    toppingsPanel.add(toppingCheckBox);
                }
            }
            drinkNameComboBox.setVisible(true);
            drinkNameComboBox.revalidate();
            drinkNameComboBox.repaint();
            toppingsPanel.revalidate();
            toppingsPanel.repaint();
        });


        panel1.add(toppingsPanel, cons);



        JButton addToOrderButton = new JButton("Add to order");
        addToOrderButton.addActionListener(e -> {
            DrinkFactory drinkFactory = new DrinkFactory();
            PastryFactory pastryFactory = new PastryFactory();
            ProductTypes finalType = (ProductTypes)productTypeComboBox.getModel().getSelectedItem();

            if(finalType.equals(ProductTypes.DRINK)) {
                String drinkName = drinkNameComboBox.getSelectedItem().toString();
                DrinkTypes type = (DrinkTypes)productDetailsComboBox.getSelectedItem();
                Drink.Size size = (Drink.Size)sizeComboBoxModel.getSelectedItem();
                ArrayList<String> toppings = getSelectedToppings(type);
                System.out.println("Toppings selected: " + toppings);
                //Product drinkProduct = drinkFactory.createProduct(drinkName, type, size,)
            }

            Product createdProduct = pastryFactory.createProduct("Oatmeal", PastryTypes.COOKIE, 7, 0, 0, 0);
            ArrayList<Product> items = new ArrayList<>();
            items.add(createdProduct);

            Sale test = new Sale(items, null);
            SaleDetailsTableModel tableModel2 = new SaleDetailsTableModel(test);
            saleDetails.updateTableModel(tableModel2);
        });

        panel1.add(addToOrderButton, cons);


        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, panel1, saleDetails);

        tabbedPane.addTab("Make a new sale", splitPane);
        JPanel panel2 = new JPanel(new BorderLayout());
        tabbedPane.addTab("Edit an existing sale", panel2);
        panel2.setPreferredSize(new Dimension(600, 300));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));



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

        buttonPanel.add(editButton, BorderLayout.EAST);
        buttonPanel.add(viewButton, BorderLayout.WEST);
        panel2.add(buttonPanel, BorderLayout.SOUTH);

        JLabel text = new JLabel("Please addToOrderButton a sale to edit");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(text, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(existingOrders);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(tabbedPane);
    }

    private ArrayList<String> getSelectedToppings(DrinkTypes type) {
        ArrayList<String> toppingsSelected = new ArrayList<>();
        if(type.equals(DrinkTypes.COFFEE)) {
            for(JCheckBox checkBox : coffeeToppingsCheckBoxes) {
                if(checkBox.isSelected())
                    toppingsSelected.add(checkBox.getText());
            }
        } else if(type.equals(DrinkTypes.TEA)) {
            for(JCheckBox checkBox : teaToppingsCheckBoxes) {
                if(checkBox.isSelected())
                    toppingsSelected.add(checkBox.getText());
            }
        }
        return toppingsSelected;
    }

    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.BOTH;
        cons.weightx = 1;
        cons.weightx = 0.1;
        cons.gridx = 0;
        return cons;
    }
    /**
     * Create the GUI and display it.
     */
    private static void createAndShowGUI() {
        JFrame frame = new JFrame("Final Exam");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(true);
        frame.add(new PointOfSaleGUI(), BorderLayout.CENTER);
        frame.setSize(600, 300);
        frame.pack();
        frame.setVisible(true);
    }

    private static void createMenuOptions() {
        pastries = new ArrayList<>();
        pastries.add(PastryTypes.COOKIE);
        pastries.add(PastryTypes.CROISSANT);
        pastries.add(PastryTypes.MACAROON);

        drinks = new ArrayList<>();
        drinks.add(DrinkTypes.COFFEE);
        drinks.add(DrinkTypes.TEA);



        teaToppingsCheckBoxes = new ArrayList<>();
        teaToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.BOBA.getToppingNames()));
        teaToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.POPPING_BOBA.getToppingNames()));
        teaToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.GRASS_JELLY.getToppingNames()));
        teaToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.LYCHEE_JELLY.getToppingNames()));
        teaToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.PASSIONFRUIT_JELLY.getToppingNames()));
        teaToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.COCONUT_JELLY.getToppingNames()));
        teaToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.STRAWBERRIES.getToppingNames()));


        coffeeToppingsCheckBoxes = new ArrayList<>();
        coffeeToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.WHIPPED_CREAM.toString()));
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

        for(int a = 0; a < itemsInSale2.size() - 1; a++) {
            itemsInSale2.remove(a);
            itemsInSale2.remove(a);
        }
        coupons3.add(new DrinkCoupon());
        Sale sale3 = new Sale(itemsInSale2, coupons3);


        ArrayList<Sale> sales = new ArrayList<>();
        sales.add(sale);
        sales.add(sale2);
        sales.add(sale3);

        return sales;
    }

    public static void main(String[] args) {
        createMenuOptions();
        createAndShowGUI();
    }
}