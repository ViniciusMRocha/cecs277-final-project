package com.frontend;


import com.sale.Sale;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

/**
 * The class defines how the table will display certain information
 * so the sale object can be displayed on the table.
 */
public class SaleTableModel extends AbstractTableModel {

    private ArrayList<Sale> sales;
    private String[] columnNames;

    /**
     * Displays the sale its going to be displaying details about
     * @param sales Sale
     */
    public SaleTableModel(ArrayList<Sale> sales) {
        this.sales = sales;
        String[] columnNames = {"Receipt #", "Coupons used", "Items in sale", "Total price"};
        this.columnNames = columnNames;
    }

    /**
     * Returns the Product at a specified row
     * @param row int
     * @return Sale
     */
    public Sale getSaleAt(int row) {
        return sales.get(row);
    }

    /**
     * Gets the total items in the sale
     * @return int
     */
    @Override
    public int getRowCount() {
        return sales.size();
    }

    /**
     * Gets the total column count in the sale grid
     * @return int
     */
    @Override
    public int getColumnCount() {
        return 4;
    }

    /**
     * Checkes if the sell si editable. We set it to false since the grid is view only
     * @param row int
     * @param column int
     * @return boolean
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * Gets the column name of the sale grid
     * @param col int
     * @return String
     */
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * Get the value at a specific cell in the sale grid
     * @param rowIndex int
     * @param columnIndex int
     * @return Object
     */
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        Object value = "";
        Sale sale = sales.get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = sale.getReceiptNumber();
                break;
            case 1:
                value = sale.couponsUsed();
                break;
            case 2:
                value = sale.getItemsInSale().size() + " items";
                break;
            case 3:
                value = String.format("$%.2f" , sale.getTotalPrice());
                break;
        }
        return value;
    }

    /**
     * Get the class of a column in the sale grid
     * @param columnIndex int
     * @return String
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}