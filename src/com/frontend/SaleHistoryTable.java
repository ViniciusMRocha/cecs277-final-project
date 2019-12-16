package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.util.ArrayList;

/**
 * The SaleHistoryTable creates a table of Sales
 */
public class SaleHistoryTable extends JTable {

    private ArrayList<Sale> sales;

    /**
     * The SaleHistoryTable creates a table of Sales
     * @param sales ArrayList
     */
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

    /**
     * Adds a sale object the sales array list
     * @param sale
     */
    public void addSaleToArrayList(Sale sale) {
        sales.add(sale);
    }

    /**
     * Gets the sales array list
     * @return ArrayList
     */
    public ArrayList<Sale> getSales() {
        return sales;
    }

    /**
     * Updates the table model from the sale table model
     * @param tableModel SaleTableModel
     */
    void updateTableModel(SaleTableModel tableModel) {
        setModel(tableModel);
        repaint();
    }
}

