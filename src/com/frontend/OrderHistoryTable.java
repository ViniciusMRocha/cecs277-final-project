package com.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class OrderHistoryTable extends JTable {
    private boolean ALLOW_ROW_SELECTION = true;

    public OrderHistoryTable(String test) {
        super();
        final String[] columnNames = {"Product name",
                "Addons",
                "etc, etc",
                "Product price"};

        final Object[][] data = {
                {"Coffee", "Sugar, milk", "etc; here", 4.00},
                {"Tea", "Sugar", "more etc; here", 2.00},
        };
        this.setPreferredScrollableViewportSize(new Dimension(600, 70));
        this.setFillsViewportHeight(false);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        for(Object[] entry : data)
            model.addRow(entry);
        this.setModel(model);
    }
    public OrderHistoryTable() {
        super();

        final String[] columnNames = {"Receipt #",
                "Customer name",
                "# of items sold",
                "Total price"};

        final Object[][] data = {
                {123456, "Josh", 6 + " items", 4.00},
                {1234555, "Michael", 4 + " items", 4.50},
                {1234555, "Steve", 2 + " items", 4.50}
        };

        this.setPreferredScrollableViewportSize(new Dimension(600, 70));
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        DefaultTableModel model = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        for(Object[] entry : data)
            model.addRow(entry);
        this.setModel(model);



        if (ALLOW_ROW_SELECTION) {
            ListSelectionModel rowSM = this.getSelectionModel();
            rowSM.addListSelectionListener(e -> {
                if (e.getValueIsAdjusting()) return;
                ListSelectionModel lsm = (ListSelectionModel)e.getSource();
                if (lsm.isSelectionEmpty()) {
                    System.out.println("No rows are selected.");
                } else {
                    int selectedRow = lsm.getMinSelectionIndex();
                    System.out.println("Row " + selectedRow
                            + " is now selected.");
                }
            });
        }
    }



    /**
     * Create the GUI and display it.
     */
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("OrderHistoryTable");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        OrderHistoryTable newContentPane = new OrderHistoryTable();
        frame.setContentPane(newContentPane);
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        createAndShowGUI();
    }
}

