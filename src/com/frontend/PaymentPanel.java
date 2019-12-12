package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import java.awt.*;

public class PaymentPanel extends JPanel {

    private JLabel totalDueLabel;
    public PaymentPanel() {
        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        totalDueLabel = new JLabel();
        JLabel paymentAmountLabel = new JLabel("Payment amount");
        JLabel changeLabel = new JLabel("Change");
        JTextField inputAmountDueField = new JTextField();

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BoxLayout(inputPanel, BoxLayout.PAGE_AXIS));
        inputPanel.add(totalDueLabel, BoxLayout.X_AXIS);
        inputPanel.add(inputAmountDueField, BoxLayout.X_AXIS);


        inputAmountDueField.setMaximumSize(new Dimension(Integer.MAX_VALUE, inputAmountDueField.getPreferredSize().height));
        JButton processPaymentButton = new JButton();
        this.add(inputPanel, BoxLayout.X_AXIS);
        this.add(paymentAmountLabel, BoxLayout.X_AXIS);
        //this.add(Box.createHorizontalBox());
        //this.add(changeLabel, BoxLayout.X_AXIS);
    }

    public JLabel getTotalDueLabel() {
        return totalDueLabel;
    }
}
