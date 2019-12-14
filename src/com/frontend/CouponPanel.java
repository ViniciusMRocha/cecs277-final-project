package com.frontend;

import com.sale.Sale;

import javax.swing.*;
import java.awt.*;

public class CouponPanel extends JPanel {

    private JLabel totalDueLabel;
    public CouponPanel() {
        this.setLayout(new BorderLayout());

        totalDueLabel = new JLabel("Total due: ");
        totalDueLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        JLabel changeLabel = new JLabel("Change");
        changeLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        JPanel inputFieldPanel = new JPanel();

        JSpinner paymentInputField = new JSpinner();
        SpinnerNumberModel snm = new SpinnerNumberModel(0.0, 0.0, 9999.0, 0.01);
        //JSpinner.NumberEditor spinnerEditor = new JSpinner.NumberEditor(paymentInputField, "0.00");
        paymentInputField.setModel(snm);
        //paymentInputField.setEditor(spinnerEditor);

        JButton processPaymentButton = new JButton("Pay balance");
        processPaymentButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        JPanel paymentInformationPanel = new JPanel();

        inputFieldPanel.setLayout(new BoxLayout(inputFieldPanel, BoxLayout.Y_AXIS));
        inputFieldPanel.setBorder(BorderFactory.createTitledBorder("Payment amount"));

        inputFieldPanel.add(totalDueLabel);
        inputFieldPanel.add(paymentInputField);
        inputFieldPanel.add(processPaymentButton);
        inputFieldPanel.add(changeLabel);

        paymentInformationPanel.setLayout(new BorderLayout());
        paymentInformationPanel.add(inputFieldPanel, BorderLayout.NORTH);
        paymentInformationPanel.add(changeLabel, BorderLayout.SOUTH);


        this.add(paymentInformationPanel, BorderLayout.NORTH);
        //this.add(Box.createHorizontalBox());
        //this.add(changeLabel, BoxLayout.X_AXIS);
    }

    public void setTotalDueLabel(Sale sale) {
        totalDueLabel.setText("Total due: " + sale.getFormattedTotalPrice());
    }
}
