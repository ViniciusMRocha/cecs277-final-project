package com.frontend;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

class OrderHistoryTable extends JTable {
    OrderHistoryTable() {
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

        ListSelectionModel rowSM = this.getSelectionModel();
        rowSM.addListSelectionListener(e -> {
            if (e.getValueIsAdjusting()) return;
            ListSelectionModel lsm = (ListSelectionModel)e.getSource();
            if (lsm.isSelectionEmpty()) {
                System.out.println("No rows are selected.");
            } else { //Used for getting the currently selected row.
                int selectedRow = lsm.getMinSelectionIndex();
                System.out.println("Row " + selectedRow
                        + " is now selected.");
            }
        });
    }
}

