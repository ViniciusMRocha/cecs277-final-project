package com.frontend;

import com.decorator.toppings.drinktoppings.Toppings;
import com.factory.Product;
import com.sale.Sale;

import javax.swing.table.AbstractTableModel;

public class SaleDetailsTableModel extends AbstractTableModel {

    private Sale sale;
    private String[] columnNames;

    SaleDetailsTableModel(Sale sale) {
        this.sale = sale;
        this.columnNames = new String[]{"Item #", "Item name", "Item details", "Price", "Quantity"};
    }

    @Override
    public int getRowCount() {
        return sale.getItemsInSale().size();
    }

    @Override
    public int getColumnCount() {
        return 5;
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
                    if(product instanceof Toppings) {
                        value = ((Toppings)product).getBase().getQuantity();
                    } else {
                        value = product.getQuantity();
                    }
                break;
        }
        return value;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) { return String.class; }
}