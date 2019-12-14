package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import java.awt.*;

class SaleDetailsWindow extends JPanel {

    private JTable orderDetails;
    private JLabel totalCostLabel;
    private Sale createdSale;

    SaleDetailsWindow() {
        super(new BorderLayout());
        createdSale = new Sale();
        orderDetails = new JTable();

        JPanel panel2 = new JPanel(new BorderLayout());
        totalCostLabel = new JLabel("Order details - Subtotal: " + createdSale.getTotalPrice());
        totalCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        panel2.add(totalCostLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(orderDetails);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(panel2);
    }

    JTable getOrderDetails() {
        return orderDetails;
    }

    void updateTableModel(SaleDetailsTableModel tableModel) {
        orderDetails.setModel(tableModel);
        orderDetails.repaint();
    }

    void updateTotalCostLabel() {
        totalCostLabel.setText("Order details - Subtotal: " + createdSale.getFormattedTotalPrice());
    }

    public Sale getCreatedSale() {
        return createdSale;
    }
}