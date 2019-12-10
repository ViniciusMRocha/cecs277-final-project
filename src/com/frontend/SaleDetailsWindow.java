package com.frontend;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;

class SaleDetailsWindow extends JPanel {

    private JTable orderDetails;

    SaleDetailsWindow() {
        super(new BorderLayout());
        orderDetails = new JTable();
        JPanel panel2 = new JPanel(new BorderLayout());
        JLabel text = new JLabel("Here are your order details");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(text, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(orderDetails);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(panel2);
    }

    public JTable getOrderDetails() {
        return orderDetails;
    }

    void updateTableModel(SaleDetailsTableModel tableModel) {
        orderDetails.setModel(tableModel);
        orderDetails.repaint();
    }
}