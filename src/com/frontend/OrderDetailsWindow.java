package com.frontend;

import javax.swing.*;
import java.awt.*;

public class OrderDetailsWindow extends JPanel {

    OrderDetailsWindow() {
        super(new BorderLayout());

        JPanel panel2 = new JPanel(new BorderLayout());
        panel2 .setPreferredSize(new Dimension(400, 500));


        JLabel text = new JLabel("Here is your order details");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(text, BorderLayout.NORTH);
        JTable orderDetails = new OrderHistoryTable("hi");
        JScrollPane scrollPane = new JScrollPane(orderDetails);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(panel2);

        //The following line enables to use scrolling tabs.
    }

    /**
     * Create the GUI and display it.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Order Details");
        frame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

        frame.add(new OrderDetailsWindow(), BorderLayout.CENTER);
        //Display the window.
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}