package com.frontend;


import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.factory.DrinkTypes;
import com.factory.PastryTypes;
import com.factory.Product;
import com.factory.ProductTypes;
import com.factory.drink.CoffeeTypes;
import com.factory.drink.Drink;
import com.factory.drink.DrinkFactory;
import com.factory.drink.TeaTypes;
import com.factory.pastry.Pastry;
import com.factory.pastry.PastryFactory;
import com.sale.Coupon;
import com.sale.Sale;
import com.sale.coupontypes.DrinkCoupon;
import com.sale.coupontypes.GeneralCoupon;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PointOfSaleGUI extends JPanel {

    private ArrayList<JCheckBox> teaToppingsCheckBoxes;
    private ArrayList<JCheckBox> coffeeToppingsCheckBoxes;
    private JComboBox productDetailsComboBox;
    private JComboBox productTypeComboBox;
    private JPanel toppingsPanel;
    private JComboBox sizeSelectionComboBox;
    private JButton addToOrderButton;

    private Sale createdSale;

    private JComboBox drinkNameComboBox;

    /**
     * Initialize and setup all components to be placed onto the GUI.
     */
    private PointOfSaleGUI() {
        initializeCheckBoxArrayLists();


        JPanel salePanel = initializeSalePanel();

        //Creates a new tabbed pane, titles them, and adds both Panels to it.
        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Create or modify a sale", salePanel);
        JPanel panel2 = new JPanel(new BorderLayout());
        tabbedPane.addTab("View sale history", panel2);
        tabbedPane.setPreferredSize(new Dimension(550, 500));

        //Creates a panel for the buttons on the Order History tab
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));

        //The orderFrame is the window that pops up when the user views their order in the Order History tab
        JFrame orderFrame = new JFrame();
        SaleDetailsWindow orderDetailsPanel = new SaleDetailsWindow();
        orderFrame.add(orderDetailsPanel);
        orderFrame.setVisible(false); //Set it to invisible until it's called by the View button
        orderFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Disposes the frame when it's closed, instead of closing the entire program.

        //Represents all the example sales in the Part 2 PDF
        ArrayList<Sale> sales = createSales();
        JTable existingOrders = new SaleHistoryTable(sales); //Create a new table, and populate the table with the sales

        JButton viewButton = new JButton("View selected order");
        viewButton.setEnabled(false);

        /**
         * This is the short-hand way to write an Action Listener.
         * This Listener waits until the View button is clicked, then it displays the items/details of the sale that's
         * selected in the JTable.
         *
         * This can be done because we're using a custom Table Model. A Table Model basically models the behavior of the table (duh).
         * It lets us choose how each column displays data. In this case, our model takes a Sales object, and applies it to the table.
         *
         * Our model makes each row of the JTable represent an actual Sale object, so they're easy to modify, easy to display, etc;
         */
        viewButton.addActionListener(e -> { //This is a short-hand way to write an Action Listener.
            Sale selectedSale = ((SaleTableModel)existingOrders.getModel()).getSaleAt(existingOrders.getSelectedRow());
            SaleDetailsTableModel model = new SaleDetailsTableModel(selectedSale);
            orderDetailsPanel.updateTableModel(model);
            orderFrame.pack();
            orderFrame.setVisible(true);
        });

        JButton editButton = new JButton("Edit selected order");
        editButton.setEnabled(false);

        /**
         * This ActionListener gets the Selection Model from the table of existing orders, and fires whenever the user
         * selects a different row on the JTable.
         *
         * If the user hasn't selected any row (getSelectedRow() == -1), then disable the buttons, because the buttons try
         * to grab a Sale object from the row. Obviously it would crash because there's no Sale object to grab.
         */
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

        //Wraps the existing orders JTable into a scroll pane, so the user can scroll down if there's too many rows to display in the panel.
        JScrollPane scrollPane = new JScrollPane(existingOrders);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(tabbedPane);
    }

    /**
     * Initializes the first tab of the program for creating a new sale.
     * @return A completed JPanel
     */
    private JPanel initializeSalePanel() {
        JPanel saleInputPanel = new JPanel();
        GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = createGridBagConstraints();
        gbl.setConstraints(saleInputPanel, gbc);
        saleInputPanel.setLayout(gbl);


        //Represents the combobox that lets you choose Drink, or Pastry.
        productTypeComboBox = new JComboBox(new DefaultComboBoxModel(ProductTypes.values()));
        productTypeComboBox.setEditable(false);
        productTypeComboBox.setSelectedIndex(-1);

        //Represents the combobox that lets you choose a size.
        sizeSelectionComboBox = new JComboBox(new DefaultComboBoxModel(Drink.Size.values()));

        //The drinkaName combobox displays the specific names of all products. (e.g. "Hazelnut Latte", "Milk Tea")
        drinkNameComboBox = new JComboBox();
        productDetailsComboBox = new JComboBox();

        //Set them to invisible until they're needed
        drinkNameComboBox.setVisible(false);
        sizeSelectionComboBox.setVisible(false);
        productDetailsComboBox.setVisible(false);

        productTypeComboBox.addActionListener(new ProductTypeActionListener());

        saleInputPanel.add(productTypeComboBox, gbc);
        saleInputPanel.add(productDetailsComboBox, gbc);
        saleInputPanel.add(sizeSelectionComboBox, gbc);
        saleInputPanel.add(drinkNameComboBox, gbc);

        toppingsPanel = new JPanel();
        toppingsPanel.setVisible(false);
        toppingsPanel.setBorder(BorderFactory.createTitledBorder("Available toppings"));
        toppingsPanel.setLayout(new GridLayout(3,2));

        productDetailsComboBox.addActionListener(new ProductDetailsActionListener());

        saleInputPanel.add(toppingsPanel, gbc);

        createdSale = new Sale();

        //This is the Panel for the JTable that displays the items you are purchasing (on the sale creation tab)
        SaleDetailsWindow saleDetails = new SaleDetailsWindow();
        SaleDetailsTableModel saleDetailsTableModel = new SaleDetailsTableModel(createdSale);
        saleDetails.updateTableModel(saleDetailsTableModel);

        addToOrderButton = new JButton("Add to order");
        addToOrderButton.setEnabled(false);
        /**
         * When you add your completed order, it creates a new Product object according to the data you've selected from
         * the previous components above.
         *
         * Not yet complete. Still need Pastry support and coupon handling.
         */
        addToOrderButton.addActionListener(e -> {
            DrinkFactory drinkFactory = new DrinkFactory();
            PastryFactory pastryFactory = new PastryFactory();
            ProductTypes finalType = (ProductTypes)productTypeComboBox.getModel().getSelectedItem();
            ArrayList<Product> items = new ArrayList<>();


            if(finalType.equals(ProductTypes.DRINK)) {
                String drinkName = drinkNameComboBox.getSelectedItem().toString();
                DrinkTypes type = (DrinkTypes)productDetailsComboBox.getSelectedItem();
                Drink.Size size = (Drink.Size)sizeSelectionComboBox.getModel().getSelectedItem();
                ArrayList<DrinkToppings> toppings = getSelectedToppings(type);
                System.out.println("Toppings selected: " + toppings);
                Product drinkProduct = drinkFactory.createProduct(drinkName, type, size, toppings, Drink.Sweetness.NO_SUGAR, Drink.Milk.NO_MILK);
                items.add(drinkProduct);
                createdSale.addToSale(drinkProduct, null);
            }

            SaleDetailsTableModel tableModel2 = new SaleDetailsTableModel(createdSale);
            saleDetails.updateTableModel(tableModel2);
        });
        saleInputPanel.add(addToOrderButton, gbc);

        //Create a scrollPane for the saleInput panel on the first tab. If there's too many components that appear, a scrollbar appears.
        JScrollPane saleInputScrollPanee = new JScrollPane(saleInputPanel);
        JPanel panel = new JPanel();
        saleInputPanel.setPreferredSize(new Dimension(550, 250));
        saleDetails.setPreferredSize(new Dimension(550, 250));
        panel.setPreferredSize(new Dimension(550, 550));

        panel.add(saleInputScrollPanee, gbc);
        panel.add(saleDetails, gbc);

        return panel;
    }

    /**
     * Gets an ArrayList of toppings from the JCheckBoxes that the user selected.
     * @param type What type of Drink the user is purchasing.
     * @return
     */
    private ArrayList<DrinkToppings> getSelectedToppings(DrinkTypes type) {
        ArrayList<DrinkToppings> toppingsSelected = new ArrayList<>();
        if(type.equals(DrinkTypes.COFFEE)) {
            for(JCheckBox checkBox : coffeeToppingsCheckBoxes) {
                if(checkBox.isSelected())
                    toppingsSelected.add(DrinkToppings.getEnumValueFromString(checkBox.getText()));
            }
        } else if(type.equals(DrinkTypes.TEA)) {
            for(JCheckBox checkBox : teaToppingsCheckBoxes) {
                if(checkBox.isSelected())
                    toppingsSelected.add(DrinkToppings.getEnumValueFromString(checkBox.getText()));
            }
        }
        return toppingsSelected;
    }

    /**
     * This method sets a number of constants for the GridBagLayoutManager. This basically conttrols how the components
     * display on the panel.
     * @return
     */
    private GridBagConstraints createGridBagConstraints() {
        GridBagConstraints cons = new GridBagConstraints();
        cons.fill = GridBagConstraints.HORIZONTAL;
        cons.weightx = 1;
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
        frame.add(new PointOfSaleGUI());
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Initializes ArrayLists for the Tea toppings and Coffee toppings.
     */
    private void initializeCheckBoxArrayLists() {
        teaToppingsCheckBoxes = new ArrayList<>();
        for(DrinkToppings teaToppings : DrinkToppings.values()) {
            if(!teaToppings.equals(DrinkToppings.WHIPPED_CREAM))
                teaToppingsCheckBoxes.add(new JCheckBox(teaToppings.toString()));
        }

        coffeeToppingsCheckBoxes = new ArrayList<>();
        coffeeToppingsCheckBoxes.add(new JCheckBox(DrinkToppings.WHIPPED_CREAM.toString()));
    }

    /**
     * createSales() creates all example sales given in the Part 2 PDF.
     * @return an ArrayList of all Sales.
     */
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

        coupons3.add(new DrinkCoupon());
        Sale sale3 = new Sale(itemsInSale, coupons3);


        ArrayList<Sale> sales = new ArrayList<>();
        sales.add(sale);
        sales.add(sale2);
        sales.add(sale3);

        return sales;
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }

    /**
     * The ProductDetailsActionListener waits until the user has selected what type of Drink they want to purchase.
     * (Either coffee or tea). And updates the panel to provide options for the user to finish the sale. (Toppings, drink name,
     * sweetness, milk type, etc)
     *
     * This also needs to be updated for pastries.
     */
    class ProductDetailsActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if (productTypeComboBox.getModel().getSelectedItem().equals(ProductTypes.DRINK)) {
                if (productDetailsComboBox.getSelectedIndex() == -1) {
                    sizeSelectionComboBox.setVisible(false);
                    toppingsPanel.setVisible(false);
                    addToOrderButton.setEnabled(false);
                    drinkNameComboBox.setVisible(false);
                    return;
                }

                toppingsPanel.removeAll();
                if (productDetailsComboBox.getSelectedItem().equals(DrinkTypes.COFFEE)) {
                    drinkNameComboBox.setModel(new DefaultComboBoxModel(CoffeeTypes.values()));
                    for (JCheckBox toppingCheckBox : coffeeToppingsCheckBoxes) {
                        toppingsPanel.add(toppingCheckBox);
                    }
                } else if (productDetailsComboBox.getSelectedItem().equals(DrinkTypes.TEA)) {
                    drinkNameComboBox.setModel(new DefaultComboBoxModel(TeaTypes.values()));
                    for (JCheckBox toppingCheckBox : teaToppingsCheckBoxes) {
                        toppingsPanel.add(toppingCheckBox);
                    }
                }

                drinkNameComboBox.revalidate();
                drinkNameComboBox.repaint();
                toppingsPanel.revalidate();
                toppingsPanel.repaint();
                drinkNameComboBox.setVisible(true);
                toppingsPanel.setVisible(true);
                sizeSelectionComboBox.setVisible(true);
                addToOrderButton.setEnabled(true);
            } else if(productTypeComboBox.getModel().getSelectedItem().equals(ProductTypes.PASTRY)) {
                //This area is where thee Pastry implementation will happen.
                sizeSelectionComboBox.setVisible(false);
                toppingsPanel.setVisible(false);
                addToOrderButton.setEnabled(false);
                drinkNameComboBox.setVisible(false);

            }
        }
    }

    /**
     * This Listener is invoked when the user selects a Product type (Either Drink or Pastry) from the JCombobox.
     * Depending on what they chose, new components become visible for the user to finish their transaction.
     */
    class ProductTypeActionListener implements ActionListener {
        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if(productTypeComboBox.getSelectedItem().equals(ProductTypes.DRINK)) {
                productDetailsComboBox.setModel(new DefaultComboBoxModel(DrinkTypes.values()));
                productDetailsComboBox.setSelectedIndex(-1);
                productDetailsComboBox.setVisible(true);
            } else if(productTypeComboBox.getSelectedItem().equals(ProductTypes.PASTRY)) {
                productDetailsComboBox.setModel(new DefaultComboBoxModel(PastryTypes.values()));
                productDetailsComboBox.setSelectedIndex(-1);
                productDetailsComboBox.setVisible(true);
            }
        }
    }
}