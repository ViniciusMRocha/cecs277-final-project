package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

/**
 * Creates a sale detail window where the user can add products and view their subtotal
 */
class SaleDetailsWindow extends JPanel {

    private JTable orderDetails;
    private JLabel totalCostLabel;
    private Sale sale;


    /**
     * Constructor for the sale window
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
     * Gets the order detail in a JTable
     * @return JTable
     */
    JTable getOrderDetails() {
        return orderDetails;
    }

    /**
     * Refreshes the table when a change is made. Usually when a new product is added.
     * @param tableModel JTable
     */
    void updateTableModel(SaleDetailsTableModel tableModel) {
        orderDetails.setModel(tableModel);
        orderDetails.repaint();
    }

    /**
     * Updates the running subtotal
     */
    void updateTotalCostLabel() {
        totalCostLabel.setText("Order details - Subtotal: " + sale.getFormattedTotalPrice());
    }

    void resetWindow() {

        SaleDetailsTableModel sdtm = new SaleDetailsTableModel(sale);
        updateTableModel(sdtm);
        updateTotalCostLabel();
    }

    /**
     * Gets the current sale
     * @return Sale
     */
    public Sale getCreatedSale() {
        return sale;
    }
}