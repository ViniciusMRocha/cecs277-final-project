package com.frontend;

import com.factory.Product;
import com.factory.drink.Drink;
import com.factory.pastry.Pastry;
import com.sale.Sale;

import javax.swing.table.AbstractTableModel;

public class SaleDetailsTableModel extends AbstractTableModel {

    private Sale sale;
    private String[] columnNames;

    SaleDetailsTableModel(Sale sale) {
        this.sale = sale;
        this.columnNames = new String[]{"Item #", "Item name", "Item details", "Cost"};
    }

    @Override
    public int getRowCount() {
        return sale.getItemsInSale().size();
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
        Product product = sale.getItemsInSale().get(rowIndex);
        switch (columnIndex) {
            case 0:
                value = (rowIndex + 1);
                break;
            case 1:
                if(product instanceof Pastry)
                    value = ((Pastry)product).getName();
                else if(product instanceof Drink)
                    value = ((Drink)product).getName();
                break;
            case 2:
                value = product.getDescription();
                break;
            case 3:
                value = String.format("$%.2f" , sale.getItemsInSale().get(rowIndex).getCost());
                break;
        }
        return value;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return String.class;
    }
}