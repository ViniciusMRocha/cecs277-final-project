package com.frontend;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.Product;
import com.factory.pastry.Pastry;
import com.sale.Sale;

import javax.swing.table.AbstractTableModel;

/**
 * Creates a Sale Details Table Model where we can see the sale and the items regarding the sale
 */
public class SaleDetailsTableModel extends AbstractTableModel {

    private Sale sale;
    private String[] columnNames;

    /**
     * Creates a Sale Details Table Model from a sale
     * @param sale Sale
     */
    SaleDetailsTableModel(Sale sale) {
        this.sale = sale;
        this.columnNames = new String[]{"Item #", "Item name", "Item details", "Price", "Quantity"};
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    /**
     * gets the total count for items in a sale
     * @return int
     */
    @Override
    public int getRowCount() {
        return sale.getItemsInSale().size();
    }

    /**
     * gets the column count for the sale
     * @return int
     */
    @Override
    public int getColumnCount() {
        return 5;
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
                if(product instanceof Pastry)
                    value = product.getQuantity();
                else
                    value = 1;
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
    public Class<?> getColumnClass(int columnIndex) { return String.class; }
}