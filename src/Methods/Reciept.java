/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Methods;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;


public class Reciept {
        public static void showReceiptPanel(JPanel receiptPanel, DefaultTableModel tableModel, JLabel[] nameLabels, JLabel[] qLabels, JLabel[] aLabels) {
        try {
            for (int i = 0; i < nameLabels.length; i++) {
                if (i < tableModel.getRowCount() && tableModel.getColumnCount() >= 3) {
                    nameLabels[i].setText(tableModel.getValueAt(i, 0).toString());
                    qLabels[i].setText(tableModel.getValueAt(i, 1).toString());
                    aLabels[i].setText(tableModel.getValueAt(i, 2).toString());
                } else {
                    nameLabels[i].setText("");
                    qLabels[i].setText("");
                    aLabels[i].setText("");
                }
            }
            // Debugging output to verify labels are updated
            for (int i = 0; i < nameLabels.length; i++) {
                System.out.println("Label " + i + ": " + nameLabels[i].getText() + ", " + qLabels[i].getText() + ", " + aLabels[i].getText());
            }

            receiptPanel.revalidate();
            receiptPanel.repaint();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.err.println("Error: Attempted to access a row or column out of table bounds: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}
