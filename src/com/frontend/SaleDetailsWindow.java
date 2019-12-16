package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import java.awt.*;
import java.util.Collection;

class SaleDetailsWindow extends JPanel {

    private JTable orderDetails;
    private JLabel totalCostLabel;
    private Sale sale;

    SaleDetailsWindow(Sale sale) {
        super(new BorderLayout());
        this.sale = sale;
        orderDetails = new JTable();
        System.out.println("Here");
        JPanel panel2 = new JPanel(new BorderLayout());
        totalCostLabel = new JLabel("Order details - Subtotal: " + sale.getTotalPrice());
        totalCostLabel.setHorizontalAlignment(SwingConstants.CENTER);
        orderDetails.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);


        panel2.add(totalCostLabel, BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(orderDetails);
        panel2.add(scrollPane, BorderLayout.CENTER);
        add(panel2);
    }

    JTable getOrderDetails() {
        return orderDetails;
    }

    void updateTableModel(SaleDetailsTableModel tableModel) {
        System.out.println("Updated table model!");
        orderDetails.setModel(tableModel);
        orderDetails.repaint();
    }

    public void setSale(Sale sale) {
        this.sale = sale;
    }

    void updateTotalCostLabel() {
        totalCostLabel.setText("Order details - Subtotal: " + sale.getFormattedTotalPrice());
    }

    void resetWindow() {
        Sale newSale = new Sale();
        sale = newSale;
        //SaleDetailsTableModel sdtm = new SaleDetailsTableModel(newSale);
        //updateTableModel(sdtm);
        updateTotalCostLabel();
    }

    public Sale getSale() {
        return sale;
    }
}