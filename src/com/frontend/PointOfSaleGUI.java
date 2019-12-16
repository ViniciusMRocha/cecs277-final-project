package com.frontend;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.factory.*;
import com.factory.drink.Drink;
import com.factory.drink.DrinkFactory;
import com.factory.drink.TeaTypes;
import com.factory.drink.coffee.CoffeeTypes;
import com.factory.drink.milkcoffees.MilkCoffeeTypes;
import com.factory.pastry.*;
import com.factory.pastry.cookies.CookieTypes;
import com.factory.pastry.croissants.Croissant;
import com.factory.pastry.croissants.CroissantTypes;
import com.factory.pastry.macaroons.MacaroonTypes;
import com.sale.Sale;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


/**
 * PointOfSaleGUI runs the main application for the "Cha-cha-cha Time!" coffeehouse,
 * initializing all the Components that are used on the frame.
 */
public class PointOfSaleGUI extends JPanel {

    private ArrayList<JCheckBox> teaToppingsCheckBoxes;
    private ArrayList<JCheckBox> coffeeToppingsCheckBoxes;
    private JComboBox productDetailsComboBox;
    private JComboBox productTypeComboBox;
    private JPanel toppingsPanel;
    private JComboBox sizeSelectionComboBox;
    private JComboBox milkSelectionComboBox;
    private JComboBox sweetSelectionComboBox;
    private JButton addToOrderButton;
    private JButton removeOrderButton;
    private JButton proceedToPaymentButton;

    private PaymentPanel paymentPanel;
    private SaleDetailsWindow saleDetails;

    private JComboBox productNameComboBox;
    private JTabbedPane tabbedPane;
    private JSpinner quantitySelectionSpinner;

    private JCheckBox heatCroissantCheckBox;
    private Sale createdSale;

    private JPanel saleInputPanel;

    /**
     * Initialize and setup all components to be placed onto the GUI.
     */
    private PointOfSaleGUI() {
        initializeCheckBoxArrayLists();
        setLayout(new BorderLayout());

        JPanel salePanel = initializeSalePanel();

        //Creates a new tabbed pane, titles them, and adds both Panels to it.
        tabbedPane = new JTabbedPane();
        tabbedPane.addTab("1) Create or modify a sale", salePanel);

        ArrayList<Sale> dailySales = new ArrayList<>();

        SaleHistoryTable existingOrders = new SaleHistoryTable(dailySales); //Create a new table, and populate the table with the dailySales

        paymentPanel = new PaymentPanel(createdSale, existingOrders, saleDetails);
        tabbedPane.add("2) Finalize sale", paymentPanel);

        JPanel saleHistoryPanel = new JPanel(new BorderLayout());
        tabbedPane.addTab("3) View sale history", saleHistoryPanel);

        tabbedPane.setPreferredSize(new Dimension(550, 500));
        tabbedPane.setEnabledAt(1, false);
        //Creates a panel for the buttons on the Order History tab
        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));

        //The orderFrame is the window that pops up when the user views their order in the Order History tab
        JFrame orderFrame = new JFrame();
        SaleDetailsWindow orderDetailsPanel = new SaleDetailsWindow(new Sale());
        orderFrame.add(orderDetailsPanel);
        orderFrame.setVisible(false); //Set it to invisible until it's called by the View button
        orderFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE); //Disposes the frame when it's closed, instead of closing the entire program.

        //Represents all the example dailySales in the Part 2 PDF

        JButton viewButton = new JButton("View selected order");
        JButton makeNewSaleButton = new JButton("Make a new sale");

        makeNewSaleButton.addActionListener(e -> {
            //createdSale = new Sale();
            saleDetails.resetWindow();
            saleDetails.repaint();
            tabbedPane.setEnabledAt(0, true);
            tabbedPane.setEnabledAt(1, false);
            tabbedPane.setSelectedIndex(0);
        });

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

        JButton findSaleButton = new JButton("Get order by receipt number");
        findSaleButton.setEnabled(false);


        findSaleButton.addActionListener(e -> {
            int receiptNumber;
            try {
                 receiptNumber = Integer.parseInt(JOptionPane.showInputDialog("Please enter the receipt number for the sale"));
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, "The number you entered wasn't valid!");
                return;
            }
            for(Sale sale : dailySales) {
                if(receiptNumber == sale.getReceiptNumber()) {
                    SaleDetailsTableModel model = new SaleDetailsTableModel(sale);
                    orderDetailsPanel.updateTableModel(model);
                    orderFrame.pack();
                    orderFrame.setVisible(true);
                    return;
                }
            }
        });

        /**
         * This ActionListener gets the Selection Model from the table of existing orders, and fires whenever the user
         * selects a different row on the JTable.
         *
         * If the user hasn't selected any row (getSelectedRow() == -1), then disable the buttons, because the buttons try
         * to grab a Sale object from the row. Obviously it would crash because there's no Sale object to grab.
         */
        existingOrders.getSelectionModel().addListSelectionListener(e -> {
            if(existingOrders.getSelectedRow() == -1) {
                findSaleButton.setEnabled(false);
                viewButton.setEnabled(false);
            } else {
                findSaleButton.setEnabled(true);
                viewButton.setEnabled(true);
            }
        });

        buttonPanel.add(findSaleButton, BorderLayout.EAST);
        buttonPanel.add(makeNewSaleButton, BorderLayout.EAST);
        buttonPanel.add(viewButton, BorderLayout.WEST);
        saleHistoryPanel.add(buttonPanel, BorderLayout.SOUTH);

        JLabel text = new JLabel("Sales for the day");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        saleHistoryPanel.add(text, BorderLayout.NORTH);

        //Wraps the existing orders JTable into a scroll pane, so the user can scroll down if there's too many rows to display in the panel.
        JScrollPane scrollPane = new JScrollPane(existingOrders);
        saleHistoryPanel.add(scrollPane, BorderLayout.CENTER);
        add(tabbedPane);
    }

    /**
     * Initializes the first tab of the program for creating a new sale.
     * @return The JPanel that is placed on the first tab of the tabbedPane
     */
    private JPanel initializeSalePanel() {
        saleInputPanel = new JPanel();

        toppingsPanel = new JPanel();
        toppingsPanel.setVisible(false);
        toppingsPanel.setBorder(BorderFactory.createTitledBorder("Available toppings"));
        toppingsPanel.setLayout(new GridLayout(3,2));

        saleInputPanel.setBorder(BorderFactory.createTitledBorder("Select a product to add to your order"));
        saleInputPanel.setLayout(new BoxLayout(saleInputPanel, BoxLayout.PAGE_AXIS));

        productTypeComboBox = new JComboBox(new DefaultComboBoxModel(ProductTypes.values()));
        productTypeComboBox.setEditable(false);
        productTypeComboBox.setSelectedIndex(-1);

        heatCroissantCheckBox = new JCheckBox("Would you like to heat your croissant? (+$0.50)");
        heatCroissantCheckBox.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Represents the combobox that lets you choose a size.
        sizeSelectionComboBox = new JComboBox(new DefaultComboBoxModel(Drink.Size.values()));

        //Represents the comboBox that lets you choose the quantity of milk
        milkSelectionComboBox = new JComboBox(new DefaultComboBoxModel(Drink.Milk.values()));

        //Represents the comboBox that lets you choose the level of sweetness
        sweetSelectionComboBox = new JComboBox(new DefaultComboBoxModel(Drink.Sweetness.values()));

        //The drinkaName combobox displays the specific names of all products. (e.g. "Hazelnut Latte", "Milk Tea")
        productNameComboBox = new JComboBox();
        productDetailsComboBox = new JComboBox();
        quantitySelectionSpinner = new JSpinner();
        SpinnerNumberModel snm = new SpinnerNumberModel(1, 1, 5000, 1);
        quantitySelectionSpinner.setModel(snm);

        //Set them to invisible until they're needed
        quantitySelectionSpinner.setVisible(false);
        productNameComboBox.setVisible(false);
        sizeSelectionComboBox.setVisible(false);
        milkSelectionComboBox.setVisible(false);
        sweetSelectionComboBox.setVisible(false);
        productDetailsComboBox.setVisible(false);
        heatCroissantCheckBox.setVisible(false);

        productTypeComboBox.addActionListener(new ProductTypeActionListener());

        saleInputPanel.add(productTypeComboBox);
        saleInputPanel.add(productDetailsComboBox);
        saleInputPanel.add(sizeSelectionComboBox);
        saleInputPanel.add(milkSelectionComboBox);
        saleInputPanel.add(sweetSelectionComboBox);
        saleInputPanel.add(productNameComboBox);
        saleInputPanel.add(quantitySelectionSpinner);
        saleInputPanel.add(toppingsPanel);
        saleInputPanel.add(heatCroissantCheckBox);

        productDetailsComboBox.addActionListener(new ProductDetailsActionListener());

        //This is the Panel for the JTable that displays the items you are purchasing (on the sale creation tab)
        saleDetails = new SaleDetailsWindow(new Sale());
        createdSale = saleDetails.getSale();

        SaleDetailsTableModel saleDetailsTableModel = new SaleDetailsTableModel(createdSale);
        saleDetails.updateTableModel(saleDetailsTableModel);

        saleDetails.getOrderDetails().getSelectionModel().addListSelectionListener(listSelectionEvent -> {
            if(saleDetails.getOrderDetails().getSelectedRow() != -1)
                removeOrderButton.setEnabled(true);
            else
                removeOrderButton.setEnabled(false);
        });

        saleDetails.getOrderDetails().addPropertyChangeListener(evt -> {
            saleDetails.updateTotalCostLabel();
            if(saleDetailsTableModel.getRowCount() > 0)
                proceedToPaymentButton.setEnabled(true);
            else
                proceedToPaymentButton.setEnabled(false);
        });

        addToOrderButton = new JButton("Add to order");
        removeOrderButton = new JButton("Remove from order");
        proceedToPaymentButton = new JButton("Proceed to payment");
        proceedToPaymentButton.addActionListener(e -> {
            tabbedPane.setEnabledAt(1, true);
            tabbedPane.setEnabledAt(0, false);
            tabbedPane.setSelectedIndex(1);
            paymentPanel.setTotalDueLabel(createdSale);
        });

        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));

        buttonPanel.add(addToOrderButton);
        buttonPanel.add(removeOrderButton);
        buttonPanel.add(proceedToPaymentButton);

        addToOrderButton.setEnabled(false);
        removeOrderButton.setEnabled(false);
        //proceedToPaymentButton.setEnabled(false);

        removeOrderButton.addActionListener(actionEvent -> {
            createdSale.removeFromSale(saleDetails.getOrderDetails().getSelectedRow());
            SaleDetailsTableModel newSaleDetailsModel = new SaleDetailsTableModel(createdSale);
            saleDetails.updateTotalCostLabel();
            saleDetails.updateTableModel(newSaleDetailsModel);
        });
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
            int quantity = (int)quantitySelectionSpinner.getValue();


            if(finalType.equals(ProductTypes.DRINK)) {
                String drinkName = productNameComboBox.getSelectedItem().toString();
                ArrayList<DrinkToppings> toppings;
                if(productNameComboBox.getSelectedItem() instanceof TeaTypes)
                    toppings = getSelectedToppings(DrinkTypes.TEA);
                else
                    toppings = getSelectedToppings(DrinkTypes.COFFEE);

                Object type = productNameComboBox.getSelectedItem();
                Drink.Size size = (Drink.Size)sizeSelectionComboBox.getModel().getSelectedItem();
                Drink.Milk Milk = (Drink.Milk)milkSelectionComboBox.getModel().getSelectedItem();

                Drink.Sweetness sweetness = (Drink.Sweetness)sweetSelectionComboBox.getModel().getSelectedItem();

                Product drinkProduct = drinkFactory.createProduct(drinkName, type, size, toppings, sweetness, Milk, quantity);

                createdSale.addToSale(drinkProduct);
                items.add(drinkProduct);

            } else if(finalType.equals(ProductTypes.PASTRY)) {
                String pastryName = productNameComboBox.getSelectedItem().toString();
                Object type = productNameComboBox.getSelectedItem();
                Croissant.HeatState croissantHeated;

                if(heatCroissantCheckBox.isSelected())
                    croissantHeated = Pastry.HeatState.HEATED;
                else
                    croissantHeated = Pastry.HeatState.COLD;

                Product pastryProduct = pastryFactory.createProduct(pastryName, type, quantity, croissantHeated, 0, 0, 0);
                createdSale.addToSale(pastryProduct);
                items.add(pastryProduct);
            }

            SaleDetailsTableModel updatedTableModel = new SaleDetailsTableModel(createdSale);
            saleDetails.updateTableModel(updatedTableModel);
        });
        saleInputPanel.add(buttonPanel);

        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.PAGE_AXIS));
        panel.add(saleInputPanel, BoxLayout.X_AXIS);
        panel.add(saleDetails, BoxLayout.X_AXIS);
        return panel;
    }

    /**
     * Gets an ArrayList of toppings from the JCheckBoxes that the user selected.
     * @param type What type of Drink the user is purchasing.
     * @return An ArrayList of DrinkToppings that the user selected.
     */
    private ArrayList<DrinkToppings> getSelectedToppings(DrinkTypes type) {
        ArrayList<DrinkToppings> toppingsSelected = new ArrayList<>();
        if(type.equals(DrinkTypes.COFFEE) || type.equals(DrinkTypes.MILK_COFFEE)) {
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
            if (productDetailsComboBox.getSelectedIndex() == -1) {
                sizeSelectionComboBox.setVisible(false);
                milkSelectionComboBox.setVisible(false);
                sweetSelectionComboBox.setVisible(false);
                toppingsPanel.setVisible(false);
                addToOrderButton.setEnabled(false);
                productNameComboBox.setVisible(false);
                quantitySelectionSpinner.setVisible(false);
                heatCroissantCheckBox.setVisible(false);
                return;
            }

            if (productTypeComboBox.getModel().getSelectedItem().equals(ProductTypes.DRINK)) {
                sweetSelectionComboBox.setVisible(false);
                toppingsPanel.removeAll();

                if (productDetailsComboBox.getSelectedItem().equals(DrinkTypes.COFFEE)) {
                    productNameComboBox.setModel(new DefaultComboBoxModel(CoffeeTypes.values()));
                    for (JCheckBox toppingCheckBox : coffeeToppingsCheckBoxes)
                        toppingsPanel.add(toppingCheckBox);
                } else if (productDetailsComboBox.getSelectedItem().equals(DrinkTypes.MILK_COFFEE)) {
                    productNameComboBox.setModel(new DefaultComboBoxModel(MilkCoffeeTypes.values()));
                    for (JCheckBox toppingCheckBox : coffeeToppingsCheckBoxes)
                        toppingsPanel.add(toppingCheckBox);
                } else if (productDetailsComboBox.getSelectedItem().equals(DrinkTypes.TEA)) {
                    sweetSelectionComboBox.setVisible(true);
                    productNameComboBox.setModel(new DefaultComboBoxModel(TeaTypes.values()));
                    for (JCheckBox toppingCheckBox : teaToppingsCheckBoxes)
                        toppingsPanel.add(toppingCheckBox);
                }

                productNameComboBox.setVisible(true);
                toppingsPanel.setVisible(true);
                sizeSelectionComboBox.setVisible(true);
                milkSelectionComboBox.setVisible(true);
                addToOrderButton.setEnabled(true);
                quantitySelectionSpinner.setVisible(true);
            } else if(productTypeComboBox.getModel().getSelectedItem().equals(ProductTypes.PASTRY)) {
                //This area is where thee Pastry implementation will happen.
                sizeSelectionComboBox.setVisible(false);
                milkSelectionComboBox.setVisible(false);
                sweetSelectionComboBox.setVisible(false);
                toppingsPanel.setVisible(false);
                productNameComboBox.setVisible(true);
                quantitySelectionSpinner.setVisible(true);
                addToOrderButton.setEnabled(true);
                heatCroissantCheckBox.setVisible(false);

                if(productDetailsComboBox.getSelectedItem().equals(PastryTypes.CROISSANT)) {
                    productNameComboBox.setModel(new DefaultComboBoxModel(CroissantTypes.values()));
                    heatCroissantCheckBox.setVisible(true);
                } else if(productDetailsComboBox.getSelectedItem().equals(PastryTypes.COOKIE)) {
                    productNameComboBox.setModel(new DefaultComboBoxModel(CookieTypes.values()));
                } else if(productDetailsComboBox.getSelectedItem().equals(PastryTypes.MACAROON)) {
                    productNameComboBox.setModel(new DefaultComboBoxModel(MacaroonTypes.values()));
                }
            }
        }
    }


    /**
     * This Listener is invoked when the user selects a Product type (Either Drink or Pastry) from the JCombobox.
     * Depending on what they chose, new components become visible for the user to finish their transaction.
     */
    class ProductTypeActionListener implements ActionListener {

        private Object lastSelectedItem;
        /**
         * The actionPereformed(ActionEvent) method is executed when the ActionListener is called.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            if((lastSelectedItem != null) && (lastSelectedItem.equals(productTypeComboBox.getSelectedItem())))
                return;

            if(productTypeComboBox.getSelectedItem().equals(ProductTypes.DRINK)) {
                productDetailsComboBox.setModel(new DefaultComboBoxModel(DrinkTypes.values()));
                productDetailsComboBox.setSelectedIndex(-1);
                productDetailsComboBox.setVisible(true);
            } else if(productTypeComboBox.getSelectedItem().equals(ProductTypes.PASTRY)) {
                productDetailsComboBox.setModel(new DefaultComboBoxModel(PastryTypes.values()));
                productDetailsComboBox.setSelectedIndex(-1);
                productDetailsComboBox.setVisible(true);
            }
            lastSelectedItem = productTypeComboBox.getSelectedItem();
        }
    }
}