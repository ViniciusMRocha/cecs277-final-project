package com.frontend;

import com.bulenkov.darcula.DarculaLaf;

import javax.swing.*;
import javax.swing.plaf.basic.BasicLookAndFeel;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class PointOfSaleGUI extends JPanel {

    private static JFrame orderFrame;

    private PointOfSaleGUI() {
        super(new BorderLayout());
        JTabbedPane tabbedPane = new JTabbedPane();

        JPanel panel1 = new JPanel(new BorderLayout());
        tabbedPane.addTab("Make a new sale", panel1);

        String comboBoxItems[] = {"Drink", "Food"};
        JComboBox cb = new JComboBox(comboBoxItems);
        cb.setEditable(false);
        panel1.add(cb, BorderLayout.NORTH);

        JButton select = new JButton("Text");
        panel1.add(select, BorderLayout.SOUTH);

        JPanel panel2 = new JPanel(new BorderLayout());
        tabbedPane.addTab("Edit an existing sale", panel2);
        tabbedPane.setMnemonicAt(1, KeyEvent.VK_2);
        panel2.setPreferredSize(new Dimension(410, 300));

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBorder(BorderFactory.createTitledBorder("Options"));

        JButton editButton = new JButton("Edit selected order");
        editButton.setEnabled(false);
        editButton.addActionListener(e -> orderFrame.setVisible(true));


        JButton viewButton = new JButton("View selected order");
        viewButton.setEnabled(false);

        buttonPanel.add(editButton, BorderLayout.EAST);
        buttonPanel.add(viewButton, BorderLayout.WEST);
        panel2.add(buttonPanel, BorderLayout.SOUTH);

        JLabel text = new JLabel("Please select a sale to edit");
        text.setHorizontalAlignment(SwingConstants.CENTER);
        panel2.add(text, BorderLayout.NORTH);
        JTable existingOrders = new OrderHistoryTable();
        existingOrders.addMouseListener(new MouseAdapter() {
            public void mousePressed(MouseEvent mouseEvent) {
                JTable table =(JTable) mouseEvent.getSource();
                if (mouseEvent.getClickCount() == 2 && table.getSelectedRow() != -1) {
                    if(!orderFrame.isVisible()) {
                        orderFrame.setVisible(true);
                    }
                }
            }
        });
        existingOrders.getSelectionModel().addListSelectionListener(e -> {
            if(existingOrders.getSelectedRow() == -1) {
                editButton.setEnabled(false);
                viewButton.setEnabled(false);
            } else {
                editButton.setEnabled(true);
                viewButton.setEnabled(false);
                System.out.println("Row #" + existingOrders.getSelectedRow());
            }
        });
        JScrollPane scrollPane = new JScrollPane(existingOrders);
        panel2.add(scrollPane, BorderLayout.CENTER);

        add(tabbedPane);

        //The following line enables to use scrolling tabs.
        tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }

    /**
     * Create the GUI and display it.
     */
    private static void createAndShowGUI() {
        BasicLookAndFeel darculaLookAndFeel = new DarculaLaf();
        try {
            UIManager.setLookAndFeel(darculaLookAndFeel);
        } catch (UnsupportedLookAndFeelException ex) {
            // ups!
        }
        //Create and set up the window.
        JFrame frame = new JFrame("Final Exam");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(new PointOfSaleGUI(), BorderLayout.CENTER);
        orderFrame = new JFrame("Order details");
        orderFrame.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        orderFrame.add(new OrderDetailsWindow(), BorderLayout.CENTER);
        //Display the window.
        orderFrame.pack();
        frame.pack();
        orderFrame.setVisible(false);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}