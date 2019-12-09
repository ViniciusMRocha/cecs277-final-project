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

    private JFrame orderFrame;
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
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel salePanel = initializeSalePanel();
        tabbedPane.addTab("Create or modify a sale", salePanel);
        JPanel panel2 = new JPanel(new BorderLayout());
        tabbedPane.addTab("View sale history", panel2);
        tabbedPane.setPreferredSize(new Dimension(550, 500));
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));

        orderFrame = new JFrame();
        SaleDetailsWindow orderDetailsPanel = new SaleDetailsWindow();
        orderFrame.add(orderDetailsPanel);
        orderFrame.setVisible(false);
        orderFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

        ArrayList<Sale> sales = createSales();
        JTable existingOrders = new SaleHistoryTable(sales);

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

        productTypeComboBox = new JComboBox(new DefaultComboBoxModel(ProductTypes.values()));
        productTypeComboBox.setEditable(false);
        productTypeComboBox.setSelectedIndex(-1);

        sizeSelectionComboBox = new JComboBox(new DefaultComboBoxModel(Drink.Size.values()));
        drinkNameComboBox = new JComboBox();
        drinkNameComboBox.setVisible(false);
        sizeSelectionComboBox.setVisible(false);

        productDetailsComboBox = new JComboBox();
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

        SaleDetailsWindow saleDetails = new SaleDetailsWindow();
        SaleDetailsTableModel tableModel = new SaleDetailsTableModel(createdSale);
        saleDetails.updateTableModel(tableModel);

        addToOrderButton = new JButton("Add to order");
        addToOrderButton.setEnabled(false);
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