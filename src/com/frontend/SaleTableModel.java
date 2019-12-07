package com.frontend;


import com.sale.Sale;

import javax.swing.table.AbstractTableModel;
import java.util.ArrayList;

public class SaleTableModel extends AbstractTableModel {

    private ArrayList<Sale> sales;
    private String[] columnNames;

    public SaleTableModel(ArrayList<Sale> sales) {
        this.sales = sales;
        String[] columnNames = {"Receipt #", "Coupons used", "Items in sale", "Total price"};
        this.columnNames = columnNames;
    }

    /**
     * Returns the Product at a specified row
     * @param row The row to return the Product object
     * @return the Product
     */
    public Sale getSaleAt(int row) {
        return sales.get(row);
    }

    @Override
    public int getRowCount() {
        return sales.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

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

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}