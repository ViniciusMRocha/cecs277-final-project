package com.frontend;

import com.factory.Product;
import com.factory.drink.Drink;
import com.factory.pastry.Pastry;
import com.sale.Sale;

import javax.swing.table.AbstractTableModel;
import java.awt.event.ActionListener;

/**
 * The class defines how the table will display certain information
 * so the sale object can be displayed on the table.
 */
public class SaleDetailsTableModel extends AbstractTableModel {

    private Sale sale;
    private String[] columnNames;

    /**
     * Displays the sale its going to be displaying details about
     * @param sale Sale
     */
    SaleDetailsTableModel(Sale sale) {
        this.sale = sale;
        this.columnNames = new String[]{"Item #", "Item name", "Item details", "Unit cost", "Quantity"};
    }

    /**
     * Gets the total items in the sale
     * @return int
     */
    @Override
    public int getRowCount() {
        return sale.getItemsInSale().size();
    }

    /**
     * Gets the total column count in the sale grid
     * @return int
     */
    @Override
    public int getColumnCount() {
        return 5;
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
        Product product = sale.getItemsInSale().get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = (rowIndex + 1);
                break;
            case 1:
                value = product.getName();
                break;
            case 2:
                if(!product.getDescription().equals(""))
                    value = product.getDescription();
                else
                    value = "None";
                break;
            case 3:
                value = String.format("$%.2f" , sale.getItemsInSale().get(rowIndex).getCost());
                break;
            case 4:
                value = product.getQuantity();
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
    public Class<?> getColumnClass(int columnIndex) { return String.class; }
}