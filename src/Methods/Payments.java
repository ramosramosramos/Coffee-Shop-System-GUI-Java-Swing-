/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author User
 */
public class Payments {

    static Connection conn = coffee_shop.javaConnection.database();

    public static void processPayment(DefaultTableModel model) {
        try (PreparedStatement pst = conn.prepareStatement(
                "INSERT INTO PreviousCoffeeTable (item_name, item_quantity, item_amount) VALUES (?, ?, ?)")) {
            for (int i = 0; i < model.getRowCount(); i++) {
                pst.setObject(1, model.getValueAt(i, 0));
                pst.setObject(2, model.getValueAt(i, 1));
                pst.setObject(3, model.getValueAt(i, 2));
                pst.addBatch();
            }
            pst.executeBatch();
            System.out.println("Yes");
        } catch (SQLException e) {

            JOptionPane.showMessageDialog(null, "Database error: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

            System.err.println(e);
        }
    }
    
    public static void caculatePayment(DefaultTableModel model,String cash,JLabel totalValue,JLabel balanceLabel,JLabel cashValue,
            double cashDouble,double totalDouble,String IP_ADDRESS,String SEND_TO){
        coffee_shop.mainFrame main = new coffee_shop.mainFrame();
        if (totalValue.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please order first or click order summary");
            return;
        }
        if (Double.parseDouble(totalValue.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Please order first or click order summary");
            return;
        }

        main.onGlass();
        cash = JOptionPane.showInputDialog(null, "Cash:", "Pay", JOptionPane.PLAIN_MESSAGE);
        main.offGlass();

        if (cash == null || cash.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a valid cash amount.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        try {
            cashDouble = Double.parseDouble(cash);
            totalDouble = Double.parseDouble(totalValue.getText().replace("₱", ""));
            double balanceDouble = cashDouble - totalDouble;
            balanceLabel.setText("₱" + balanceDouble);
            cashValue.setText("₱" + cashDouble);

            if (cashDouble - totalDouble >= 0.01) {
                Methods.Payments.processPayment(model);
                Tools.IP.SendMessage(IP_ADDRESS, SEND_TO,"New payment has been made: Total amount:"+totalDouble, true);
            } else {
                JOptionPane.showMessageDialog(null, "Insufficient cash amount.", "Warning", JOptionPane.WARNING_MESSAGE);
            }

        } catch (NumberFormatException e) {
            main.onGlass();
            JOptionPane.showMessageDialog(null, "Invalid input cash: " + cash, "Warning", JOptionPane.ERROR_MESSAGE);
            main.offGlass();
            System.err.println(e);
        }
    }
}
