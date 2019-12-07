package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;
import java.util.ArrayList;

public class OrderHistoryTable extends JTable {
    public OrderHistoryTable(ArrayList<Sale> sales) {
        super();
        this.getTableHeader().setReorderingAllowed(false);
        SaleTableModel tableModel = new SaleTableModel(sales);
        this.setPreferredScrollableViewportSize(new Dimension(600, 70));
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(tableModel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        this.setDefaultRenderer(String.class, centerRenderer);

    }

    public OrderHistoryTable(Sale sales) {
        super();
        this.getTableHeader().setReorderingAllowed(false);
        SaleDetailsTableModel tableModel = new SaleDetailsTableModel(sales);

        this.setPreferredScrollableViewportSize(new Dimension(600, 70));
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(tableModel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        this.setDefaultRenderer(Sale.class, centerRenderer);

    }
}

