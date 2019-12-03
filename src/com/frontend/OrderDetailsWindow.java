package com.frontend;

import javax.swing.*;
import java.awt.*;

class OrderDetailsWindow extends JPanel {

    OrderDetailsWindow() {
        super(new BorderLayout());
        JPanel panel2 = new JPanel(new BorderLayout());
        panel2 .setPreferredSize(new Dimension(400, 500));
        JLabel text = new JLabel("Here is your order details");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(text, BorderLayout.NORTH);
        JTable orderDetails = new OrderHistoryTable();
        JScrollPane scrollPane = new JScrollPane(orderDetails);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(panel2);
    }
}