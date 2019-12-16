package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;

/**
 * The SaleHistoryTable creates a table of
 */
public class SaleHistoryTable extends JTable {

    private ArrayList<Sale> sales;
    public SaleHistoryTable(ArrayList<Sale> sales) {
        this.sales = sales;
        this.getTableHeader().setReorderingAllowed(false);
        SaleTableModel tableModel = new SaleTableModel(sales);
        this.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        this.setModel(tableModel);
        DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
        centerRenderer.setHorizontalAlignment( JLabel.CENTER );
        this.setDefaultRenderer(String.class, centerRenderer);
    }


    public ArrayList<Sale> getSales() {
        return sales;
    }

    void updateTableModel(SaleTableModel tableModel) {
        setModel(tableModel);
        repaint();
    }
}

