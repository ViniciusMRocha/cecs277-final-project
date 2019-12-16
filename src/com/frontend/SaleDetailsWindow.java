package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Creates a Sale Details Window
 */
class SaleDetailsWindow extends JPanel {

    private JTable orderDetails;
    private JLabel totalCostLabel;
    private Sale sale;

    /**
     * Creates a Sale Details Window friom a passed sale
     * @param sale Sale
     */
    SaleDetailsWindow(Sale sale) {
        super(new BorderLayout());
        this.sale = sale;
        orderDetails = new JTable();
        System.out.println("Here");
        JPanel panel2 = new JPanel(new BorderLayout());
        totalCostLabel = new JLabel("Order details - Subtotal: " + sale.getTotalPrice());
        totalCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        panel2.add(totalCostLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(orderDetails);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(panel2);
    }

    /**
     * Get the order from a JTable
     * @return JTables
     */
    JTable getOrderDetails() {
        return orderDetails;
    }

    /**
     * Updates the table model
     * @param tableModel SaleDetailsTableModel
     */
    void updateTableModel(SaleDetailsTableModel tableModel) {
        System.out.println("Updated table model!");
        orderDetails.setModel(tableModel);
        orderDetails.repaint();
    }

    /**
     * Sets a passed sale to the current sale
     * @param sale Sale
     */
    public void setSale(Sale sale) {
        this.sale = sale;
    }

    /**
     * Updates the total cost display value
     */
    void updateTotalCostLabel() {
        totalCostLabel.setText("Order details - Subtotal: " + sale.getFormattedTotalPrice());
    }

    /**
     * Resets the window for a new sale to be entered
     */
    void resetWindow() {
        Sale newSale = new Sale();
        sale = newSale;
        //SaleDetailsTableModel sdtm = new SaleDetailsTableModel(newSale);
        //updateTableModel(sdtm);
        updateTotalCostLabel();
    }

    /**
     * Gets the current sale
     * @return Sale
     */
    public Sale getSale() {
        return sale;
    }
}