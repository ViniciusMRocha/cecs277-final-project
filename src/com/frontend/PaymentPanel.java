package com.frontend;

import com.decorator.toppings.drinktoppings.DrinkToppings;
import com.sale.Sale;
import com.sale.coupontypes.CouponTypes;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

public class PaymentPanel extends JPanel {

    private Sale createdSale;
    private JLabel totalDueLabel;
    private ArrayList<JCheckBox> couponCheckBoxes;
    /**
     * Initializes ArrayLists for the Tea toppings and Coffee toppings.
     */
    private void initializeCheckBoxArrayLists() {
        couponCheckBoxes = new ArrayList<>();
        for(CouponTypes coupon : CouponTypes.values()) {
            couponCheckBoxes.add(new JCheckBox(coupon.toString()));
        }
    }
    public PaymentPanel(Sale createdSale) {
        this.createdSale = createdSale;
        this.setLayout(new BorderLayout());
        initializeCheckBoxArrayLists();

        JPanel couponSelectionPanel = new JPanel();
        couponSelectionPanel.setBorder(BorderFactory.createTitledBorder("Select the coupons you'd like to apply"));

        for(JCheckBox box : couponCheckBoxes) {
            couponSelectionPanel.add(box);
        }

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
        inputFieldPanel.setBorder(BorderFactory.createTitledBorder("Finalize payment"));

        inputFieldPanel.add(totalDueLabel);
        inputFieldPanel.add(couponSelectionPanel);
        inputFieldPanel.add(paymentInputField);
        inputFieldPanel.add(processPaymentButton);
        inputFieldPanel.add(changeLabel);

        paymentInformationPanel.setLayout(new BorderLayout());
        paymentInformationPanel.add(inputFieldPanel, BorderLayout.NORTH);
        paymentInformationPanel.add(changeLabel, BorderLayout.SOUTH);


        this.add(paymentInformationPanel, BorderLayout.NORTH);
    }

    public void setTotalDueLabel(Sale sale) {
        totalDueLabel.setText("Total due: " + sale.getFormattedTotalPrice());
    }
}
