package com.frontend;


import com.sale.Sale;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SaleTableModel extends AbstractTableModel {

    private ArrayList<Sale> sales;
    private String[] columnNames;

    /**
     * Created the sale table model from a array of sales
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
     * gets the total count for items in a sale
     * @return int
     */
    @Override
    public int getRowCount() {
        return sales.size();
    }

    /**
     * gets the column count for the sale
     * @return int
     */
    @Override
    public int getColumnCount() {
        return 4;
    }

    /**
     * checks if the cell is editable. We set it to false
     * @param row int
     * @param column int
     * @return boolean
     */
    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    /**
     * Prints the column name
     * @param col int
     * @return String
     */
    public String getColumnName(int col) {
        return columnNames[col];
    }

    /**
     * Gets the value of a certain cell with a given row and column
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
     * Gets the class of the a certain column
     * @param columnIndex int
     * @return String
     */
    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}