package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

class SaleDetailsWindow extends JPanel {

    private JTable orderDetails;
    private JLabel tableHeaderJLabel;
    private Sale createdSale;

    SaleDetailsWindow() {
        super(new BorderLayout());
        createdSale = new Sale();
        orderDetails = new JTable();

        JPanel panel2 = new JPanel(new BorderLayout());
        tableHeaderJLabel = new JLabel("Order details - Total: " + createdSale.getTotalPrice());
        tableHeaderJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        panel2.add(tableHeaderJLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(orderDetails);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(panel2);
    }

    JTable getOrderDetails() {
        return orderDetails;
    }

    public JLabel getTableHeaderJLabel() {
        return tableHeaderJLabel;
    }

    void updateTableModel(SaleDetailsTableModel tableModel) {
        orderDetails.setModel(tableModel);
        orderDetails.repaint();
    }

    void updateJLabelHeader() {
        tableHeaderJLabel.setText("Order details - Total: " + createdSale.getFormattedTotalPrice());
        tableHeaderJLabel.revalidate();
    }

    public Sale getCreatedSale() {
        return createdSale;
    }
}