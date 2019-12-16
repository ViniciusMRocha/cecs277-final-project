package com.frontend;

import com.sale.Coupon;
import com.sale.Sale;
import com.sale.coupontypes.CouponTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PaymentPanel extends JPanel {

    private Sale createdSale;
    private JLabel totalDueLabel;
    private ArrayList<JCheckBox> couponCheckBoxes;
    private JSpinner paymentInputField;

    /**
     * Initializes ArrayLists for the coupon options.
     */
    private void initializeCheckBoxArrayLists() {
        couponCheckBoxes = new ArrayList<>();
        for(CouponTypes coupon : CouponTypes.values()) {
            JCheckBox couponCheckBox = new JCheckBox(coupon.toString());
            couponCheckBox.addActionListener(new CheckBoxActionListener());
            couponCheckBox.setToolTipText(coupon.getCouponDescription());
            couponCheckBoxes.add(couponCheckBox);
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

        paymentInputField = new JSpinner();
        SpinnerNumberModel snm = new SpinnerNumberModel(0.0, 0.0, 9999.0, 0.01);
        //JSpinner.NumberEditor spinnerEditor = new JSpinner.NumberEditor(paymentInputField, "0.00");
        paymentInputField.setModel(snm);
        //paymentInputField.setEditor(spinnerEditor);

        JButton processPaymentButton = new JButton("Pay balance");
        processPaymentButton.addActionListener(new PayBalanceButtonActionListener());
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


    class PayBalanceButtonActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            double paymentAmountInput = (double)paymentInputField.getValue();
            if(paymentAmountInput < createdSale.getTotalPrice())
                JOptionPane.showMessageDialog(null, "That isn't enough money to cover the total cost!");
            else {
                double change = paymentAmountInput - createdSale.getTotalPrice();
                JOptionPane.showMessageDialog(null, "Change: $" + change);
            }
        }
    }
    class CheckBoxActionListener implements ActionListener {

        /**
         * Invoked when an action occurs.
         *
         * @param e the event to be processed
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            ArrayList<Coupon> couponsSelected = new ArrayList<>();

            for(JCheckBox checkBox : couponCheckBoxes) {
                if(checkBox.isSelected()) {
                    System.out.println(checkBox.getText() + " is now selected!");
                    CouponTypes selectedCoupons = CouponTypes.getEnumValueFromString(checkBox.getText());
                    couponsSelected.add(CouponTypes.getCouponFromEnumValue(selectedCoupons));
                }
            }
            createdSale = new Sale(createdSale.getItemsInSale(), couponsSelected);
            setTotalDueLabel(createdSale);
        }
    }
}
