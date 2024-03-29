package com.frontend;

import com.sale.Coupon;
import com.sale.Sale;
import com.sale.coupontypes.CouponTypes;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * Creates the panel for processing the payment
 */
public class PaymentPanel extends JPanel {

    private Sale createdSale;
    private SaleHistoryTable dailySalesTable;
    private JLabel totalDueLabel;
    private JLabel changeDueLabel;
    private ArrayList<JCheckBox> couponCheckBoxes;
    private JSpinner paymentInputField;
    private SaleDetailsWindow saleDetailsWindow;

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


    /**
     * Method that takes in a sale and creates the panel
     * @param createdSale Sale
     * @param dailySalesTable SaleHistoryTable
     * @param saleDetailsWindow SaleDetailsWindow
     */
    public PaymentPanel(Sale createdSale, SaleHistoryTable dailySalesTable, SaleDetailsWindow saleDetailsWindow) {
        this.createdSale = createdSale;
        this.saleDetailsWindow = saleDetailsWindow;
        this.dailySalesTable = dailySalesTable;
        this.setLayout(new BorderLayout());
        initializeCheckBoxArrayLists();

        JPanel couponSelectionPanel = new JPanel();
        couponSelectionPanel.setBorder(BorderFactory.createTitledBorder("Select the coupons you'd like to apply"));

        for(JCheckBox box : couponCheckBoxes) {
            couponSelectionPanel.add(box);
        }

        totalDueLabel = new JLabel("Total due: ");
        totalDueLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        changeDueLabel = new JLabel("Change due: ");
        changeDueLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        JPanel inputFieldPanel = new JPanel();

        paymentInputField = new JSpinner();
        SpinnerNumberModel snm = new SpinnerNumberModel(0.0, 0.0, 9999.0, 0.01);
        paymentInputField.setModel(snm);

        JButton processPaymentButton = new JButton("Pay balance");
        processPaymentButton.addActionListener(new PayBalanceButtonActionListener());
        processPaymentButton.setAlignmentX(JComponent.CENTER_ALIGNMENT);
        JPanel paymentInformationPanel = new JPanel();

        inputFieldPanel.setLayout(new BoxLayout(inputFieldPanel, BoxLayout.Y_AXIS));
        inputFieldPanel.setBorder(BorderFactory.createTitledBorder("Finalize payment"));

        inputFieldPanel.add(totalDueLabel);
        inputFieldPanel.add(changeDueLabel);
        inputFieldPanel.add(couponSelectionPanel);
        inputFieldPanel.add(paymentInputField);
        inputFieldPanel.add(processPaymentButton);

        paymentInformationPanel.setLayout(new BorderLayout());
        paymentInformationPanel.add(inputFieldPanel, BorderLayout.NORTH);

        this.add(paymentInformationPanel, BorderLayout.NORTH);
    }

    /**
     * Sets the total amount due for the sale
     * @param sale Sale
     */
    public void setTotalDueLabel(Sale sale) {
        totalDueLabel.setText("Total due: " + sale.getFormattedTotalPrice());
    }

    /**
     * This method updates the change label with the appropriate amount of change given for the transaction
     */
    private void updateChangeLabel() {
        double changeDue = (double)paymentInputField.getValue() - createdSale.getTotalPrice();
        changeDueLabel.setText("Change due: " + String.format("$%.2f", changeDue));
    }

    /**
     * Class that implements when the Pay Balance Button gets clicked
     */
    class PayBalanceButtonActionListener implements ActionListener {
        /**
         * process the payment and gives the change or returns error message if amount is not enough
         * @param e ActionEvent
         */
        @Override
        public void actionPerformed(ActionEvent e) {
            double paymentAmountInput = (double)paymentInputField.getValue();
            ((JTabbedPane)getParent()).setEnabledAt(2, true);
            if(paymentAmountInput < createdSale.getTotalPrice())
                JOptionPane.showMessageDialog(null, "That isn't enough money to cover the total cost!");
            else {
                updateChangeLabel();
                createdSale.setReceiptNumber();
                dailySalesTable.getSales().add(createdSale);
                SaleTableModel newTableModel = new SaleTableModel(dailySalesTable.getSales());
                dailySalesTable.updateTableModel(newTableModel);
            }
        }
    }

    /**
     * Class that implements when CheckBoxes gets selected
     */
    class CheckBoxActionListener implements ActionListener {

        /**
         * Handles for when the discount checkboxes are selected to apply the coupons accordantly
         * @param e ActionEvent
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
            createdSale.setCouponsInSale(couponsSelected);
            setTotalDueLabel(createdSale);
        }
    }
}
