package com.frontend;

import javax.swing.*;
import java.awt.*;

class OrderDetailsWindow extends JPanel {

    private JTable orderDetails;

    OrderDetailsWindow() {
        super(new BorderLayout());
        orderDetails = new JTable();
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2 .setPreferredSize(new Dimension(400, 500));
        JLabel text = new JLabel("Here are your order details");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(text, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(orderDetails);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(panel2);
    }

    void updateTableModel(SaleDetailsTableModel tableModel) {
        orderDetails.setModel(tableModel);
        orderDetails.repaint();
    }
}